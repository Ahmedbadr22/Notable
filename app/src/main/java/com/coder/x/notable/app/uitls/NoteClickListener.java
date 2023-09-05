package com.coder.x.notable.app.uitls;

import com.coder.x.notable.data.model.NoteModel;

public interface NoteClickListener {
    void onNoteClick(NoteModel noteModel);
    void onDeleteNote(NoteModel noteModel);
}
