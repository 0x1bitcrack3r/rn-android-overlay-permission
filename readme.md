[0x1bitcrack3r](https://0x1bitcrack3r.me)

# rn-android-overlay-permission

This module is to request screen overlay permission from user in react-native based android application

## Getting started

`$ npm install rn-android-overlay-permission --save`

### Mostly automatic installation

`$ react-native link rn-android-overlay-permission`

### Add these permissions in AndroidManifest.xml

```javascript
<uses-permission android:name="android.permission.ACTION_MANAGE_OVERLAY_PERMISSION" />
<uses-permission android:name="android.permission.SYSTEM_ALERT_WINDOW" />
```

### Manual installation

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`

- Add `import com.overlaypermission.OverlayPermissionPackage;` to the imports at the top of the file

2. Append the following lines to `android/settings.gradle`:

   ```
       include ':rn-android-overlay-permission'
       project(':rn-android-overlay-permission').projectDir = new File(rootProject.projectDir, '../node_modules/rn-android-overlay-permission/android')
   ```

3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
   ```
       compile project(':rn-android-overlay-permission')
   ```

## Usage

```javascript
//requestOverlayPermission Navigates to permission settings
OverlayPermissionModule.requestOverlayPermission();
```

```javascript
import OverlayPermissionModule from "rn-android-overlay-permission";

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
