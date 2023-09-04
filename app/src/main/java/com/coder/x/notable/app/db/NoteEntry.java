package com.coder.x.notable.app.db;

import android.provider.BaseColumns;

public class NoteEntry implements BaseColumns {
    public static final String TABLE_NAME = "notes";
    public static final String COLUMN_NAME_TITLE = "title";
    public static final String COLUMN_NAME_BODY = "body";
    public static final String COLUMN_NAME_CREATE_UPDATE_DATE = "create_update_date";
}