package com.coder.x.notable.presentation.screen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coder.x.notable.databinding.FragmentNotesListBinding;

import org.jetbrains.annotations.NotNull;


public class NotesListFragment extends Fragment {
    private FragmentNotesListBinding binding;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNotesListBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }
}