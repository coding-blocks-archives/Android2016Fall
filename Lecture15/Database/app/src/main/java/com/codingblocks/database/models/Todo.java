package com.codingblocks.database.models;

/**
 * Created by championswimmer on 09/10/16.
 */

public class Todo {

    int id;
    String task;
    boolean done;

    public Todo(int id, String task, boolean done) {
        this.id = id;
        this.task = task;
        this.done = done;
    }

    public Todo(String task, boolean done) {
        this.task = task;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public boolean isDone() {
        return done;
    }
}
