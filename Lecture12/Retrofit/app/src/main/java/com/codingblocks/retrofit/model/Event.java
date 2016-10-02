package com.codingblocks.retrofit.model;

/**
 * Created by championswimmer on 02/10/16.
 */

public class Event {
    String name;
    String start_time;
    String end_time;
    String location_name;

    public Event(String name, String start_time, String end_time, String location_name) {
        this.name = name;
        this.start_time = start_time;
        this.end_time = end_time;
        this.location_name = location_name;
    }

    public String getName() {
        return name;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public String getLocation_name() {
        return location_name;
    }
}
