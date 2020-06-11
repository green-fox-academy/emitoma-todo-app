package todo_app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> taskList;

    public TaskList() {
        taskList = new ArrayList<>();
    }

    public void add(Task task) {
        taskList.add(task);
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i + 1) + " - " + taskList.get(i));

        }
        return result;
    }

    public java.util.List listTasks(TaskList taskList) {

        if (this.taskList.isEmpty()) {
            System.out.println("No todos for today! :)");
        }

        return this.taskList;
    }

    public void readFile(Path path) {
        try {
            this.taskList = Files.readAllLines(path);
        } catch (IOException e) {
            System.exit(2);
        }
    }
}
