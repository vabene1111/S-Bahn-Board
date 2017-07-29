# S Bahn Board

SBahn Board is a little project to show the SBahn Berlin Departure Board inside a simple app.

It uses the API provieded by the [VBB](http://www.vbb.de/de/article/fahrplan/webservices/schnittstellen-fuer-webentwickler/5070.html)



## Install

To install the Project clone the repository and open it using the latest Android Studio Canary Build (alternativly change the gradle target).

After that, add the following class to the helper package.

```java
package de.droidenschmiede.sbahnboard.config;
 
 /**
  * Created by vabene on 27.07.2017.
  * Holder for API Key
  */
 
 public class ApiKey {
     public static final String API_KEY = "";
 }
```

As the VBB Api is not open to the public, you need to optain an API Key yourself and add paste it into the class.

Now you can build an APK file and deploy it on your Phone as you like.

## License

The content of this repository is licensed under the GNU GPLv3 as described in License.md