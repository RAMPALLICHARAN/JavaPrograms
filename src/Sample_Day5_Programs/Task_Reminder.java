package Sample_Day5_Programs;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;


interface WorkTask {
    void executeTask();
}


abstract class AbstractWorkTask implements WorkTask {
    String taskName;

    AbstractWorkTask(String taskName) {
        this.taskName = taskName;
    }

    public void logStartTime() {
        System.out.println("Task Started: " + taskName + " at " + new Date());
    }
}


class AttendMeeting extends AbstractWorkTask {
    AttendMeeting() {
        super("Attend Meeting");
    }

    public void executeTask() {
        logStartTime();
        System.out.println("Joining Zoom/Teams call...");
    }
}

class CompleteTask extends AbstractWorkTask {
    CompleteTask() {
        super("Complete Assigned Work");
    }

    public void executeTask() {
        logStartTime();
        System.out.println("Working on assigned tasks...");
    }
}

class WriteCode extends AbstractWorkTask {
    WriteCode() {
        super("Write Code");
    }

    public void executeTask() {
        logStartTime();
        System.out.println("Writing and compiling code...");
    }
}

class ReviewExecution extends AbstractWorkTask {
    ReviewExecution() {
        super("Review Execution");
    }

    public void executeTask() {
        logStartTime();
        System.out.println("Reviewing output and logs...");
    }
}


class TaskReminder extends TimerTask {
    int count = 0;
    WorkTask[] taskList = {
        new AttendMeeting(),
        new CompleteTask(),
        new WriteCode(),
        new ReviewExecution()
    };

    public void run() {
        WorkTask task = taskList[count % taskList.length];
        task.executeTask();
        count++;
        System.out.println("-----------------------------------");
    }
}


public class Task_Reminder {
    public static void main(String[] args) {
        Timer timer = new Timer();

        System.out.println("Reminder system started at " + new Date());

        
        long interval = 10 * 1000;  
        

        timer.schedule(new TaskReminder(), 0, interval);
    }
}



