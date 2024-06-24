### POCGoogleAdmob

## Overview
POCGoogleAdmob is a proof-of-concept project that demonstrates how to integrate Google AdMob into an Android application using Jetpack Compose. The project follows the MVI architecture to ensure a clean and maintainable codebase.

## Architecture
### MVI (Model-View-Intent)
- Model: Represents the data and business logic of the application. In this example, the AdMobManager class handles all interactions with the AdMob SDK.
- View: The UI layer, which displays the data and sends user actions to the ViewModel. In this project, Composable functions are used to build the UI.
- Intent: Represents user actions or events that are dispatched to the ViewModel. The AdmobViewModel processes these intents, updates the state, and manages the ad loading and displaying logic.

## AdMob Types
- Interstitial Ads: Full-screen ads that cover the interface of the app until closed by the user. They are typically displayed at natural transition points in the flow of an app.
- Banner Ads: Rectangular ads that occupy a spot within the app's layout. They can be positioned at the top or bottom of the screen and remain visible while the user interacts with the app.

## Classes and Data Structures
### AdMobManager
Handles loading and displaying of both interstitial and banner ads.

### AdmobViewModel
Manages the state and handles the logic for loading and displaying ads.

### AdmobState
Represents the state of the AdMob-related UI components.

### AdmobViewAction
Defines the possible actions related to AdMob that can be dispatched from the View to the ViewModel.

### Composable Function
The AdmobScreen composable function displays the UI and interacts with the ViewModel to load and show ads.