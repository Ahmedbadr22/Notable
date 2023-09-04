package com.coder.x.notable.data.model;

import com.coder.x.notable.app.uitls.Utils;
import com.coder.x.notable.domain.model.Note;


public class NoteModel extends Note {

    public NoteModel(long id, String title, String body) {
        super(id, title, body, Utils.getCurrentLocalDate());
    }

    public NoteModel(long id, String title, String body, String createUpdateDate) {
        super(id, title, body, createUpdateDate);
    }
}
