package com.coder.x.notable.presentation.screen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.coder.x.notable.R;
import com.coder.x.notable.data.model.NoteModel;
import com.coder.x.notable.databinding.FragmentAddEditNoteBinding;
import com.coder.x.notable.presentation.viewmodel.NoteViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AddEditNoteFragment extends Fragment {
    private FragmentAddEditNoteBinding binding;
    private NoteViewModel noteViewModel;
    @Nullable
    private NoteModel noteModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAddEditNoteBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();

        if (noteModel != null) {
            binding.mtpNoteDetailEditDelete.inflateMenu(R.menu.edit_delete_menu);
            setNoteDetail(noteModel);
        } else {
            binding.mtpNoteDetailEditDelete.inflateMenu(R.menu.save_item_menu);
        }

        binding.mtpNoteDetailEditDelete.setNavigationOnClickListener(mtpView -> navigateBack());

        setupMenuActions();
    }

    private void init() {
        noteViewModel = new ViewModelProvider(requireActivity()).get(NoteViewModel.class);
        noteModel = AddEditNoteFragmentArgs.fromBundle(getArguments()).getNote();
    }

    private void setupMenuActions() {
        binding.mtpNoteDetailEditDelete.setOnMenuItemClickListener(item -> {

            if (item.getItemId() == R.id.item_save) {
                String title = binding.edtTitle.getText().toString();
                String body = binding.edtNoteBody.getText().toString();
                noteViewModel.addNote(title, body);
            } else if (item.getItemId() == R.id.item_delete) {
                assert noteModel != null;
                boolean isDeleted = noteViewModel.deleteNote(noteModel.getId());
                if (isDeleted) navigateBack();
            }
            else {
                String title = binding.edtTitle.getText().toString();
                String body = binding.edtNoteBody.getText().toString();
                boolean isUpdated = noteViewModel.editNote(noteModel.getId(), title, body);
                if (isUpdated) navigateBack();
            }
            return true;
        });
    }

    private void navigateBack() {
        Navigation.findNavController(requireView()).popBackStack();
    }

    private void setNoteDetail(NoteModel note) {
        binding.edtTitle.setText(note.getTitle());
        binding.edtNoteBody.setText(note.getBody());
        binding.tvCreateUpdateDate.setVisibility(View.VISIBLE);
        binding.tvCreateUpdateDate.setText(note.getCreateUpdateDate());
    }
}