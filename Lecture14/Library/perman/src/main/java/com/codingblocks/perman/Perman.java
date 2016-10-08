package com.codingblocks.perman;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by championswimmer on 08/10/16.
 */

public class Perman {

    private static Activity sActivity;
    private static OnPermissionRequestResult permReqRes;

    public static void initialise (Activity act) {
        sActivity = act;
    }

    public interface OnPermissionRequestResult {
        void onGranted(String permission);
        void onDenied(String permission);
    }

    public static boolean checkPermission (String permission) {
        return ContextCompat.checkSelfPermission(sActivity, permission) == PackageManager.PERMISSION_GRANTED;
    }

    public static void requestPermission (String permission, OnPermissionRequestResult oprr) {
        ActivityCompat.requestPermissions(
                sActivity,
                new String[]{permission},
                11
        );
        permReqRes = oprr;
    }

    public static void onRequestPermissionsResult (int reqCode, String[] permissions, int[] grantResults) {
        if (reqCode == 11) {

            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    permReqRes.onGranted(permissions[i]);
                } else {
                    permReqRes.onDenied(permissions[i]);
                }
            }

            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                permReqRes.onGranted(permissions[0]);
            } else {
                permReqRes.onDenied(permissions[0]);
            }
        }
    }

}
