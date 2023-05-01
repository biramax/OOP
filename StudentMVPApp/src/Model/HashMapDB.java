package Model;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import Controller.iModel;

public class HashMapDB implements iModel {

    // Список студентов
    private HashMap<Long, Student> students;

    public HashMapDB() {
        // Создаём путой HashMap студентов при инициализации
        students = new HashMap<Long, Student>();
    }

    // Добавляем студента в HashMap
    public void addStudent(String firstName, String secondName, int age, long studentID) {
        students.put(studentID, new Student(firstName, secondName, age, studentID));
    }

    // Переводим список студентов из формата HashMap в формат List и возвращаем
    // Переопределяем метод из интерфейса iModel
    @Override
    public List<Student> getAllStudents() {
        
        List<Student> studList = new ArrayList<Student>(); 
        
        for (var stud : students.entrySet())
            studList.add(stud.getValue());

        return studList;
    }

    // Удаляем студента, зная его ID
    // Переопределяем метод из интерфейса iModel
    @Override
    public boolean deleteStudent(long studentID) {
        if (students.containsKey(studentID)) {
            students.remove(studentID);
            return true;
        }
        return false;
    }
}