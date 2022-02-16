package com.groshev.mynotes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class NoteDescriptionFragment extends Fragment {

    public static final String KEY = "note";
    private Note note;

    public static NoteDescriptionFragment newInstance(Note note) {
        NoteDescriptionFragment fragment = new NoteDescriptionFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY, note);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        
        return inflater.inflate(R.layout.fragment_note_description, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        note = getArguments().getParcelable(KEY);
        TextView tv = view.findViewById(R.id.tvNoteDescription);
        tv.setText((String)note.getNoteDescription());
    }
}