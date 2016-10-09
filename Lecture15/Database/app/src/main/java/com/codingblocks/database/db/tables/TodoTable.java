package com.codingblocks.database.db.tables;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.codingblocks.database.models.Todo;

import java.util.ArrayList;

import static com.codingblocks.database.db.DbStrings.*;

/**
 * Created by championswimmer on 09/10/16.
 */



public class TodoTable {

    public static final String TABLE_NAME = "todos";

    public interface Columns {
        String ID = "id";
        String NAME = "name";
        String DONE = "done";
    }

    public static String CMD_CREATE_TABLE =
            CMD_CREATE_TABLE_INE + TABLE_NAME + LBR
            + Columns.ID + TYPE_INT_PK_AI + COMMA
            + Columns.NAME + TYPE_TEXT + COMMA
            + Columns.DONE + TYPE_INT
            + RBR + TERM;

    public static String[] FULL_PROJECTION = {
            Columns.ID, Columns.NAME, Columns.DONE
    };

    public static String UPD_TABLE_1_2 = "";

    public static long addNewTodo(SQLiteDatabase db, Todo newTodo) {

        ContentValues cv = new ContentValues();
        cv.put(Columns.NAME, newTodo.getTask());
        cv.put(Columns.DONE, newTodo.isDone() ? 1 : 0);

        return db.insert(TABLE_NAME,
                null,
                cv);
    }

    public static ArrayList<Todo> getAllTodos(SQLiteDatabase db) {
        ArrayList<Todo> todoList = new ArrayList<>();

        /* WHERE manufacturer = SONY AND price > 300
        *  WHERE manufacturer = SONY; DROP TABLE products;
        *  "manufacturer = ? AND price > ? " = selection
        *  ["SONY", 300] = selectionArgs
        *
         */

        Cursor c = db.query(TABLE_NAME,
                FULL_PROJECTION,
                null, null, null, null, Columns.ID + ORDER_DESC);
        int colId = c.getColumnIndex(Columns.ID);
        int colName = c.getColumnIndex(Columns.NAME);
        int colDone = c.getColumnIndex(Columns.DONE);

        while (c.moveToNext()) {
            todoList.add(new Todo(
                    c.getInt(colId),
                    c.getString(colName),
                    1 == c.getInt(colDone)
            ));
        }

        c.close();

        return todoList;
    }

    public static Todo getTodo(int id) {
        return null;
    }




}
