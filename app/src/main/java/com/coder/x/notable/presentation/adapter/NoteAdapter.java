package com.coder.x.notable.presentation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coder.x.notable.R;
import com.coder.x.notable.data.model.NoteModel;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    private List<NoteModel> notes;

    public NoteAdapter(List<NoteModel> countries) {
        this.notes = countries;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView noteTitle;
        TextView noteCreateUpdateDate;
        TextView noteBody;

        public ViewHolder(View view) {
            super(view);

            noteTitle =  view.findViewById(R.id.tv_title);
            noteCreateUpdateDate =  view.findViewById(R.id.tv_date);
            noteBody =  view.findViewById(R.id.tv_body);
        }

        public void setNote(NoteModel note) {
            noteCreateUpdateDate.setText(note.getCreateUpdateDate());
            noteTitle.setText(note.getTitle());
            noteBody.setText(note.getBody());
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
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}
