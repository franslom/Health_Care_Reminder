package com.sourcey.materiallogindemo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Franci Suni on 30/08/16.
 */
public class Alarm implements Serializable {
    long id;
    long id_pill;
    String time;

    public Alarm(){}
    public Alarm(long id, long id_pill, String time)
    {
        this.id=id;
        this.id_pill=id_pill;
        this.time=time;
    }
    //getter
    public long getId() {
        return id;
    }

    public long getId_pill() {
        return id_pill;
    }

    public String getTime() {
        return time;
    }
    //setter

    public void setId(long id) {
        this.id = id;
    }

    public void setId_pill(long id_pill) {
        this.id_pill = id_pill;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
