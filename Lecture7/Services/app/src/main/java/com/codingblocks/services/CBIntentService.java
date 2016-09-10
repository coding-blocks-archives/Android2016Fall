package com.codingblocks.services;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

/**
 * Created by championswimmer on 10/09/16.
 */
public class CBIntentService extends IntentService {
    public static final String TAG = "CBSrvc";

    public static final String ACTION_LOOP = "loop";
    public static final String ACTION_NO_LOOP = "noloop";

    public static final String EXTRA_SEC = "sec";

    public static void startLoopAction (int loopLength, Context ctx) {
        Intent i = new Intent(ctx, CBIntentService.class);
        i.setAction(ACTION_LOOP);
        i.putExtra(EXTRA_SEC, loopLength);
        ctx.startService(i);
    }

    public static void startNoLoopAction (Context ctx) {
        Intent i = new Intent(ctx, CBIntentService.class);
        i.setAction(ACTION_NO_LOOP);
        ctx.startService(i);
    }



    public CBIntentService() {
        super("CB");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent.getAction().equals(ACTION_LOOP)) {
            switch (intent.getIntExtra(EXTRA_SEC, 5)) {
                case 10: tenSecLoop(); break;
                case 5:default: fiveSecLoop(); break;
            }
        }
        if (intent.getAction().equals(ACTION_NO_LOOP)) {
            noLoopFunc();
        }

    }

    public  void noLoopFunc() {
        Log.d(TAG, "noLoopFunc: ");
    }

    public  void tenSecLoop () {
        Log.d(TAG, "tenSecLoop: started");
        long startTime = SystemClock.uptimeMillis();
        while(SystemClock.uptimeMillis() < (startTime + 10000)) {

        }
        Log.d(TAG, "tenSecLoop: ended");
    }

    public  void fiveSecLoop () {
        Log.d(TAG, "fiveSecLoop: started");
        long startTime = SystemClock.uptimeMillis();
        while(SystemClock.uptimeMillis() < (startTime + 5000)) {

        }
        Log.d(TAG, "fiveSecLoop: ended");
    }
}
