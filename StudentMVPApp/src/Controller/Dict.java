package Controller;

import java.util.HashMap;
import java.util.Map;

public class Dict {
    
    private static HashMap<String, String[]> dictionary = new HashMap<>(Map.of(
        "enterCommand",   new String[] {"Введите команду:", "Enter command:"},
        "exit",           new String[] {"Выход из программы", "Exit from Programm"}, 
        "notCorrect",     new String[] {"Некорректная команда!", "Command is not correct!"},
        "emptyList",      new String[] {"Список студентов пуст!", "Students List is empty!"},
        "enterStudentId", new String[] {"Введите студента", "Enter student ID"},
        "notFound",       new String[] {"Студента с таким ID не найдёно", "There is no student with this ID"},
        "deleted",        new String[] {"Студент успешно удалён", "Student is successfully deleted"}
    ));
    
    public static String get(String key) {
        return dictionary.get(key)[Langs.lang == "RUS" ? 0 : 1];
    }
}
