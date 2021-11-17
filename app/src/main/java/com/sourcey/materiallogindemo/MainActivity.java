package com.sourcey.materiallogindemo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private static final int ADD=Menu.FIRST;
    private static final int DELETE=Menu.FIRST+1;
    private static final int EXIST=Menu.FIRST+2;
    Database db;
    ListView lista;
    List<String> item=null;
    String getTitle;

    //persuasiveness variables
    private double eda;
    private double pa;
    private double temp;
    private double risk_level;
    private int persuasivenees_level;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Login Activity
        //Intent intent = new Intent(this, LoginActivity.class);
        //startActivity(intent);
        //Database*/
        db = new Database(getApplicationContext());
        eda=4.5;
/*
        Care_giver f=new Care_giver(001,"Luis","jofhlean@gmail.com","979446642");
        long family1_id = db.createCare_giver(f);

        Care_receiver u=new Care_receiver(001,"Franci",23,"Male",family1_id,5);
        long user1_id = db.createCare_receiver(u);

        Pill p1=new Pill(001,user1_id,1,"Amoxicilina",15,"LMMJVSB");
        long pill1_id=db.createPill(p1);

        Pill p2=new Pill(001,user1_id,1,"Paracetamol",15,"LMMJVSB");
        long pill2_id=db.createPill(p2);

        Pill p3=new Pill(001,user1_id,1,"Aspirina",15,"LMMJVSB");
        long pill3_id=db.createPill(p3);*/

       /* Alarm a1=new Alarm(001,pill1_id,"06:00");
        long alarm1_id=db.createAlarm(a1);

        Alarm a2=new Alarm(001,pill1_id,"12:00");
        long alarm2_id=db.createAlarm(a2);

        Alarm a3=new Alarm(001,pill1_id,"18:00");
        long alarm3_id=db.createAlarm(a3);

        Alarm a4=new Alarm(001,pill1_id,"24:00");
        long alarm4_id=db.createAlarm(a4);


        Alarm a11=new Alarm(001,pill2_id,"06:00");
        long alarm11_id=db.createAlarm(a11);

        Alarm a12=new Alarm(001,pill2_id,"12:00");
        long alarm12_id=db.createAlarm(a12);

        Alarm a13=new Alarm(001,pill2_id,"18:00");
        long alarm13_id=db.createAlarm(a13);


        Alarm a21=new Alarm(001,pill3_id,"06:00");
        long alarm21_id=db.createAlarm(a21);

        Alarm a22=new Alarm(001,pill3_id,"12:00");
        long alarm22_id=db.createAlarm(a22);

        Alarm a23=new Alarm(001,pill3_id,"18:00");
        long alarm23_id=db.createAlarm(a23);*/

        //showPills();
        TextView t=(TextView) findViewById(R.id.textView);
        //(int) fuzzifier(eda)
        String strI = Double.toString(fuzzifier(eda));
        t.setText(strI);
        BPN n;
        n.main("sdf","dsdf");

    }

    private void showPills()
    {
        db=new Database(this);
        List<Pill> all = db.getPills();
        item=new ArrayList<String>();
        for (Pill a : all) {
            item.add(a.getName());
        }
        ArrayAdapter<String> adaptador=
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1,item);
        lista.setAdapter(adaptador);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//Start new botton
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case android.R.id.home: //hago un case por si en un futuro agrego mas opciones
                Log.i("ActionBar", "Atrás!");
                finish();
                return true;
            case R.id.menu_item_new:
                Intent intent = new Intent(this, PillActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
      /*  int id = item.getItemId();
        if (id == R.id.menu_item_new) {

        }*/
        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        //return super.onOptionsItemSelected(item);
    }
    public double fuzzifier(double eda_){
        return 1/(1+Math.exp(-2*(eda_-4.5)));
    }

    public int compute_risk_level(float eda, float temp, float pa){
        //BackpropagationNet bpn;
        return 1;
    }

    public int compute_stress_level(){

        return 1;
    }


}
