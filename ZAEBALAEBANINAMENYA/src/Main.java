import Archiveeeeee.ArchiveManager;
import Archiveeeeee.ArchiveMenu;
import Interface.ConsoleInput;
import Interface.IMenuCallback;
import Interface.IUserInput;
import Note.NoteManager;
import Note.NoteMenu;

public class Main {
    public static void main(String[] args) {
        IUserInput input = new ConsoleInput();
        MenuImpl menuManager = new MenuImpl(input);
        menuManager.run();
        input.close();
    }
}