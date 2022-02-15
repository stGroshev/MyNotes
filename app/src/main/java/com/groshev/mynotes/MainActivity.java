package com.groshev.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            NotesFragment notesFragment = new NotesFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.notes, notesFragment).commit();
            if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                NoteDescriptionFragment noteDescriptionFragment = new NoteDescriptionFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.noteDescription, noteDescriptionFragment ).commit();
            }
        }
    }
}