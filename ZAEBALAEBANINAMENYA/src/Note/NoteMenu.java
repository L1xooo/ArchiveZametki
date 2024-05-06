package Note;

import Archiveeeeee.Archive;
import Archiveeeeee.Note;
import Interface.IManager;

import java.util.ArrayList;
import java.util.List;

public class NoteMenu implements IManager<Note> {
    private Archive currentArchive;



    @Override
    public void create(String noteText) {
        if (currentArchive != null) {
            currentArchive.addNote(new Note(noteText));
        } else {
            System.out.println("Архив не выбран.");
        }
    }

    @Override
    public void delete(int index) {
        if (currentArchive != null && index >= 0 && index < currentArchive.getNotes().size()) {
            currentArchive.deleteNote(index);
        } else {
            System.out.println("Неверный индекс или архив не выбран.");
        }
    }

    @Override
    public void edit(int index, String newText) {
        if (currentArchive != null && index >= 0 && index < currentArchive.getNotes().size()) {
            currentArchive.editNote(index, newText);
        } else {
            System.out.println("Неверный индекс или архив не выбран.");
        }
    }

    @Override
    public String list() {
        if (currentArchive != null) {
            return currentArchive.listNotes();
        }
        return "Архив не выбран.";
    }

    @Override
    public List<Note> getAll() {
        if (currentArchive != null) {
            return new ArrayList<>(currentArchive.getNotes());
        }
        return new ArrayList<>();
    }
}