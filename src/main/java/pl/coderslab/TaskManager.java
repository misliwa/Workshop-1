package pl.coderslab;

import pl.coderslab.constants.PathConstants;
import pl.coderslab.constants.StringConstants;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private static List<Task> tasks = new ArrayList<>();

    static void main() {
        try {
            loadSavedTasksData();
            System.out.println(tasks);
        } catch (IOException e) {
            System.out.println("Błąd wczytywania danych: " + e.getMessage());
        }

        showMenu();
    }

    private static void loadSavedTasksData() throws IOException {
        List<String> lines = Files.readAllLines(PathConstants.savedTasksFile);
            for (String line : lines) {
                String[] dataRow = line.split(", ");
                tasks.add(new Task(dataRow[0], dataRow[1], dataRow[2]));
            }
    }

    private static void showMenu() {
        System.out.println(ConsoleColors.BLUE + StringConstants.MENU_HEADLINE);
        System.out.print(ConsoleColors.RESET);
        for(String menuItem : StringConstants.MENU_ITEMS){
            System.out.println(menuItem);
        }
    }
}
