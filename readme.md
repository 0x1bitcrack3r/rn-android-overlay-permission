[0x1bitcrack3r](https://0x1bitcrack3r.me)

# rn-android-overlay-permission

This module is used to request screen overlay permission from the user in a react-native based Android application.

## Getting started

To install the module, run the following command:

```shell
$ npm install rn-android-overlay-permission --save
```

### Automatic installation

To automatically link the module, run the following command:

```shell
$ react-native link rn-android-overlay-permission
```

### Manual installation

#### Android

For Java developers, open `android/app/src/main/java/[...]/MainActivity.java`. For Kotlin developers, open `android/app/src/main/java/[...]/MainActivity.kt`.

Add the following import statement at the top of the file:

```java
import com.overlaypermission.OverlayPermissionPackage;
```

Append the following lines to `android/settings.gradle`:

```groovy
include ':rn-android-overlay-permission'
project(':rn-android-overlay-permission').projectDir = new File(rootProject.projectDir, '../node_modules/rn-android-overlay-permission/android')
```

Insert the following line inside the dependencies block in `android/app/build.gradle`:

```groovy
implementation project(':rn-android-overlay-permission')
```

## Usage

To navigate to the permission settings, use the following code:

```javascript
import OverlayPermissionModule from "rn-android-overlay-permission";

OverlayPermissionModule.requestOverlayPermission();
```

To check if the overlay permission is granted and display an alert, use the following code:

```javascript
import OverlayPermissionModule from "rn-android-overlay-permission";
import { Platform, Alert } from "react-native";

if (Platform.OS === "android") {
  OverlayPermissionModule.isRequestOverlayPermissionGranted((status: any) => {
    if (status) {
      Alert.alert(
        "Permissions",
        "Overlay Permission",
        [
          {
            text: "Cancel",
            onPress: () => console.log("Cancel Pressed"),
            style: "cancel",
          },
          {
            text: "OK",
            onPress: () => OverlayPermissionModule.requestOverlayPermission(),
          },
        ],
        { cancelable: false }
      );
    }
  });
}
```
