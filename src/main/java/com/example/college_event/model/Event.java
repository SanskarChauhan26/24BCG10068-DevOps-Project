package com.example.college_event.model;

public class Event {
    private Integer id;
    private String date;
    private String eventName;
    private String description;
    private String footFall;
    private String guest;
    private Integer fees;

    public Event() {
    }

    public Event(String date, String eventName, String description,
                 String footFall, String guest, Integer fees) {
        this.date = date;
        this.eventName = eventName;
        this.description = description;
        this.footFall = footFall;
        this.guest = guest;
        this.fees = fees;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFootFall() {
        return footFall;
    }

    public void setFootFall(String footFall) {
        this.footFall = footFall;
    }

    public String getGuest() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

    public Integer getFees() {
        return fees;
    }

    public void setFees(Integer fees) {
        this.fees = fees;
    }
}