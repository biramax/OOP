package Controller;

import java.util.List;

import Model.Student;

public interface iModel {

    // Получить всех студентов
    public List<Student> getAllStudents();

    // Удалить студента
    public boolean deleteStudent(long studentID);
}
