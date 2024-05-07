package Note;

import Models.Archive;
import Interface.IMenu;

import Interface.IUserInput;

public class NoteManager implements IMenu {
    private IUserInput input;
    private NoteMenu noteMenu;
    private Archive currentArchive;

    public NoteManager(IUserInput input, NoteMenu noteMenu) {
        this.input = input;
        this.noteMenu = noteMenu;
    }

    @Override
    public void showMenu() {
        System.out.println("\nМеню заметок");
        System.out.println("0. Посмотреть заметки");
        System.out.println("1. Создать заметку");
        System.out.println("2. Изменить заметку");
        System.out.println("3. Удалить заметку");
        System.out.println("4. Назад");
    }

    @Override
    public void run() {
        boolean back = false;
        while (!back) {
            showMenu();
            String choice = input.getUserInput();
            switch (choice) {
                case "0":
                    String notes = noteMenu.list();
                    if (notes.isEmpty()) {
                        System.out.println("Нет созданных заметок.");
                    } else {
                        System.out.println(notes);
                    }
                    break;
                case "1":
                    System.out.print("Введите текст заметки: ");
                    String noteText = input.getUserInput();
                    noteMenu.create(noteText);
                    break;
                case "2":
                    if (noteMenu.list().isEmpty()) {
                        System.out.println("Нет созданных заметок.");
                        break;
                    }
                    System.out.println("Выберите заметку для изменения:\n" + noteMenu.list());
                    int indexEdit = Integer.parseInt(input.getUserInput()) - 1;
                    System.out.print("Введите новый текст заметки: ");
                    String newNoteText = input.getUserInput();
                    noteMenu.edit(indexEdit, newNoteText);
                    break;
                case "3":
                    if (noteMenu.list().isEmpty()) {
                        System.out.println("Нет созданных заметок.");
                        break;
                    }
                    System.out.println("Выберите заметку для удаления:\n" + noteMenu.list());
                    int indexDelete = Integer.parseInt(input.getUserInput()) - 1;
                    noteMenu.delete(indexDelete);
                    break;
                case "4":
                    back = true;
                    break;
                default:
                    System.out.println("Неверный ввод. Попробуйте снова.");
                    break;
            }
        }
    }
    public void setCurrentArchive(Archive currentArchive) {
        this.currentArchive = currentArchive;
    }
}