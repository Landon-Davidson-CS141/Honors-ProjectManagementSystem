/*
Programmer: Landon Davidson
Section: 27258
Program Name: DatedTask

Description: Child class of Task object that takes a Date object of when the task needs to be done. Overrides Task's
printTask() and editTask() methods.
 */

package cs141.landon;

import java.util.Date;
import java.util.Scanner;

public class DatedTask extends Task{
    private Date date;
    public DatedTask(String name, boolean priority, Date date) {
        super(name, priority);
        this.date = date;
    }

    @Override
    public void printTask() {
        super.printTask();
        System.out.println("    Due Date: " + date);
    }

    @Override
    public void editTask(Scanner input) {
        System.out.println();
        System.out.println("1. Name: " + name);
        System.out.println("2. Priority: " + priority);
        System.out.println("3. Due Date: " + date);
        System.out.println("4. Cancel");
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
                System.out.print("What is the new due date? ");
                date = new Date();
            }
        }
        System.out.println("Here is the updated task");
        printTask();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
