package Model;

import java.util.List;

import Controller.iModel;

// Модуль работает с данными
public class Model implements iModel {
    
    // Список студентов
    private List<Student> students;

    // Конструктор - передаём список студентов
    public Model(List<Student> students) {
        this.students = students;
    }

    // Возвращает список всех студентов
    public List<Student> getAllStudents() {
        return students;
    }

    // Удаляем студента, зная его ID
    // Переопределяем метод из интерфейса iModel
    @Override
    public boolean deleteStudent(long studentID) {

        for (int i = 0; i < students.size(); i ++) {
            if (students.get(i).getStudentID() == studentID) {
                students.remove(i);
                return true;
            }
        }
        
        return false;
    }
}
