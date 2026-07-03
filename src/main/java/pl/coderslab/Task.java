package pl.coderslab;

import pl.coderslab.constants.ConsoleColors;
import pl.coderslab.constants.FormatConstants;

import java.time.LocalDate;

public class Task {
    private String name;
    private LocalDate dueDate;
    private boolean important;

    public Task(String name, String dueDate, String important) {
        this.name = name;
        this.dueDate = LocalDate.parse(dueDate, FormatConstants.APP_DATE_FORMAT);
        this.important = Boolean.parseBoolean(important);
    }

    public String toSaveFileLine(){
        String dueDateString = dueDate.toString();
        String importanceString = Boolean.toString(important);

        return "%s, %s, %s".formatted(name, dueDateString, importanceString);
    }
}
