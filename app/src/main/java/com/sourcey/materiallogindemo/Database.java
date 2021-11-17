package com.sourcey.materiallogindemo;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 31/08/2016.
 */
public class Database extends SQLiteOpenHelper {
    // Logcat tag
    private static final String LOG = "Database";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "healthcare";

    // Table Names
    private static final String TABLE_CARE_RECEIVER = "care_receiver";
    private static final String TABLE_CARE_GIVER = "care_giver";
    private static final String TABLE_ALARM = "alarm";
    private static final String TABLE_PILL = "pill";
    private static final String TABLE_BACKUP = "backup";

    //Key ids
    private static final String KEY_ID = "id";
    private static final String KEY_ID_CARE_GIVER = "id_care_giver";
    private static final String KEY_ID_PILL = "id_pill";
    private static final String KEY_ID_CARE_RECEIVER = "id_care_receiver";

    // Common column names
    private static final String KEY_NAME = "name";
    private static final String KEY_TIME = "time";

    //CARE_RECEIVER column names
    private static final String KEY_AGE = "age";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_DELTA = "delta";

    //CARE_GIVER column names
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_TYPE = "type";

    //Pill column names
    private static final String KEY_SCHEDULE = "schedule";
    private static final String KEY_DOSE = "dose";
    private static final String KEY_DAYS = "days";


    // Table Create Statements
    // CARE_RECEIVER table create statement
    private static final String CREATE_TABLE_CARE_RECEIVER = "CREATE TABLE IF NOT EXISTS " + TABLE_CARE_RECEIVER + " ( "
            + KEY_ID + " INTEGER primary key autoincrement, "
            + KEY_ID_CARE_GIVER + " INTEGER, "
            + KEY_NAME + " TEXT NOT NULL, "
            + KEY_AGE + " INTEGER NOT NULL, "
            + KEY_GENDER + " INTEGER NOT NULL, "
            + KEY_DELTA + " INTEGER NOT NULL)";

    // CARE_GIVER table create statement
    private static final String CREATE_TABLE_CARE_GIVER = "CREATE TABLE IF NOT EXISTS " + TABLE_CARE_GIVER + " ( "
            + KEY_ID + " INTEGER primary key autoincrement, "
            + KEY_NAME + " TEXT NOT NULL, "
            + KEY_EMAIL + " TEXT NOT NULL, "
            + KEY_PHONE + " TEXT NOT NULL, "
            + KEY_TYPE + " INTEGER NOT NULL) ";

    // Alarm table create statement
    private static final String CREATE_TABLE_ALARM = "CREATE TABLE IF NOT EXISTS " + TABLE_ALARM + " ( "
            + KEY_ID + " INTEGER primary key autoincrement, "
            + KEY_ID_PILL + " INTEGER, "
            + KEY_TIME + " TEXT NOT NULL) ";

    // Pill table create statement
    private static final String CREATE_TABLE_PILL = "CREATE TABLE IF NOT EXISTS " + TABLE_PILL + " ( "
            + KEY_ID + " INTEGER primary key autoincrement, "
            + KEY_ID_CARE_RECEIVER + " INTEGER, "
            + KEY_NAME + " TEXT NOT NULL, "
            + KEY_DOSE + " INTEGER, "
            + KEY_SCHEDULE + " INTEGER, "
            + KEY_DAYS + " BLOB NOT NULL) ";

    // Alarm table create statement
    private static final String CREATE_TABLE_BACKUP = "CREATE TABLE IF NOT EXISTS " + TABLE_BACKUP + " ( "
            + KEY_ID + " INTEGER primary key autoincrement, "
            + KEY_ID_PILL + " INTEGER, "
            + KEY_TIME + " TEXT NOT NULL) ";


    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL(CREATE_TABLE_CARE_RECEIVER);
        db.execSQL(CREATE_TABLE_CARE_GIVER);
        db.execSQL(CREATE_TABLE_ALARM);
        db.execSQL(CREATE_TABLE_PILL);
        db.execSQL(CREATE_TABLE_BACKUP);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CARE_RECEIVER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CARE_GIVER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ALARM);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PILL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BACKUP);
        // create new tables
        onCreate(db);
    }

    //Creating a Care_receiver
    public long createCare_receiver(Care_receiver u)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID_CARE_GIVER, u.getId_care_giver());
        values.put(KEY_NAME,u.getName());
        values.put(KEY_AGE,u.getAge());
        values.put(KEY_GENDER,u.getGender());
        values.put(KEY_DELTA,u.getDelta());
        long Care_receiver_id = db.insert(TABLE_CARE_RECEIVER, null, values);
        u.setId(Care_receiver_id);
        return Care_receiver_id;
    }
    //Creating a Care_giver
    public long createCare_giver(Care_giver u)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME,u.getName());
        values.put(KEY_EMAIL,u.getEmail());
        values.put(KEY_PHONE,u.getPhone());
        values.put(KEY_TYPE,u.getType());
        long Care_giver_id = db.insert(TABLE_CARE_GIVER, null, values);
        u.setId(Care_giver_id);
        return Care_giver_id;
    }
    //Creating a alarm
    public long createAlarm(Alarm u)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID_PILL, u.getId_pill());
        values.put(KEY_TIME,u.getTime());
        long alarm_id = db.insert(TABLE_ALARM, null, values);
        u.setId(alarm_id);
        return alarm_id;
    }
    //Creating a Pill
    public long createPill(Pill u)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID_CARE_RECEIVER, u.getId_care_receiver());
        values.put(KEY_NAME,u.getName());
        values.put(KEY_DOSE,u.getDose());
        values.put(KEY_SCHEDULE,u.getSchedule());
        values.put(KEY_DAYS,u.getDays());
        long pill_id = db.insert(TABLE_PILL, null, values);
        u.setId(pill_id);
        return pill_id;
    }
    //Creating a backup
    public long createBackup(Backup u)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID_PILL, u.getId_pill());
        values.put(KEY_TIME,u.getTime());
        long backup_id = db.insert(TABLE_BACKUP, null, values);
        u.setId(backup_id);
        return backup_id;
    }

    //get a Care_receiver
    public Care_receiver getCare_receiver(long id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_CARE_RECEIVER + " WHERE "
                + KEY_ID + " = " + id;
        Log.e(LOG, selectQuery);
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Care_receiver u=new Care_receiver();

        u.setId(c.getInt(c.getColumnIndex(KEY_ID)));
        u.setId_care_giver(c.getInt(c.getColumnIndex(KEY_ID_CARE_GIVER)));
        u.setName(c.getString(c.getColumnIndex(KEY_NAME)));
        u.setAge(c.getInt(c.getColumnIndex(KEY_AGE)));
        u.setGender(c.getString(c.getColumnIndex(KEY_GENDER)));
        u.setDelta(c.getInt(c.getColumnIndex(KEY_DELTA)));

        return u;
    }

    //get a Care_giver
    public Care_giver getCare_giver(long id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_CARE_GIVER + " WHERE "
                + KEY_ID + " = " + id;
        Log.e(LOG, selectQuery);
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Care_giver u=new Care_giver();

        u.setId(c.getInt(c.getColumnIndex(KEY_ID)));
        u.setName(c.getString(c.getColumnIndex(KEY_NAME)));
        u.setEmail(c.getString(c.getColumnIndex(KEY_EMAIL)));
        u.setPhone(c.getString(c.getColumnIndex(KEY_PHONE)));
        u.setType(c.getInt(c.getColumnIndex(KEY_TYPE)));
        return u;
    }

    //get a alarm
    public Alarm getAlarm(long id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_ALARM + " WHERE "
                + KEY_ID + " = " + id;
        Log.e(LOG, selectQuery);
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Alarm u=new Alarm();

        u.setId(c.getInt(c.getColumnIndex(KEY_ID)));
        u.setId_pill(c.getInt(c.getColumnIndex(KEY_ID_PILL)));
        u.setTime(c.getString(c.getColumnIndex(KEY_TIME)));
        return u;
    }

    //get a pill
    public Pill getPill(long id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_PILL + " WHERE "
                + KEY_ID + " = " + id;
        Log.e(LOG, selectQuery);
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Pill u=new Pill();

        u.setId(c.getInt(c.getColumnIndex(KEY_ID)));
        u.setId_care_receiver(c.getInt(c.getColumnIndex(KEY_ID_CARE_RECEIVER)));
        u.setName(c.getString(c.getColumnIndex(KEY_NAME)));
        u.setDose(c.getInt(c.getColumnIndex(KEY_DOSE)));
        u.setSchedule(c.getInt(c.getColumnIndex(KEY_SCHEDULE)));
        u.setDays(c.getString(c.getColumnIndex(KEY_DAYS)));
        return u;
    }

    //get a backup
    public Backup getBackup(long id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_BACKUP + " WHERE "
                + KEY_ID + " = " + id;
        Log.e(LOG, selectQuery);
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
        Backup u=new Backup();

        u.setId(c.getInt(c.getColumnIndex(KEY_ID)));
        u.setId_pill(c.getInt(c.getColumnIndex(KEY_ID_PILL)));
        u.setTime(c.getString(c.getColumnIndex(KEY_TIME)));
        return u;
    }

    //get all alarms by a pill

    public List<Alarm> getAlarms(String pill_name)
    {
        List<Alarm> all = new ArrayList<Alarm>();
        String selectQuery = "SELECT  * FROM " + TABLE_ALARM + " ta, "
                + TABLE_PILL  + " tp WHERE tp."
                + KEY_NAME + " = '" + pill_name + "'"
                + " AND ta." + KEY_ID_PILL + " = "
                + "tp." + KEY_ID;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                Alarm al=new Alarm();
                al.setId(c.getInt((c.getColumnIndex(KEY_ID))));
                al.setId_pill(c.getInt((c.getColumnIndex(KEY_ID_PILL))));
                al.setTime((c.getString(c.getColumnIndex(KEY_TIME))));
                all.add(al);
            } while (c.moveToNext());
        }
        return all;
    }

    public List<Pill> getPills()
    {
        List<Pill> all = new ArrayList<Pill>();
        String selectQuery = "SELECT  * FROM "
                + TABLE_PILL  ;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                Pill u=new Pill();
                u.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                u.setId_care_receiver(c.getInt(c.getColumnIndex(KEY_ID_CARE_RECEIVER)));
                u.setName(c.getString(c.getColumnIndex(KEY_NAME)));
                u.setDose(c.getInt(c.getColumnIndex(KEY_DOSE)));
                u.setSchedule(c.getInt(c.getColumnIndex(KEY_SCHEDULE)));
                u.setDays(c.getString(c.getColumnIndex(KEY_DAYS)));
                all.add(u);
            } while (c.moveToNext());
        }
        return all;
    }

    //Update query
    public int updateCare_receiver(Care_receiver tmp)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, tmp.getName());

        // updating row
        return db.update(TABLE_CARE_RECEIVER, values, KEY_ID + " = ?",
                new String[]{String.valueOf(tmp.getId()) });
    }

}

