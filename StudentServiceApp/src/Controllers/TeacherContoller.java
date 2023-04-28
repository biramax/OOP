package Controllers;

import java.util.List;

import StudentDomen.Teacher;
import StudentService.TeacherService;

// Центр управления процессами по учителям
public class TeacherContoller implements iUserController<Teacher> {
    
    private final TeacherService teacherService = new TeacherService();

    // Создаём учителя, айди создастся автоматически в классе TeacherService
    // Переопределяем от iUserController
    @Override
    public void create(String firstName, String secondName, int age) {
        teacherService.create(firstName, secondName, age);
    }

    // Возращаем всех учителей
    @Override
    public List<Teacher> getAll() {
        return teacherService.getAll();
    }
}
