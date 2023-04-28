package StudentService;

import java.util.ArrayList;
import java.util.List;

import StudentDomen.Student;

// Здесь будет храниться список всех студентов, которые учатся в интституте
public class StudentService implements iUserService<Student> {
    
    private int count; // Сквозной номер всех студентов
    private List<Student> students; // Список всех студентов

    // Конструктор 
    public StudentService() {
        // При инициализации создаём пустой список студентов
        this.students = new ArrayList<Student>();
    }

    // Геттер - получить всех студентов
    // Переопределяем от iUserService
    @Override
    public List<Student> getAll() {
        return this.students;
    }

    // Создание студента - добавление в общий список студентов
    // Переопределяем от iUserService
    @Override
    public void create(String firstName, String secondName, int age) {
        // Вместо создаваемого вручную айди студента мы передаём сквозной номер count
        Student person = new Student(firstName, secondName, age, count);
        count ++;
        students.add(person);
    }
}
