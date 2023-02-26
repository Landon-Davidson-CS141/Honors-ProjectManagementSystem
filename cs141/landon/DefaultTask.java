package cs141.landon;

import java.util.Scanner;

public class DefaultTask extends Task {
    public DefaultTask(String name, boolean priority) {
        super(name, priority);
    }

    @Override
    public void printTask() {
        super.printTask();
    }

    @Override
    public void editTask(Scanner input) {
        System.out.println();
        System.out.println("1. Name: " + name);
        System.out.println("2. Priority: " + priority);
        System.out.print("3. Cancel");
        System.out.print("Which Property would you like to edit? ");
        switch (input.nextInt()) {
            case 1 -> {
                System.out.print("What is the new task name? ");
                input.nextLine();
                name = input.nextLine();
            }
            case 2 -> {
                System.out.print("What is the new priority? (true or false) ");
                priority = input.nextBoolean();
            }
            case 3 -> {
                return;
            }
        }
        System.out.println("Here is the updated task");
        printTask();
    }
}
