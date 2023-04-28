package Controllers;

import java.util.List;

import StudentDomen.Student;
import StudentService.StudentGroupService;
import StudentService.StudentService;

// Контроллёр студентов
// Имплементируем каркас - интерфейс iUserController
public class StudentController implements iUserController<Student> {

    // В этом контроллёре создаём единственный экземпляр класса StudentService
    // и также экземпляр класса StudentGroupService
    private final StudentService studentService = new StudentService();
    private final StudentGroupService groupService = new StudentGroupService();

    // Создаём студента, айди студента создастся автоматически в классе StudentService
    // Переопределяем от iUserController
    @Override
    public void create(String firstName, String secondName, int age) {
        studentService.create(firstName, secondName, age);
    }

    // Создаём группу
    public void createGroup(List<Student> students, int groupId) {
        groupService.create(students, groupId);
    }

    // Возращаем всех студентов
    @Override
    public List<Student> getAll() {
        return studentService.getAll();
    }
}
