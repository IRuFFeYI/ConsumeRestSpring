package com.spring.restapi.ConsumeRest.model;

public class PhonebookEntry {

    private int id;
    private String prename;
    private String name;
    private String phoneNumber;


    public PhonebookEntry() {
    }

    public PhonebookEntry(String prename, String name, String phoneNumber) {
        this.prename = prename;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public PhonebookEntry(int id, String prename, String name, String phoneNumber) {
        this.id = id;
        this.prename = prename;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        this.prename = prename;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
