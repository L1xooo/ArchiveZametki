package Archiveeeeee;


import Interface.IManager;

import java.util.ArrayList;
import java.util.List;

public class ArchiveMenu implements IManager<Archive> {
    private List<Archive> archives = new ArrayList<>();
    private Archive currentArchive;

    @Override
    public void create(String name) {
        archives.add(new Archive(name));
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
        for (int i = 0; i < archives.size(); i++) {
            sb.append(i + 1).append(". ").append(archives.get(i).getArchiveName()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public List<Archive> getAll() {
        return new ArrayList<>(archives);
    }

    public Archive getCurrentArchive() {
        return currentArchive;
    }

    public void setCurrentArchive(Archive currentArchive) {
        this.currentArchive = currentArchive;
    }
}