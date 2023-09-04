package com.coder.x.notable.app.constants;

import com.coder.x.notable.app.db.NoteEntry;

public class DBConstants {
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + NoteEntry.TABLE_NAME + " (" +
                    NoteEntry._ID + " INTEGER PRIMARY KEY," +
                    NoteEntry.COLUMN_NAME_TITLE + " TEXT," +
                    NoteEntry.COLUMN_NAME_BODY + " TEXT," +
                    NoteEntry.COLUMN_NAME_CREATE_UPDATE_DATE + " TEXT)";

    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + NoteEntry.TABLE_NAME;
}
