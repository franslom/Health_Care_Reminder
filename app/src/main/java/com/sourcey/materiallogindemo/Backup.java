package com.sourcey.materiallogindemo;

/**
 * Created by Franci Suni on 30/08/16.
 */
public class Backup {
    long id;
    long id_pill;
    String time;

    public Backup(){}
    public Backup(long id, long id_pill, String time)
    {
        this.id=id;
        this.id_pill=id_pill;
        this.time=time;
    }
    //getter
    public String getTime() {
        return time;
    }

    public long getId() {
        return id;
    }

    public long getId_pill() {
        return id_pill;
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
