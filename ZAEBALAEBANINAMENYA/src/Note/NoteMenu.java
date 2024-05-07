package Note;

import Models.Archive;
import Models.Note;
import Interface.IManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NoteMenu implements IManager<Note> {
    private Map<Integer, List<Note>> notesByArchive = new HashMap<>();
    private int currentArchiveId;

    public NoteMenu(int currentArchiveId) {
        this.currentArchiveId = currentArchiveId;
    }

    @Override
    public void create(String noteText) {
        List<Note> notes = notesByArchive.computeIfAbsent(currentArchiveId, k -> new ArrayList<>());
        notes.add(new Note(noteText));
    }

    @Override
    public void delete(int index) {
        List<Note> notes = notesByArchive.get(currentArchiveId);
        if (notes != null && index >= 0 && index < notes.size()) {
            notes.remove(index);
        }
    }

    @Override
    public void edit(int index, String newText) {
        List<Note> notes = notesByArchive.get(currentArchiveId);
        if (notes != null && index >= 0 && index < notes.size()) {
            notes.get(index).setNoteText(newText);
        }
    }

    @Override
    public String list() {
        List<Note> notes = notesByArchive.get(currentArchiveId);
        if (notes != null && !notes.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < notes.size(); i++) {
                sb.append((i + 1)).append(". ").append(notes.get(i).getNoteText()).append("\n");
            }
            return sb.toString();
        }
        return "";
    }

    @Override
    public List<Note> getAll() {
        return new ArrayList<>(notesByArchive.getOrDefault(currentArchiveId, new ArrayList<>()));
    }
}