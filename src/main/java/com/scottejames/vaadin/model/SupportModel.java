package com.scottejames.vaadin.model;

public class SupportModel {
    private String fullName = null;
    private String phoneNumber = null;
    private String from = null;
    private String to = null;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public SupportModel(String fullName, String phoneNumber, String from, String to) {

        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.from = from;
        this.to = to;
    }
}
