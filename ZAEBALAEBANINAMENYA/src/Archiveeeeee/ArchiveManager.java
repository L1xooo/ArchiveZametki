package Archiveeeeee;

import Interface.*;

import java.util.List;

public class ArchiveManager implements IMenu {
    private IUserInput input;
    private ArchiveMenu archiveMenu;

    private IMenuCallback callback;

    public ArchiveManager(IUserInput input, ArchiveMenu archiveMenu, IMenuCallback callback) {
        this.input = input;
        this.archiveMenu = archiveMenu;
        this.callback = callback;
    }
    @Override
    public void showMenu() {
        System.out.println("\nМеню архивов");
        System.out.println("0. Посмотреть архив");
        System.out.println("1. Создать архив");
        System.out.println("2. Изменить архив");
        System.out.println("3. Удалить архив");
        System.out.println("4. Выйти");
    }

    @Override
    public void run() {
        boolean exit = false;
        while (!exit) {
            showMenu();
            String choice = input.getUserInput();
            switch (choice) {
                case "0":
                    if (archiveMenu.getAll().isEmpty()) {
                        System.out.println("Нет созданных архивов.");
                        break;
                    }
                    System.out.println("Выберите архив (введите номер):\n" + archiveMenu.list());
                    int index = Integer.parseInt(input.getUserInput()) - 1;
                    if (archiveMenu.getAll().size() > index && index >= 0) {
                        callback.showNoteMenu(archiveMenu.getAll().get(index));
                    } else {
                        System.out.println("Некорректный выбор.");
                    }
                    break;
                case "1":
                    System.out.print("Введите имя архива: ");
                    String name = input.getUserInput();
                    archiveMenu.create(name);
                    callback.saveState();
                    break;
                case "2":
                    if (archiveMenu.getAll().isEmpty()) {
                        System.out.println("Нет созданных архивов.");
                        break;
                    }
                    System.out.println("Выберите архив для изменения:\n" + archiveMenu.list());
                    int indexEditArchive = Integer.parseInt(input.getUserInput()) - 1;
                    System.out.print("Введите новое имя архива: ");
                    String newArchiveName = input.getUserInput();
                    archiveMenu.edit(indexEditArchive, newArchiveName);
                    break;
                case "3":
                    if (archiveMenu.getAll().isEmpty()) {
                        System.out.println("Нет созданных архивов.");
                        break;
                    }
                    System.out.println("Выберите архив для удаления:\n" + archiveMenu.list());
                    int indexDelete = Integer.parseInt(input.getUserInput()) - 1;
                    archiveMenu.delete(indexDelete);
                    break;
                case "4":
                    exit = true;
                    break;
                default:
                    System.out.println("Неверный ввод. Попробуйте снова.");
                    break;
            }
        }
    }

    public void saveState() {
        List<Archive> currentArchives = archiveMenu.getAll();
        System.out.println("Состояние архивов сохранено.");
    }
}