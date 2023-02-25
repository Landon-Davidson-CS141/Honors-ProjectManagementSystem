package cs141.landon;

import java.util.Date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
