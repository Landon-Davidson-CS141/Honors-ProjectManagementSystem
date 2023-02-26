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
                case 5 -> running = false;
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
        String name = input.next();
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
        }
        userProject.print();
        input.nextLine();
        System.out.print("Which task would you like to edit? (Enter the full task name) ");
        String userBody = input.nextLine();

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
        System.out.println("5. Exit");

        System.out.print("Please enter which action you would like to take: ");
        return input.nextInt();
    }
}
