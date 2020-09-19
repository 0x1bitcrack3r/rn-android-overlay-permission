
package com.overlaypermission;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;

import androidx.annotation.RequiresApi;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;

import java.util.ArrayList;

public class OverlayPermissionModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;
    public OverlayPermissionModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "OverlayPermissionModule";
    }

    @ReactMethod
    public void requestOverlayPermission(Promise promise) {
        /**
         *  Before android 6.0 Marshmallow you dont need to ask for canDrawOverlays permission,
         *  but in newer android versions this is mandatory
         */
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(this.reactContext)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + this.reactContext.getPackageName()));
                this.reactContext.startActivityForResult(intent, 0, null);
            } else {
                promise.resolve(true);
            }
        }
        catch (Error e) {
            promise.reject(e);
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @ReactMethod
    public void isRequestOverlayPermissionGranted(Callback booleanCallback) {
        boolean equal=!Settings.canDrawOverlays(this.reactContext);
        booleanCallback.invoke(equal);
    }

}
