# GDG Nuremberg Android Community App
We'll use **Kotlins Multiplatform Project** to write a library with code that can be shared 
across multiple platforms. The list of supported platforms can be found [in the Kotlin documentation](https://kotlinlang.org/docs/reference/building-mpp-with-gradle.html#supported-platforms). 

## Project Layout
```
.
├── app // standard Android app project
├── iosApp // standard Swift iOS project
└── sharedcode // shared code library
    └── src
        ├── androidMain
        │   └── kotlin  // contains actual code for android
        ├── commonMain
        │   └── kotlin // contains shared code and declares expected platform code
        └── iosMain
            └── kotlin // contains actual code for iOS
```

You can find documentation about Platform-Specific Declarations (`expect` and `actual`) in the [Kotlin reference](https://kotlinlang.org/docs/reference/platform-specific-declarations.html).

## What To Share? 
Some examples, not exhaustive:
* `data` classes, JSON parsing
* Models
* Repositories
* Business Logic
* API client build e.g. with Ktor
* Utility classes

## What Libraries Can I Use? 
There's a [list with libraries](https://github.com/AAkira/Kotlin-Multiplatform-Libraries) that already are multiplatform-enabled.

## How To Get Started
After you have decided on the feature you want to add to the community app and the shared library:
* Create a folder where the actual app for your platform lives in (e.g. iosApp, webApp, desktopApp, ...)
* Create a kotlin file `sharedcode\commonMain\kotlin`, declare shared code as well as `expect` code and classes in there
* Create a kotlin file in e.g. `sharedcode\iosMain\kotlin` for each target with the same filename containing the `actual` platform specific implementation

## Don't Feel Creative Today?
Here are some stupid examples to kickstart your creativity:
* Use the NASA API to warn us from geomagnetic storms during our next meetup
* Create a voting and suggestion system for the next meetup topic
* Create a countdown and fetch infos for the next meetup
* Tell users about missed movie releases due to the next meetup (TMDB API)

**Get Crazy!**

## Resources
* [Kotlin Hands-On: Introduction to Kotlin Multiplatform](https://play.kotlinlang.org/hands-on/Introduction%20to%20Kotlin%20Multiplatform/01_Introduction)
* [Kotlin Hands-On: Targeting iOS and Android](https://play.kotlinlang.org/hands-on/Targeting%20iOS%20and%20Android%20with%20Kotlin%20Multiplatform/01_Introduction)
* [Kotlin Reference: Multiplatform Programming](https://kotlinlang.org/docs/reference/multiplatform.html]
* [Readme: Coroutines and multiplatform / native](https://github.com/Kotlin/kotlinx.coroutines/blob/master/README.md#multiplatform)
* [Tutorial: Kotlin Multiplatform Project for Android and iOS: Getting Started](https://www.raywenderlich.com/1022411-kotlin-multiplatform-project-for-android-and-ios-getting-started)
* [Tutorial: A practical Intro to Kotlin Multiplatform](https://www.bugsnag.com/blog/kotlin-multiplatform)

