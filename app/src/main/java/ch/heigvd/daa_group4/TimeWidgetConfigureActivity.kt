package ch.heigvd.daa_group4

import android.app.Activity
import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.core.content.edit
import ch.heigvd.daa_group4.databinding.TimeWidgetConfigureBinding

/**
 * The configuration screen for the [TimeWidget] AppWidget.
 */
class TimeWidgetConfigureActivity : Activity() {
    companion object {
        private const val PREFS_NAME = "ch.heigvd.daa_group4.TimeWidget"
        private const val PREF_PREFIX_KEY = "appwidget_"

        internal fun saveOption(context: Context, appWidgetId: Int, is24: Boolean) {
            context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit {
                putBoolean(PREF_PREFIX_KEY + appWidgetId, is24)
            }
        }

        internal fun hasOption(context: Context, appWidgetId: Int): Boolean {
            val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            return prefs.contains(PREF_PREFIX_KEY + appWidgetId)
        }

        internal fun loadOption(context: Context, appWidgetId: Int): Boolean {
            val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            return prefs.getBoolean(PREF_PREFIX_KEY + appWidgetId, true)
        }

        internal fun deleteOption(context: Context, appWidgetId: Int) {
            context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit {
                remove(PREF_PREFIX_KEY + appWidgetId)
            }
        }
    }

    private var appWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID
    private var selectedRadio: RadioButton? = null

    private lateinit var binding: TimeWidgetConfigureBinding

    public override fun onCreate(icicle: Bundle?) {
        super.onCreate(icicle)

        // Set the result to CANCELED.  This will cause the widget host to cancel
        // out of the widget placement if the user presses the back button.
        setResult(RESULT_CANCELED)

        binding = TimeWidgetConfigureBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            selectedRadio = when (checkedId) {
                R.id.radio_12 -> binding.radio12
                R.id.radio_24 -> binding.radio24
                else -> null
            }
        }

        binding.addButton.setOnClickListener {
            val context = this@TimeWidgetConfigureActivity

            if (selectedRadio == null) {
                Toast.makeText(context, getString(R.string.no_radio_selected), Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            // When the button is clicked, store the radio locally
            saveOption(context, appWidgetId, selectedRadio?.id == R.id.radio_24)

            // It is the responsibility of the configuration activity to update the app widget
            val appWidgetManager = AppWidgetManager.getInstance(context)
            updateAppWidget(context, appWidgetManager, appWidgetId)

            // Make sure we pass back the original appWidgetId
            val resultValue = Intent()
            resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
            setResult(RESULT_OK, resultValue)
            finish()
        }

        // Find the widget id from the intent.
        val extras = intent.extras
        if (extras != null) {
            appWidgetId = extras.getInt(
                AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID
            )
        }

        // If this activity was started with an intent without an app widget ID, finish with an error.
        if (appWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
            finish()
            return
        }

        if (hasOption(this, appWidgetId)) {
            val is24 = loadOption(this, appWidgetId)
            selectedRadio = if (is24) binding.radio24 else binding.radio12
            selectedRadio?.isChecked = true
        }
    }

}