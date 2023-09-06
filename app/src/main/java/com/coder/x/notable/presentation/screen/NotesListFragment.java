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
import com.coder.x.notable.app.uitls.NoteClickListener;
import com.coder.x.notable.data.model.NoteModel;
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

    private NotesListFragmentDirections.ActionNotesListFragmentToAddEditNoteFragment navAction;

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
        noteAdapter = new NoteAdapter(new ArrayList<>(), new NoteClickListener() {
            @Override
            public void onNoteClick(NoteModel noteModel) {
                navAction = NotesListFragmentDirections.actionNotesListFragmentToAddEditNoteFragment();
                navAction.setNote(noteModel);
                NavHostFragment navHostFragment = (NavHostFragment) requireActivity().getSupportFragmentManager().findFragmentById(R.id.fcv_main);
                if (navHostFragment != null) {
                    NavController navController = navHostFragment.getNavController();
                    navController.navigate(navAction);
                }
            }

            @Override
            public void onDeleteNote(NoteModel noteModel) {
                noteViewModel.deleteNote(noteModel.getId());
            }
        });
    }

    private void setupNoteRecycler() {
        binding.rvNotes.setAdapter(noteAdapter);
        binding.rvNotes.setHasFixedSize(true);
        binding.rvNotes.setLayoutManager(new LinearLayoutManager(requireActivity()));
    }

    private void OnAddNewNote() {
        navAction = NotesListFragmentDirections.actionNotesListFragmentToAddEditNoteFragment();

        NavHostFragment navHostFragment = (NavHostFragment) requireActivity().getSupportFragmentManager().findFragmentById(R.id.fcv_main);
        if (navHostFragment != null) {
            NavController navController = navHostFragment.getNavController();
            navController.navigate(navAction);
        }
    }


}