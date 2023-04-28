package StudentService;

import java.util.ArrayList;
import java.util.List;

import StudentDomen.Teacher;
import StudentDomen.UserComporator;

// Здесь будет храниться список всех учителей
public class TeacherService implements iUserService<Teacher> {
    
    private int count; // Сквозной номер всех учителей
    private List<Teacher> teachers; // Список всех учителей

    // Конструктор
    public TeacherService() {
        // При инициализации создаём пустой список учителей
        this.teachers = new ArrayList<Teacher>();
    }

    // Геттер - получить всех учителей
    // Переопределяем от iUserService
    @Override
    public List<Teacher> getAll() {
        return this.teachers;
    }

    // Создаём учителя, добавляем его в общий список учителей
    // Переопределяем от iUserService
    @Override
    public void create(String firstName, String secondName, int age) {
        // Вместо создаваемого вручную айди работника мы передаём сквозной номер count
        Teacher person = new Teacher(firstName, secondName, age, count);
        count ++;
        teachers.add(person);
    }

    // Применим компоратор UserComporator для сортировки учителей по имени и фамилии
    // Передаём индекс группы
    public List<Teacher> getSortedByFIOTeachers() {
        
        List<Teacher> teachersSorted = new ArrayList<>(teachers);

        teachersSorted.sort(new UserComporator<Teacher>());

        return teachersSorted;
    }
    
}