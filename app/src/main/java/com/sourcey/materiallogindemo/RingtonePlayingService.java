package com.sourcey.materiallogindemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.security.Provider;
import java.util.List;
import java.util.Map;

/**
 * Created by Franci Suni on 02/12/16.
 */
public class RingtonePlayingService extends Service{
    MediaPlayer media_song;
    int startId;
    boolean isRunning;

    @Nullable
    @Override

    public IBinder onBind(Intent intent) {
        return null;
    }
    public int onStartCommand(Intent intent, int flags, int startId){
        Log.i("LocalService","Received start id " +startId+":"+intent);

        //get key string
        String state=intent.getExtras().getString("extra");
        assert state !=null;
        switch (state){
            case "alarm_on":
                startId=1;
                break;
          /*  case "alarm_off":
                startId=0;
                break;*/
            default:
                startId=0;
                break;
        }
        //if there are not music and you want
        if(!this.isRunning && startId==1)
        {
            media_song=MediaPlayer.create(this, R.raw.alert);
            media_song.start();
            this.isRunning=true;
            this.startId=0;
        }
        //music playing and turn off
        else if (this.isRunning && startId==0)
        {
            media_song.stop();
            media_song.reset();
            this.isRunning=false;
            this.startId=0;
        }
        //music playing and turn on
        else if(this.isRunning &&startId==1)
        {
            this.isRunning=true;
            this.startId=1;
        }




        return START_NOT_STICKY;
    }
    @Override
    public void onDestroy(){
        Toast.makeText(this,"on Destroy called",Toast.LENGTH_SHORT).show();
    }
}
