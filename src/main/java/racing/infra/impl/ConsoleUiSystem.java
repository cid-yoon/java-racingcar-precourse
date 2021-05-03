package racing.infra.impl;

import racing.infra.UiSystem;

import java.util.Scanner;

public class ConsoleUiSystem implements UiSystem {
    private final Scanner scanner = new Scanner(System.in);

    // check validation
    public String input() {
        return scanner.nextLine();
    }

    @Override
    public void display(String data) {
        System.out.println(data);
    }
}
