package com.codingblocks.firebase;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by championswimmer on 11/10/16.
 */

public class PandoraMessagingService extends FirebaseMessagingService {

    public static final String TAG = "MsgSrvc";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.d(TAG, "onMessageReceived: " + remoteMessage.getNotification().getTitle()
                + remoteMessage.getNotification().getBody());
    }
}
