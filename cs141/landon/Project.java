package cs141.landon;

import java.util.ArrayList;
import java.util.Date;

public class Project {
    protected ArrayList<Task> tasks = new ArrayList<>();
    protected String name;

    public static void main(String[] args) {
        Project obj = new Project("Programming Assignment");
        obj.addDatedTask("Decide Project", true, new Date());
        obj.addDefaultTask("Finish Project", false);
        obj.addDefaultTask("Get Permission", true);
        obj.print();
    }

    public Project(String name) {
        this.name = name;
    }

    public void addDefaultTask(String taskName, boolean priority) {
        tasks.add(new DefaultTask(taskName, priority));
    }

    public void addDatedTask(String taskName, boolean priority, Date taskDate) {
        tasks.add(new DatedTask(taskName, priority, taskDate));
    }

    public void removeTask(int index) {
        tasks.remove(index);
    }

    public void print() {
        ArrayList<Task> temp = new ArrayList<>();
        System.out.println("Project: " + name);
        for (Task task : tasks) {
            if (task.getPriority()) {
                task.printTask();
            } else {
                temp.add(task);
            }
        }
        for (Task task : temp) {
            task.printTask();
        }
    }
}
