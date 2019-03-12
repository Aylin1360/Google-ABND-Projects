# MusicApp

Music app made with Android Studio. Made for Udacity Google's android basics nanodegree.

*Used language: Java*

## App Design 
* Suitability <br /> 
The app’s structure is suitable for a music player app. A similarly structured app which focuses on audiobooks, podcasts, or other audio media.

* Clarity <br />
The purpose of each activity is easy for a user to understand through the UI design and feature labeling.

* Number of Activities <br />
The app contains 2 to 6 activities.

## Layout

* Structure <br />
The app contains multiple activities, each labelled, which together make a cohesive music app.

* Labelling <br />
Features in the app are clearly defined either by labelling or images. For example, a button to play music could use a universally recognized triangular "Play" symbol or could have the text label "Play".

*Buttons <br />
Each activity contains button(s) which link it to other activities a user should be able to reach from that activity. For instance, a ‘Library’ activity might contain a button to move to the ‘Now Playing’ activity.

## Functionality

*Runtime Errors <br />
The code runs without errors.

* OnClickListeners <br />
Each button’s behavior is determined by an OnClickListener in the Java code rather than by the android:onClick attribute in the XML Layout.

* Intents <br />
Each button properly opens the intended activity using an explicit Intent.

* Custom Adapter <br />
App uses a custom adapter to populate the layout with views based on instances of the custom class.

* Data Storage and Retrieval <br />
Information about instances of the custom class are stored in an appropriate data structure (e.g. ArrayList, Array).
When the information needs to be displayed, it is efficiently retrieved (e.g. Looping).

* Custom Class <br />
Data about each song (or equivalent audio media such as podcast episode) should be stored in a custom class that contains at least 2 states (e.g. Song Name, Artist Name) <br />
If images are included (e.g. Album Art), they are stored as drawables. All drawables are stored at multiple densities. Images are not required.

## Deployment
Download or Clone this file, choose your device and run it.

## Built With
*Android Studio - IDE for Android Development.
