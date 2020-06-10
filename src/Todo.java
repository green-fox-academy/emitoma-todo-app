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
//            System.out.println(listTasks("../tasks.txt"));
            listTasks("../tasks.txt");
        }

    }

    public static List listTasks(String fileName) {
        List<String> lines = new ArrayList<>();

//        List<String> print = new ArrayList<>();

        try {
            Path filePath = Paths.get(fileName);
            lines = Files.readAllLines(filePath);
            for (int i = 0; i < lines.size(); i++) {
                System.out.println((i+1) + " - " + lines.get(i));

            }

        } catch (IOException e) {
            System.out.println("Looks like is doesn't work!");
            System.exit(2);
        }

        return lines;
    }
}
