package pl.coderslab.constants;

public class StringConstants {
    public static final String MENU_HEADLINE = "Please select an option:";

    public static final String SAVE_FILE_NOT_EXIST_MSG = "Save file does not exist. Creating new save file";

    public static final String SAVE_FILE_CREATED_MSG = "New save file created!";

    public static final String EXIT_PROGRAM_MSG = "Bye, bye.";

    public static final String ADD_TASK_DESCRIPTION_MSG = "Please add task description (don't use ', '): ";

    public static final String ADD_TASK_DUE_DATE_MSG = "Please add due date in format %s: "
            .formatted(FormatConstants.APP_DATE_FORMAT.toString());

    public static final String ADD_TASK_IMPORTANCE_MSG = "Is your task important? true/false: ";
}
