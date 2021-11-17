package com.sourcey.materiallogindemo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class AlarmActivity extends AppCompatActivity {
    //To make our alarm manager
    AlarmManager alarm_manager;

    TimePicker alarm_timepicker;
    TextView updatetext;
    Context context;
    PendingIntent pending_intent;


    boolean taken;
    int delta=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        this.context =this;
        alarm_manager=(AlarmManager) getSystemService(ALARM_SERVICE);

        alarm_timepicker=(TimePicker) findViewById(R.id.timePicker);
        updatetext =(TextView) findViewById(R.id.update_alarm);
        final Calendar calendar= Calendar.getInstance();

        final Intent intent=new Intent(this.context, Alarm_Receiver.class);


        this.taken=false;

        Button turn_on_alarm= (Button) findViewById(R.id.turn_on_alarm);
        turn_on_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar.set(Calendar.HOUR_OF_DAY,alarm_timepicker.getCurrentHour());
                calendar.set(Calendar.MINUTE,alarm_timepicker.getCurrentMinute());
                //get values
                int hour=alarm_timepicker.getCurrentHour();
                int minute=alarm_timepicker.getCurrentMinute();
                String string_hour=String.valueOf(hour);
                String string_minute=String.valueOf(minute);
                if(hour>12){
                    string_hour=String.valueOf(hour-12);
                }
                if(minute<10){
                    string_minute="0"+String.valueOf(minute);
                }

                set_alarm_text("Alarm set to " + string_hour + ":" + string_minute);

                //put extra string in intent for alarm_on
                intent.putExtra("extra", "alarm_on");
                intent.putExtra("tone", "alert");

                //current hour
                //pending_intent=PendingIntent.getBroadcast(AlarmActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
               // alarm_manager.setInexactRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pending_intent);

                //delta minutes before
                AlarmManager alarmMgr=(AlarmManager) getSystemService(ALARM_SERVICE);
                PendingIntent alarmIntent;
                Intent intent = new Intent(context, Alarm_Receiver.class);
                alarmIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
                calendar.set(Calendar.MINUTE,minute-delta);
                alarmMgr.set(AlarmManager.RTC_WAKEUP,
                        calendar.getTimeInMillis(),alarmIntent);


            }
        });


        Button turn_off_alarm= (Button) findViewById(R.id.turn_off_alarm);
        turn_off_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_alarm_text("Alarm off!");
                alarm_manager.cancel(pending_intent);
                intent.putExtra("extra","alarm_off");

                sendBroadcast(intent);
            }
        });




    }

    private void set_alarm_text(String output) {
        updatetext.setText(output);
    }
}
