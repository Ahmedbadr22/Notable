package com.coder.x.notable.data.model;

import com.coder.x.notable.app.uitls.Utils;
import com.coder.x.notable.domain.model.Note;


public class NoteForm extends Note {

    public NoteForm(String title, String body) {
        super(title, body, Utils.getCurrentLocalDate());
    }
}
