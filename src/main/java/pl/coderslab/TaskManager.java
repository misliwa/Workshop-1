package pl.coderslab;

import pl.coderslab.constants.StringConstants;

public class TaskManager {
    static void main() {
        showMenu();
    }

    private static void showMenu() {
        System.out.println(ConsoleColors.BLUE + StringConstants.MENU_HEADLINE);
        System.out.print(ConsoleColors.RESET);
        for(String menuItem : StringConstants.MENU_ITEMS){
            System.out.println(menuItem);
        }
    }
}
