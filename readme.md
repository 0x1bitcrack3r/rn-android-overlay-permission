[0x1bitcrack3r](https://0x1bitcrack3r.me)

# rn-android-overlay-permission

## React Native utility for managing Android overlay permissions optimized for accessibility-focused applications.

This lightweight module enables React Native apps to check and request overlay permissions (SYSTEM_ALERT_WINDOW) on Android devices. These permissions are crucial for apps that draw over other apps, especially those providing accessibility enhancements such as:

- Assistive overlays (e.g., magnifiers, screen readers, text-to-speech aids)

- Floating buttons or navigation aids for users with motor impairments

- Real-time user guidance or help tools for cognitive accessibility

If you're developing tools to support digital inclusion, this module helps streamline the permission flow and ensure a smoother, more compliant user experience.

## ✨ Features
- ✅ Check if overlay permission is currently granted

- 🔓 Prompt users to open the system settings to enable overlay access

- 🔄 Asynchronous API with Promise support for clean integration

- ♿️ Built with accessibility use-cases in mind

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

## ♿ Accessibility Use-Cases
This plugin is ideal for apps that:

- Display accessibility layers (e.g., custom focus indicators, reading overlays)

- Offer floating UI elements for users with physical disabilities

- Implement always-on-top assistive controls or gesture aids

Overlay permissions are a critical enabler for inclusive design. With rn-android-overlay-permission, you can ensure users are guided appropriately through the permission flow without breaking your accessibility goals.

## 📋 Requirements
- Android only (React Native)
- Requires API level 23 (Android 6.0) or higher

## 📄 License
MIT


