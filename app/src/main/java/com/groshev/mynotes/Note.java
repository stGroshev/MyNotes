package com.groshev.mynotes;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable {
    private String nameNote;
    private String noteDescription;
    private String noteDate;

    public Note(String nameNote, String noteDescription, String noteDate) {
        this.nameNote = nameNote;
        this.noteDescription = noteDescription;
        this.noteDate = noteDate;
    }

    protected Note(Parcel in) {
        nameNote = in.readString();
        noteDescription = in.readString();
        noteDate = in.readString();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public String getNameNote() {
        return nameNote;
    }

    public void setNameNote(String nameNote) {
        this.nameNote = nameNote;
    }

    public String getNoteDescription() {
        return noteDescription;
    }

    public void setNoteDescription(String noteDescription) {
        this.noteDescription = noteDescription;
    }

    public String getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(String noteDate) {
        this.noteDate = noteDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nameNote);
        parcel.writeString(noteDescription);
        parcel.writeString(noteDate);
    }
}
