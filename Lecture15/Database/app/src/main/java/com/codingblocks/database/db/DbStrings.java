package com.codingblocks.database.db;

import android.provider.BaseColumns;

/**
 * Created by championswimmer on 09/10/16.
 */

public interface DbStrings {
    String COMMA = ", ";
    String LBR = " ( ";
    String RBR = " ) ";
    String TERM = ";";

    String TYPE_INT = " INTEGER ";
    String TYPE_REAL = " REAL ";
    String TYPE_TEXT = " TEXT ";
    String TYPE_INT_PK = " INTEGER PRIMARY KEY";
    String TYPE_INT_PK_AI = " INTEGER PRIMARY KEY AUTOINCREMENT";



    String ORDER_DESC = " DESC";

    String CMD_CREATE_TABLE_INE = " CREATE TABLE IF NOT EXISTS ";

}
