package pl.coderslab;

import pl.coderslab.constants.FormatConstants;
import pl.coderslab.enums.MenuItem;

import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
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
        Scanner scanner = new Scanner(System.in);

        System.out.println(ADD_TASK_DESCRIPTION_MSG);
        String descriptionInput = scanner.nextLine();

        while(descriptionInput.contains(", ")) {
            System.out.println("Description contains illegal expression ', '." + ADD_TASK_DESCRIPTION_MSG);
            descriptionInput = scanner.nextLine();
        }

        System.out.println(ADD_TASK_DUE_DATE_MSG);
        String dueDateInput = scanner.nextLine();
        while(!isValidDate(dueDateInput)) {
            System.out.println("Date is not correct." + ADD_TASK_DUE_DATE_MSG);
            dueDateInput = scanner.nextLine();
        }

        System.out.println(ADD_TASK_IMPORTANCE_MSG);
        String priorityInput = scanner.nextLine();
        while(!"true".equals(priorityInput) && !"false".equals(priorityInput)) {
            System.out.println("Input is not correct." + ADD_TASK_IMPORTANCE_MSG);
            priorityInput = scanner.nextLine();
        }

        Task createdTask = new Task(descriptionInput, dueDateInput, priorityInput);
        tasks.add(createdTask);
        printAllTasks();
    }

    private static void removeTaskMode() {
    }

    private static void printAllTasks(){
        for(Task task : tasks){
            System.out.println(task.toSaveFileLine());
        }
    }

    private static void exitProgram(){
        saveChangesToFile();
        System.out.println(ConsoleColors.RED + EXIT_PROGRAM_MSG);
    }

    private static void saveChangesToFile() {

    }

    private static boolean isValidDate(String stringDate){
        try{
            LocalDate date = LocalDate.parse(stringDate, FormatConstants.APP_DATE_FORMAT);
            return true;
        }catch (Exception e){
            return false;
        }
    }


}
