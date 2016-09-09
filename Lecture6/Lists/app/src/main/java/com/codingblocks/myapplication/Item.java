package com.codingblocks.myapplication;

import java.util.ArrayList;

/**
 * Created by championswimmer on 02/09/16.
 */
public class Item {
    boolean checked;
    int id;

    public Item(int id) {
        this.id = id;
        this.checked = false;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static ArrayList<Item> getItems (int n) {
        ArrayList<Item> allItems = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            allItems.add(new Item(i));
        }

        return allItems;
    }
}
