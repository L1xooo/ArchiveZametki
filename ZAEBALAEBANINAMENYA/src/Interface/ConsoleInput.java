package Interface;

import Interface.IUserInput;

import java.util.Scanner;

public class ConsoleInput implements IUserInput {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String getUserInput() {
        return scanner.nextLine();
    }

    @Override
    public void close() {
        scanner.close();
    }
}
