package com.codingblocks.firebase;

import android.content.SharedPreferences;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by championswimmer on 11/10/16.
 */

public class PandoraIdService extends FirebaseInstanceIdService {

    public static final String TAG = "IdSrvc";

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "onTokenRefresh: " + refreshedToken);

        SharedPreferences sPref = getSharedPreferences("firebase", MODE_PRIVATE);
        sPref.edit().putString("refreshToken", refreshedToken).apply();

    }
}
