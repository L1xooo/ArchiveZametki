import Archiveeeeee.Archive;
import Archiveeeeee.ArchiveManager;
import Archiveeeeee.ArchiveMenu;
import Interface.*;
import Note.NoteManager;
import Note.NoteMenu;

import java.util.ArrayList;
import java.util.List;

import Archiveeeeee.Archive;
import Archiveeeeee.ArchiveMenu;
import Note.NoteMenu;
import Interface.*;

import java.util.List;

public class MenuImpl implements IMenu, IMenuCallback {
    private IUserInput input;
    private ArchiveManager archiveManager;
    private NoteManager noteManager;

    public MenuImpl(IUserInput input) {
        this.input = input;
        this.archiveManager = new ArchiveManager(input, new ArchiveMenu(), this); // Передаем this вместо archiveManager
        this.noteManager = new NoteManager(input, new NoteMenu());
    }


    @Override
    public void showMenu() {
        archiveManager.showMenu();
    }

    @Override
    public void run() {
        archiveManager.run();

        }




    @Override
    public void showNoteMenu() {
        noteManager.showMenu();
    }

    @Override
    public void showNoteMenu(Object currentArchive) {
        if (currentArchive instanceof Archive) {
            noteManager.setCurrentArchive((Archive) currentArchive);
            noteManager.run();
        }
    }

    @Override
    public void saveState() {
        archiveManager.saveState();
    }

    public void setArchiveManager(ArchiveManager archiveManager) {
        this.archiveManager = archiveManager;
    }

    public void setNoteManager(NoteManager noteManager) {
        this.noteManager = noteManager;
    }
}