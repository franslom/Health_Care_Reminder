package com.sourcey.materiallogindemo;

/**
 * Created by user on 31/08/2016.
 */
public class Care_giver {
    long id;
    String name;
    String email;
    String phone;
    int type;//1: Health_Profesional--2:Family_member

    public Care_giver(){}
    public Care_giver(long id, String name, String email, String phone)
    {
        this.id=id;
        this.name=name;
        this.email=email;
        this.phone=phone;
    }
    //setter
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    //getter
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getType() {
        return type;
    }

    public void set_delta(int d)
    {

    }


}
