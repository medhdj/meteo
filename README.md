# meteo
A sample Android app, implemented using Clean architecture principles.
This project is largely inspired by the work done by [Fernando Cejas](https://github.com/android10/)

## Requirements

* JDK 1.7+
* Android Studio 3.0.x
* [Android SDK](https://developer.android.com/studio/index.html)
* Android O ([API 27](https://developer.android.com/about/versions/oreo/android-8.1.html))
* Latest Android SDK Tools and build tools.

## Initial setup
1. create a file named "keystore.properties" and place it at the root of the [data](https://github.com/medhdj/meteo/tree/master/data) module
2. add your OpenWeatherMap api key to the file using the format: ```OpenWeatherMapApiKey = "YOUR_API_KEY" ```
3. rebuild the project.

## Languages, libraries and tools used
* Android Support Libraries
* [RxJava2](https://github.com/ReactiveX/RxJava)
* [Retrofit](http://square.github.io/retrofit/)
* [OkHttp](http://square.github.io/okhttp/)
* [Gson](https://github.com/google/gson)
* [Apache commons](https://commons.apache.org/proper/commons-lang/)
* [RxAndroid](https://github.com/ReactiveX/RxAndroid)
* And other libs: check [dependencies.gradle](https://github.com/medhdj/meteo/blob/master/buildsystem/dependencies.gradle)

## Project architecture
![architecture](https://github.com/medhdj/mailSignature/blob/master/meteo_project_arch.png?raw=true)
