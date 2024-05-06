package Archiveeeeee;

import java.util.ArrayList;
import java.util.List;

public class Archive {
    private List<Note> notes;
    private String archiveName;

    public Archive(String archiveName) {
        this.archiveName = archiveName;
        this.notes = new ArrayList<>();
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public void deleteNote(int index) {
        if (index >= 0 && index < notes.size()) {
            notes.remove(index);
        }
    }

    public void editNote(int index, String newText) {
        if (index >= 0 && index < notes.size()) {
            notes.get(index).setNoteText(newText);
        }
    }

    public String listNotes() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < notes.size(); i++) {
            sb.append(i + 1).append(". ").append(notes.get(i).getNoteText()).append("\n");
        }
        return sb.toString();
    }

    public void setArchiveName(String archiveName) {
        this.archiveName = archiveName;
    }

    public String getArchiveName() {
        return archiveName;
    }

    public List<Note> getNotes() {
        return new ArrayList<>(notes);
    }
}