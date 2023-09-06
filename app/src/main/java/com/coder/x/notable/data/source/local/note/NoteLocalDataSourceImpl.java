package com.coder.x.notable.data.source.local.note;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.coder.x.notable.app.db.DBHelper;
import com.coder.x.notable.app.db.NoteEntry;
import com.coder.x.notable.app.uitls.Utils;
import com.coder.x.notable.data.model.NoteForm;
import com.coder.x.notable.data.model.NoteModel;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class NoteLocalDataSourceImpl implements NoteLocalDataSource {

    private final SQLiteDatabase sqLiteWritableDatabase;
    private final SQLiteDatabase sqLiteReadableDatabase;

    private final String[] projection = {
            NoteEntry._ID,
            NoteEntry.COLUMN_NAME_TITLE,
            NoteEntry.COLUMN_NAME_BODY,
            NoteEntry.COLUMN_NAME_CREATE_UPDATE_DATE,
    };

    @Inject
    public NoteLocalDataSourceImpl(DBHelper dbHelper) {
        this.sqLiteWritableDatabase = dbHelper.getWritableDatabase();
        this.sqLiteReadableDatabase = dbHelper.getReadableDatabase();
    }


    @Override
    public long addNote(NoteForm noteForm) {
        ContentValues values = new ContentValues();

        values.put(NoteEntry.COLUMN_NAME_TITLE, noteForm.getTitle());
        values.put(NoteEntry.COLUMN_NAME_BODY, noteForm.getBody());
        values.put(NoteEntry.COLUMN_NAME_CREATE_UPDATE_DATE, noteForm.getCreateUpdateDate());

        return sqLiteWritableDatabase.insert(NoteEntry.TABLE_NAME, null, values);
    }

    @Override
    public @Nullable NoteModel getNoteById(long id) {
        NoteModel noteModel = null;

        String selection = NoteEntry._ID + " = ?";
        String[] selectionArgs = {String.valueOf(id)};

        Cursor cursor = sqLiteReadableDatabase.query(
            NoteEntry.TABLE_NAME,
            projection,
            selection,
            selectionArgs,
            null,
            null,
            null
        );

        while (cursor.moveToNext()) {
            long recId = cursor.getLong(cursor.getColumnIndexOrThrow(NoteEntry._ID));
            String title = cursor.getString(cursor.getColumnIndexOrThrow(NoteEntry.COLUMN_NAME_TITLE));
            String body = cursor.getString(cursor.getColumnIndexOrThrow(NoteEntry.COLUMN_NAME_BODY));
            String createUpdateDate = cursor.getString(cursor.getColumnIndexOrThrow(NoteEntry.COLUMN_NAME_CREATE_UPDATE_DATE));

            noteModel = new NoteModel(recId, title, body, createUpdateDate);
        }
        cursor.close();

        return noteModel;
    }

    @Override
    public @NotNull List<NoteModel> listAllNotes() {
        List<NoteModel> notes = new ArrayList<>();

        Cursor cursor = sqLiteReadableDatabase.query(
                NoteEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        while (cursor.moveToNext()) {
            long recId = cursor.getLong(cursor.getColumnIndexOrThrow(NoteEntry._ID));
            String title = cursor.getString(cursor.getColumnIndexOrThrow(NoteEntry.COLUMN_NAME_TITLE));
            String body = cursor.getString(cursor.getColumnIndexOrThrow(NoteEntry.COLUMN_NAME_BODY));
            String createUpdateDate = cursor.getString(cursor.getColumnIndexOrThrow(NoteEntry.COLUMN_NAME_CREATE_UPDATE_DATE));

            NoteModel noteModel = new NoteModel(recId, title, body, createUpdateDate);
            notes.add(noteModel);
        }
        cursor.close();

        return notes;
    }

    @Override
    public boolean deleteNoteById(long id) {
        String[] idArgs = {String.valueOf(id)};
        String condition = NoteEntry._ID + " = ?";
        return sqLiteWritableDatabase.delete(NoteEntry.TABLE_NAME, condition, idArgs) > 0;
    }

    @Override
    public boolean editNote(NoteModel noteModel) {
        ContentValues values = new ContentValues();

        values.put(NoteEntry.COLUMN_NAME_TITLE, noteModel.getTitle());
        values.put(NoteEntry.COLUMN_NAME_BODY, noteModel.getBody());
        values.put(NoteEntry.COLUMN_NAME_CREATE_UPDATE_DATE, Utils.getCurrentLocalDate());

        String[] idArgs = {String.valueOf(noteModel.getId())};
        String condition = NoteEntry._ID + " = ?";

        return sqLiteWritableDatabase.update(NoteEntry.TABLE_NAME, values, condition, idArgs) > 0;
    }
}
