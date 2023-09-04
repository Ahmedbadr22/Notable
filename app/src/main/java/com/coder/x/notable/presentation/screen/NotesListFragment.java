package com.coder.x.notable.presentation.screen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.coder.x.notable.databinding.FragmentNotesListBinding;
import com.coder.x.notable.presentation.adapter.NoteAdapter;
import com.coder.x.notable.presentation.viewmodel.NoteViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class NotesListFragment extends Fragment {
    private FragmentNotesListBinding binding;

    private NoteViewModel noteViewModel;

    private NoteAdapter noteAdapter;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNotesListBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
        setupNoteRecycler();

        noteViewModel.notesLiveDate.observe(getViewLifecycleOwner(), noteModels -> {
            noteAdapter.setData(noteModels);
        });
    }

    private void init() {
        noteViewModel = new ViewModelProvider(requireActivity()).get(NoteViewModel.class);
        noteAdapter = new NoteAdapter(new ArrayList<>());
    }

    private void setupNoteRecycler() {
        binding.rvNotes.setAdapter(noteAdapter);
        binding.rvNotes.setHasFixedSize(true);
        binding.rvNotes.setLayoutManager(new LinearLayoutManager(requireActivity()));
    }

}