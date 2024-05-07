package Archiveeeeee;


import Interface.IManager;
import Models.Archive;

import java.util.ArrayList;
import java.util.List;

public class ArchiveMenu implements IManager<Archive> {
    private List<Archive> archives = new ArrayList<>();
    private int nextId = 1;

    @Override
    public void create(String name) {
        archives.add(new Archive(nextId++, name));
    }

    @Override
    public void delete(int index) {
        if (index >= 0 && index < archives.size()) {
            archives.remove(index);
        }
    }

    @Override
    public void edit(int index, String newName) {
        if (index >= 0 && index < archives.size()) {
            archives.get(index).setArchiveName(newName);
        }
    }

    @Override
    public String list() {
        StringBuilder sb = new StringBuilder();
        for (Archive archive : archives) {
            sb.append(archive.getArchiveId()).append(". ").append(archive.getArchiveName()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public List<Archive> getAll() {
        return new ArrayList<>(archives);
    }
}