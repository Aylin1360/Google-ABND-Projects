# News App

This app fetching data from Guardian and gives you an option about sorting. Made for Google's android basics nanodegree.

## Deployment
Download or Clone this repo, choose your device and run it.

## Functionality

* Settings Activity <br /> 
Settings Activity is accessed from the Main Activity via a Navigation Drawer or from the toolbar menu.

* API Query <br />
App queries the content.guardianapis.com API to fetch news stories related to the topic chosen by the user, using either the ‘test’ api key or the student’s key. <br />
The query is narrowed down by the preferences selected by the user in the Settings.

* Use of Loaders <br />
Networking operations are done using a Loader rather than an AsyncTask.

* External Libraries and Packages <br />
The intent of this project is to give you practice writing raw Java code using the necessary classes provided by the Android framework; therefore, the use of external libraries for the core functionality will not be permitted to complete this project.

## Built With
* Android Studio - Android Development IDE.

## Acknowledgments

* Connecting to an API
* Parsing the JSON response
* Handling error cases gracefully
* Updating information regularly
* Using an AsyncTask
* Doing network operations independent of the Activity lifecycle
* Implement the Preference Fragment
* Launch a Settings Activity from a menu in the Main Activity
* Use Uri.Builder class to add query parameters to the URL
* Update and display the Preference Summary

<p align="center">
  <img src="https://user-images.githubusercontent.com/34216243/87229603-0c872580-c3b2-11ea-82db-ee7b3236e48f.gif">
</p>
