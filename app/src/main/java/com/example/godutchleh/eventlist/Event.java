package com.example.godutchleh.eventlist;

public class Event {
    public String eventName;
    public String eventTime;
    public String eventSpending;
    public String eventMembers;
    public int imageId;

    public Event(String eventName, String eventTime, String eventSpending, String eventMembers, int imageId) {
        this.eventName = eventName;
        this.imageId = imageId;
        this.eventName = eventName;
        this.eventTime = eventTime;
        this.eventSpending = eventSpending;
        this.eventMembers = eventMembers;
    }

    public String getEventName(){
        return eventName;
    }
    public String getEventTime(){
        return eventTime;
    }
    public String getEventSpending(){
        return eventSpending;
    }
    public String getEventMembers(){
        return eventMembers;
    }
    public int getImageId(){
        return imageId;
    }

}
