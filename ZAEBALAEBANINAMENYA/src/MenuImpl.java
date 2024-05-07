import Models.Archive;
import Archiveeeeee.ArchiveManager;
import Archiveeeeee.ArchiveMenu;
import Interface.*;
import Note.NoteManager;
import Note.NoteMenu;

public class MenuImpl implements IMenu, IMenuCallback {
    private IUserInput input;
    private ArchiveManager archiveManager;
    private NoteManager noteManager;

    public MenuImpl(IUserInput input) {
        this.input = input;
        ArchiveMenu archiveMenu = new ArchiveMenu();
        this.archiveManager = new ArchiveManager(input, archiveMenu, this);
        this.noteManager = new NoteManager(input, new NoteMenu(1));
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
}