package com.sourcey.materiallogindemo;
/**
 * Created by user on 31/08/2016.
 */
public class Care_receiver{
    long id;
    String name;
    int age;
    String gender;
    long id_care_giver;
    int delta;

    public Care_receiver(){}
    public Care_receiver(long id, String name, int age, String gender, long id_family, int delta){
        this.id=id;
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.id_care_giver=id_family;
        this.delta=delta;
    }
    //getter
    public int getAge() {
        return age;
    }

    public long getId() {
        return id;
    }

    public long getId_care_giver() {
        return id_care_giver;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public int getDelta() {
        return delta;
    }

    //setter
    public void setId(long id)
    {
        this.id=id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setId_care_giver(long id_care_giver) {
        this.id_care_giver = id_care_giver;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDelta(int delta) {
        this.delta = delta;
    }
}
