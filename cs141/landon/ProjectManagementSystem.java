/*
Programmer: Landon Davidson
Section: 27258
Program Name: ProjectManagementSystem

Description: Main program to manage Project objects. Prints a menu for the user to choose
an action from and has a method for each action to edit the necessary tasks and projects.
 */

package cs141.landon;

import java.util.ArrayList;
import java.util.Scanner;

public class ProjectManagementSystem {
    public static void main(String[] args) {
        System.out.println("--------------------");
        System.out.println("Welcome to Project Management Software 1.0\n");
        Scanner input = new Scanner(System.in);
        ProjectManagementSystem obj = new ProjectManagementSystem(input);

        boolean running = true;
        while (running) {
            switch (obj.printMenu()) {
                case 1 -> obj.addProject();
                case 2 -> obj.addTask();
                case 3 -> obj.print();
                case 4 -> obj.editTask();
                case 5 -> obj.removeTask();
                case 6 -> obj.removeProject();
                case 7 -> running = false;
            }
        }
    }

    ArrayList<Project> projects = new ArrayList<>();
    String userName;
    Scanner input;
    public ProjectManagementSystem(Scanner input) {
        this.input = input;
        System.out.print("What is your name? ");
        userName = input.next();
    }

    public void addProject() {
        System.out.print("\nPlease enter a name for your new project: ");
        input.nextLine();
        String name = input.nextLine();
        projects.add(new Project(name));
    }

    public void addTask() {
        printProjects();
        Project userProject;
        if (projects.size() != 1) {
            System.out.print("\nWhich project would you like to add a task to? ");
            userProject = projects.get(input.nextInt() - 1);
        } else {
            userProject = projects.get(0);
            System.out.println("\nYou only have one project, automatically selecting " + userProject.getName() + " project");
        }
        userProject.print();
        System.out.print("\nWhat is the task you want to add? ");
        input.nextLine();
        String taskName = input.nextLine();
        System.out.print("is this a priority task? (true or false) ");
        boolean taskPriority = input.nextBoolean();
        userProject.addTask(taskName, taskPriority);
    }

    public void print() {
        System.out.println("\n-----Printing projects now-----");
        for (Project project : projects) {
            project.print();
        }
        System.out.println("\nPress enter to continue");
        input.nextLine();
        input.nextLine();
    }

    public void editTask() {
        printProjects();
        Project userProject;
        if (projects.size() != 1) {
            System.out.print("\nWhich project would you like to add a task to? ");
            userProject = projects.get(input.nextInt() - 1);
        } else {
            userProject = projects.get(0);
            System.out.println("\nYou only have one project, automatically selecting " + userProject.getName() + " project");
        }
        userProject.print();
        input.nextLine();
        System.out.print("\nWhich task would you like to edit? (Enter the full task name) ");
        String userBody = input.nextLine();
        userProject.findTask(userBody).editTask(input);

    }

    private void printProjects() {
        if (projects.size() == 0) {
            System.out.println("\nYou haven't created any projects, creating one now");
            addProject();
            return;
        }
        System.out.println();
        int i = 0;
        for (Project project : projects) {
            System.out.println(++i + ". " + project.getName());
        }
    }

    public int printMenu() {
        System.out.println();
        System.out.println("1. Create New Project");
        System.out.println("2. Add New Task");
        System.out.println("3. View Projects and Tasks");
        System.out.println("4. Edit a Task");
        System.out.println("5. Remove a Task");
        System.out.println("6. Remove a Project");
        System.out.println("7. Exit");

        System.out.print("Please enter which action you would like to take: ");
        return input.nextInt();
    }

    public void removeTask() {
        printProjects();
        System.out.print("Which project would you like to remove a task from? ");
        Project userProject = projects.get(input.nextInt() - 1);
        userProject.print();

        input.nextLine();
        System.out.print("\nWhich task would you like to remove? (Enter the full task name) ");
        userProject.removeTask(userProject.findTaskIndex(input.nextLine()));

        System.out.println("Current Task list:");
        userProject.print();
    }

    public void removeProject() {
        printProjects();
        System.out.print("Which project would you like to remove? ");
        projects.remove(input.nextInt() - 1);

    }
}
