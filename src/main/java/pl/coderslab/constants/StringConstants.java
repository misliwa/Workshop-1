package pl.coderslab.constants;

public class StringConstants {
    public static final String MENU_HEADLINE = "Please select an option:";

    public static final String SAVE_FILE_NOT_EXIST_MSG = "Save file does not exist. Creating new save file";

    public static final String SAVE_FILE_CREATED_MSG = "New save file created!";

    public static final String EXIT_PROGRAM_MSG = "Bye, bye.";

    public static final String ADD_TASK_DESCRIPTION_MSG = "Please add task description (don't use ', '): ";

    public static final String INCORRECT_TASK_DESCRIPTION_MSG = "Description contains illegal expression ', '.";

    public static final String ADD_TASK_DUE_DATE_MSG = "Please add due date in format %s: "
            .formatted(FormatConstants.APP_DATE_FORMAT.toString());

    public static final String INCORRECT_DUE_DATE_DESCRIPTION_MSG = "Date is not correct.";

    public static final String ADD_TASK_IMPORTANCE_MSG = "Is your task important? true/false: ";

    public static final String INCORRECT_TASK_IMPORTANCE_MSG = "Provided importance is incorrect.";

    public static final String REMOVE_TASK_MSG = "Please select number to remove. T"


}
