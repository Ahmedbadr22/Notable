package com.coder.x.notable.presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.coder.x.notable.R;
import com.coder.x.notable.app.uitls.NoteClickListener;
import com.coder.x.notable.data.model.NoteModel;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    private List<NoteModel> notes;
    private final NoteClickListener noteClickListener;

    public NoteAdapter(List<NoteModel> countries, NoteClickListener noteClickListener) {
        this.notes = countries;
        this.noteClickListener = noteClickListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView noteTitle;
        TextView noteCreateUpdateDate;
        TextView noteBody;
        CardView noteCard;

        public ViewHolder(View view) {
            super(view);

            noteTitle =  view.findViewById(R.id.tv_title);
            noteCreateUpdateDate =  view.findViewById(R.id.tv_date);
            noteBody =  view.findViewById(R.id.tv_body);
            noteCard =  view.findViewById(R.id.cv_note_item);
        }

        public void setNote(NoteModel note) {
            noteTitle.setText(note.getTitle());
            noteBody.setText(note.getBody());
            noteCreateUpdateDate.setText(note.getCreateUpdateDate());
        }
    }

    public void setData(List<NoteModel> data) {
        notes = data;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NoteModel note = notes.get(position);
        holder.setNote(note);
        holder.noteCard.setOnClickListener(view -> noteClickListener.onNoteClick(note));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}
