package pl.coderslab;

import java.time.LocalDate;

public class Task {
    private String name;
    private String dueDate;
    private String important;

    public Task(String name, String dueDate, String important) {
        this.name = name;
        this.dueDate = dueDate;
        this.important = important;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String isImportant() {
        return important;
    }

    public void setImportant(String important) {
        this.important = important;
    }

    public String toSaveFileLine(){
        return "%s, %s, %s".formatted(name, dueDate, important);
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", important='" + important + '\'' +
                '}';
    }
}
