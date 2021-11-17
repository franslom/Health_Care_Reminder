package com.sourcey.materiallogindemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Franci Suni on 01/12/16.
 */
public class Alarm_Receiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("We are in receiver", "way");

        String get_string_key=intent.getExtras().getString("extra");
        Log.e("What is the key", get_string_key);

        Intent service_intent=new Intent(context, RingtonePlayingService.class);
        service_intent.putExtra("extra",get_string_key);
        context.startService(service_intent);

    }
}
