# DAA-AppWidget

## Introduction
Dans le cadre du cours DAA (Développement d'Applications Android) de la HEIG-VD, nous devons explorer et étudier une fonctionnalitée avancée d'Android. Nous avons choisi d'étudier les `AppWidgets`. Ce travail est réalisé en groupe de 3 personnes.

## Auteurs
* Stéphane Marengo
* Géraud Silverstri
* Jonathan Friedli


## Fonctionnalité

## Description
Les Widgets sont une sorte de vue d'une application concrète. Ils reprennent souvent la fonctionnalité principale et nous permettent de l'utiliser sans ouvrir l'application. Souvent utilisé dans l'écran d'accueil, ils peuvent être customisé et déplacé. Ils peuvent également être présent sur les écrans vérouillés ainsi que dans les notifications.

Exemple:
![Exemple de widget](doc/accueil.jpg)
Ici, nous avons un widget de l'application "horloge" donnant l'heure et la date. Nous pouvons cliquer dessus afin d'ouvrir ladite application.

Il existe plusieurs types de widgets:
* Les widgets d'informations, comme celui de l'horloge, vont afficher des informations et leurs changements. D'autres exemple de Widgets d'information sont les widgets de météo, de nouvelles et de résultats sportifs.

* Les widgets de contrôle, comme le widget de spotify, vont permettre certaines interactions. Dans le cas du widget de spotify, nous pouvons changer de musiquer, mettre la musique sur play/pause ou encore dire que nous aimes cette musique. 
![Widget spotify](doc/spotifyWidget.jpg)
Un autre exemple de widget de contrôle est le widget du curseur de volume permettant de gérer les différents niveau sonores de notre téléphone.

* Les widgets de collection, comme le widget de la Todo-liste , vont afficher une liste d'éléments. Nous pourrons ensuite les cocher ou les supprimer une fois qu'ils sont terminés.

### But

### Problèmes résolus

### Utilisation

### Limitations
Un widget a plusieurs limitations.

* Gestes utilisateurs : Les widgets étant sur l'écran d'accueil, ils doivent co-exister avec la navigation existante, ce qui limite les gestes disponibles. Les 2 seuls gestes que peuvent implémenter un widget sont le click et le swipe vertical.

* Fréquence de mise à jour : Un widget ne peut être mis à jour 1 fois par minute au maximum. Ceci les rends peut pratique pour représenter des événements en temps réel.

* Taille : Les widgets ont une taille fixe, ce qui limite leur utilité.

### Approches alternatives

* Notifications : Les notifications sont une alternative aux widgets. Elles sont plus flexibles et peuvent être utilisées pour afficher des informations en temps réel. Elles peuvent aussi être modifiées pour intégrer des éléments interactifs.

* Live wallpaper

* Raccourcis

### Points importants

### Sources
[Documentation officielle d'Android sur les App Widgets](https://developer.android.com/develop/ui/views/appwidgets/overview)