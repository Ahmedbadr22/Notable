package com.coder.x.notable.presentation.screen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.coder.x.notable.R;
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
            if (noteModels.isEmpty()) {
                binding.rvNotes.setVisibility(View.GONE);
                binding.clEmptyNotesMessageLayout.setVisibility(View.VISIBLE);
            } else {
                binding.rvNotes.setVisibility(View.VISIBLE);
                binding.clEmptyNotesMessageLayout.setVisibility(View.GONE);
                noteAdapter.setData(noteModels);
            }
        });

        binding.floatingActionButton.setOnClickListener(view1 -> OnAddNewNote());
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

    private void OnAddNewNote() {
        int navAction = R.id.action_notesListFragment_to_addEditNoteFragment;
        NavHostFragment navHostFragment = (NavHostFragment) requireActivity().getSupportFragmentManager().findFragmentById(R.id.fcv_main);
        if (navHostFragment != null) {
            NavController navController = navHostFragment.getNavController();
            navController.navigate(navAction);
        }
    }

}