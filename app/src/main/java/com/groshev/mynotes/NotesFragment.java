package com.groshev.mynotes;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class NotesFragment extends Fragment {

    private Note noteOne;
    private Note noteTwo;
    private Note noteThree;

    public static NotesFragment newInstance() {
        NotesFragment fragment = new NotesFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_notes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initNotes();
        ArrayList<Note> notes = new ArrayList<>();
        notes.add(noteOne);
        notes.add(noteTwo);
        notes.add(noteThree);

        for (int i = 0; i < notes.size(); i++){
            TextView tv = new TextView(getContext());
            tv.setTextSize(30f);
            Note note = notes.get(i);
            tv.setText((String)note.getNameNote());
            ((LinearLayout) view).addView(tv);

            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                        NoteDescriptionFragment noteDescriptionFragment = NoteDescriptionFragment.newInstance(note);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.noteDescription, noteDescriptionFragment ).commit();
                    } else{
                        NoteDescriptionFragment noteDescriptionFragment = NoteDescriptionFragment.newInstance(note);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.notes, noteDescriptionFragment ).addToBackStack("gsm").commit();
                    }
                }
            });
        }

    }
    public void initNotes(){
        noteOne = new Note("Заметка-1", "Какое-то описание заметки-1 бла-бла-бла", "nn.nn.nnnn");
        noteTwo = new Note("Заметка-2", "Какое-то описание заметки-2 бла-бла-бла", "nn.nn.nnnn");
        noteThree = new Note("Заметка-3", "Какое-то описание заметки-3 бла-бла-бла", "nn.nn.nnnn");
    }
}