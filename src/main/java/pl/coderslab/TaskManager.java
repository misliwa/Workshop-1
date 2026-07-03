package pl.coderslab;

import pl.coderslab.constants.StringConstants;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<String> tasks = new ArrayList<>();

    static void main() {
        loadSavedTasksData();
        showMenu();
    }

    private static void loadSavedTasksData() {

    }

    private static void showMenu() {
        System.out.println(ConsoleColors.BLUE + StringConstants.MENU_HEADLINE);
        System.out.print(ConsoleColors.RESET);
        for(String menuItem : StringConstants.MENU_ITEMS){
            System.out.println(menuItem);
        }
    }
}
