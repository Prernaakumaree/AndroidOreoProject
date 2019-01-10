# AndroidExampleProject

An example project demonstrating Android Job Service, Intent Job Service and Foreground service on android Oreo and above.

DebugView
Use DebugView to validate your analytics configuration during development.
To conserve network data and battery life on mobile devices, Analytics deployments poll usage data periodically – usually once per hour. However, during development, it’s helpful to see events immediately so you can make adjustments without having to wait. DebugView lets you monitor your app's events in real time.

Getting started
To use DebugView, you must first enable Debug mode on your device:

Android
To enable Analytics Debug mode on an emulated Android device, execute the following command line:

adb shell setprop debug.firebase.analytics.app <package_name>

This behavior persists until you explicitly disable Debug mode by executing the following command line:

adb shell setprop debug.firebase.analytics.app .none.