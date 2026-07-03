package pl.coderslab;

import pl.coderslab.enums.MenuItem;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        launchMenu();
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

    private static void launchMenu() {
        MenuItem pickedMode;

        programloop:
        while(true) {
            printMenuItems();
            try {
                pickedMode = pickMenuOption();
                switch (pickedMode) {
                    case MenuItem.ADD -> addTaskMode();
                    case MenuItem.REMOVE -> removeTaskMode();
                    case MenuItem.LIST -> printAllTasks();
                    case MenuItem.EXIT -> {
                        exitProgram();
                        break programloop;
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Please select a correct option.");
            }
        }
    }

    private static void printMenuItems(){
        System.out.println(ConsoleColors.BLUE + MENU_HEADLINE);
        System.out.print(ConsoleColors.RESET);
        for(MenuItem menuItem : MenuItem.values()){
            System.out.println(menuItem.toString().toLowerCase());
        }
    }

    private static MenuItem pickMenuOption(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        return MenuItem.valueOf(input.toUpperCase());
    }

    private static void addTaskMode() {

    }

    private static void removeTaskMode() {
    }

    private static void printAllTasks(){
        for(Task task : tasks){
            System.out.println(task.toSaveFileLine());
        }
    }

    private static void exitProgram(){
    }

}
