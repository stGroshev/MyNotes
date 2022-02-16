package com.groshev.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initNotes();
        if(savedInstanceState == null){
            NotesFragment notesFragment = NotesFragment.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.notes, notesFragment).commit();
            if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                Note note = new Note ("Заметка-1", "Какое-то описание заметки-1 бла-бла-бла", "nn.nn.nnnn");
                NoteDescriptionFragment noteDescriptionFragment = NoteDescriptionFragment.newInstance(note);
                getSupportFragmentManager().beginTransaction().replace(R.id.noteDescription, noteDescriptionFragment ).commit();
            }
        }
    }
    public void initNotes(){
        Note noteOne = new Note("Заметка-1", "Какое-то описание заметки-1 бла-бла-бла", "nn.nn.nnnn");
        Note noteTwo = new Note("Заметка-2", "Какое-то описание заметки-2 бла-бла-бла", "nn.nn.nnnn");
        Note noteThree = new Note("Заметка-3", "Какое-то описание заметки-3 бла-бла-бла", "nn.nn.nnnn");
        ArrayList<Note> notes = new ArrayList<>();
        notes.add(noteOne);
        notes.add(noteTwo);
        notes.add(noteThree);
    }
}