package com.coder.x.notable.presentation.screen;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coder.x.notable.databinding.FragmentAddEditNoteBinding;

public class AddEditNoteFragment extends Fragment {
    private FragmentAddEditNoteBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAddEditNoteBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }
}