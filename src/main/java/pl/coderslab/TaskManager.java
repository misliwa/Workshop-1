package pl.coderslab;

import pl.coderslab.constants.PathConstants;
import pl.coderslab.constants.StringConstants;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static pl.coderslab.constants.StringConstants.*;
import static pl.coderslab.constants.PathConstants.*;

public class TaskManager {
    private static List<Task> tasks = new ArrayList<>();

    static void main() {
        try {
            prepareFiles();
        } catch (IOException e) {
            System.out.println("Data loading error: " + e.getMessage());
            System.out.println("Closing app.");
        }
        
        showMenu();
    }

    private static void prepareFiles() throws IOException{
        if(Files.exists(SAVED_TASKS_PATH)) {
            loadSavedTasksData();
        }else{
            System.out.println(SAVE_FILE_NOT_EXIST_MSG);

            Files.createFile(SAVED_TASKS_PATH);

            System.out.println(SAVE_FILE_CREATED_MSG);
        }
    }

    private static void loadSavedTasksData() throws IOException {
            List<String> lines = Files.readAllLines(SAVED_TASKS_PATH);
            for (String line : lines) {
                String[] dataRow = line.split(", ");
                tasks.add(new Task(dataRow[0], dataRow[1], dataRow[2]));
            }
    }

    private static void printAllTasks(){
        for(Task task : tasks){
            System.out.println(task.toSaveFileLine());
        }
    }

    private static void showMenu() {
        System.out.println(ConsoleColors.BLUE + MENU_HEADLINE);
        System.out.print(ConsoleColors.RESET);
        for(String menuItem : MENU_ITEMS){
            System.out.println(menuItem);
        }
    }
}
