package com.sourcey.materiallogindemo;

/**
 * Created by user on 31/08/2016.
 */
public class Pill {
    long id;
    long id_care_receiver;
    int dose;
    int schedule;
    String name;
    String days;

    public Pill(){}
    public Pill(long id, long id_care_receiver, int dose, String name, int schedule,String days)
    {
        this.id=id;
        this.id_care_receiver=id_care_receiver;
        this.dose=dose;
        this.name=name;
        this.schedule=schedule;
        this.days=days;
    }
    //getter
    public long getId() {
        return id;
    }

    public int getDose() {
        return dose;
    }

    public long getId_care_receiver() {
        return id_care_receiver;
    }

    public String getName() {
        return name;
    }

    public int getSchedule() {
        return schedule;
    }

    public String getDays() {
        return days;
    }

    //setter

    public void setDose(int dose) {
        this.dose = dose;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setId_care_receiver(long id_care_receiver) {
        this.id_care_receiver = id_care_receiver;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSchedule(int schedule) {
        this.schedule = schedule;
    }

    public void setDays(String days) {
        this.days = days;
    }

}
