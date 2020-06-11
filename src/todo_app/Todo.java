package todo_app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Todo {
    //private static List<String> taskList = new ArrayList<>();
    private TaskList taskList = new TaskList();


    public static void main(String[] args) throws IOException {
        Path tasks = Paths.get("../tasks.txt");


        if (args.length == 0) {

            System.out.println("Command Line Todo Application \n============================= \n" +
                    "Command line arguments: \n\t-l   Lists all the tasks\n\t-a   Adds a new task\n" +
                    "\t-r   Removes an task\n" +
                    "\t-c   Completes an task");

        } else if (args[0].equals("-l")) {
            listTasks(tasks);
        } else if (args[0].equals("-a")) {
            if (args.length < 2) {
                System.out.println("Should provide another parameter.");
                System.exit(2);
            }
            addTask(tasks, args[1]);
            System.out.println("todo_app.Task added successfully!");
        } else if (args[0].equals("-c")){

        }

    }

   /* public static todo_app.TaskList listTasks(Path fileName) {

        if (taskList.isEmpty()) {
            System.out.println("No todos for today! :)");
        }
        Path filePath = Paths.get(String.valueOf(fileName));

        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i + 1) + " - " + taskList.get(i));

        }

        return taskList;
    }*/


    public static void addTask(Path fileName, String task) {
        taskList.add(task);
        try {
            Path filePath = Paths.get(String.valueOf(fileName));
            Files.write(filePath, taskList);

        } catch (IOException e) {
            System.out.println("Uh-oh, could not write the file!");

        }
    }


}

