package services;

import dataaccess.NoteDB;
import java.util.List;
import java.util.Date;
import models.Note;

public class NoteService {

    public Note get(int noteid) {
        NoteDB ndb = new NoteDB();

        Note note = ndb.get(noteid);
        return note;
    }

    public List<Note> getAll() {
        NoteDB ndb = new NoteDB();

        List<Note> notes = ndb.getAll();
        return notes;
    }

    public void insert(String contents, String title) {
        NoteDB ndb = new NoteDB();

        Date date = new Date();
        Note note = new Note(0, date, title, contents);
        ndb.insert(note);
    }

    public void update(int noteid, String title, String contents) {
        NoteDB ndb = new NoteDB();

        Note note = ndb.get(noteid);
        note.setTitle(title);
        note.setContents(contents);
        ndb.update(note);
    }

    public void delete(int noteid) {
        NoteDB ndb = new NoteDB();

        Note note = ndb.get(noteid);
        ndb.delete(note);
    }
}
