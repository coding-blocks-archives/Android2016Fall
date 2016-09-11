package com.codingblocks.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by championswimmer on 11/09/16.
 */
public class PowerChangedReceiver extends BroadcastReceiver {

    private OnPowerChangedListener opcl;

    public interface OnPowerChangedListener {
        void onPowerChanged(boolean connected);
    }

    public void setOnPowerChangedListener(OnPowerChangedListener listener) {
        opcl = listener;
    }

    public static IntentFilter getIntentFilter () {
        IntentFilter pif = new IntentFilter();
        pif.addAction(Intent.ACTION_POWER_CONNECTED);
        pif.addAction(Intent.ACTION_POWER_DISCONNECTED);
        return pif;
    }


    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
            if (opcl != null) {
                opcl.onPowerChanged(true);
            }
        } else if (intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)) {
            if (opcl != null) {
                opcl.onPowerChanged(false);
            }
        }

    }
}
