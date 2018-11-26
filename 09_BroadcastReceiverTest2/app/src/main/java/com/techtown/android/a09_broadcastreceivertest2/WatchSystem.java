package com.techtown.android.a09_broadcastreceivertest2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;

public class WatchSystem extends BroadcastReceiver {


    int mCount = 0;

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        String act = intent.getAction();
        mCount++;

        if (act.equals(Intent.ACTION_BATTERY_CHANGED)) {
            Log.d("WatchSystem",
                    "BR" + mCount + ": ACTION_BATTERY_CHANGED "
                            + intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0)
                            + "%");
        } else if (act.equals(Intent.ACTION_BATTERY_LOW)) {
            Log.d("WatchSystem", "BR" + mCount + ": ACTION_BATTERY_LOW");
        }else if (act.equals(Intent.ACTION_BATTERY_OKAY)) {
            Log.d("WatchSystem", "BR" + mCount + ": ACTION_BATTERY_OKAY");
        } else if (act.equals(Intent.ACTION_POWER_CONNECTED)) {
            Log.d("WatchSystem", "BR" + mCount + ": ACTION_POWER_CONNECTED");
        } else if (act.equals(Intent.ACTION_POWER_DISCONNECTED)) {
            Log.d("WatchSystem", "BR" + mCount + ": ACTION_POWER_DISCONNECTED");
        } else if (act.equals(Intent.ACTION_MEDIA_MOUNTED)) {
            Log.d("WatchSystem", "BR" + mCount + ": ACTION_MEDIA_MOUNTED");
        } else if (act.equals(Intent.ACTION_MEDIA_UNMOUNTED)) {
            Log.d("WatchSystem", "BR" + mCount + ": ACTION_MEDIA_UNMOUNTED");
        }

    }
}
