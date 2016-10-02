package com.codingblocks.netjson;

/**
 * Created by championswimmer on 02/10/16.
 */

public class Event {
    String name;
    String startTime;
    String endTime;
    String location;

    public Event(String name, String startTime, String endTime, String location) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getLocation() {
        return location;
    }
}
