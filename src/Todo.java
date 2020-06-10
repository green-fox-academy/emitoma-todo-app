import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Todo {

    public static void main(String[] args) {

        if (args.length == 0) {

            System.out.println("Command Line Todo Application \n============================= \n" +
                    "Command line arguments: \n\t-l   Lists all the tasks\n\t-a   Adds a new task\n" +
                    "\t-r   Removes an task\n" +
                    "\t-c   Completes an task");
        } else if (args[0].equals("-l")) {
            Path tasks = Paths.get("../tasks.txt");
            listTasks(tasks);
        }

    }

    public static List listTasks(Path fileName) {
        List<String> lines = new ArrayList<>();

//        List<String> print = new ArrayList<>();

        try {
            Path filePath = Paths.get(String.valueOf(fileName));
            lines = Files.readAllLines(filePath);
            if (lines.isEmpty()) {
                System.out.println("No todos for today! :)");
            }
            for (int i = 0; i < lines.size(); i++) {
                System.out.println((i + 1) + " - " + lines.get(i));
            }


        } catch (IOException e) {
            System.out.println("Looks like is doesn't work!");
            System.exit(2);
        }

        return lines;
    }
    public static void addNewTask(String fileName){
        List<String> content = new ArrayList();

        content.add("First line of my file");

        try {
            Path filePath = Paths.get("assets/new-file.txt");
            Files.write(filePath, content);// Creates a new file if not exists and overwrites it's content
            // The elements of the content lists will become the lines of the file

        } catch (Exception e) {
            System.out.println("Uh-oh, could not write the file!");
        }


    }
}
