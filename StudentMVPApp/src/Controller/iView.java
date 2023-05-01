package Controller;

import java.util.List;

import Model.Student;

public interface iView {

    // Отображать студентов
    void printAllStudents(List<Student> students);

    // Считывание данных с консоли
    String prompt(String message);
    Long promptLong(String message);
}
