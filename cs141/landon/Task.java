/*
Programmer: Landon Davidson
Section: 27258
Program Name: Task

Description: Abstract class that defines a basic printTask() method and an abstract
editTask() method.
 */

package cs141.landon;

import java.util.Scanner;

public abstract class Task {
    protected String name;
    protected boolean priority;

    public Task(String name, boolean priority) {
        this.name = name;
        this.priority = priority;
    }

    public void printTask() {
        if (priority) {
            System.out.println("  Priority Task: " + name);
        } else {
            System.out.println("  Task: " + name);
        }
    }

    public abstract void editTask(Scanner input);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }
}
