package StudentService;

import java.util.ArrayList;
import java.util.List;

import StudentDomen.Student;
import StudentDomen.StudentGroup;
import StudentDomen.UserComporator;

// Здесь будут храниться все группы в институте
public class StudentGroupService {
    
    private List<StudentGroup> groups; // Все группы студентов

    // Конструктор 
    public StudentGroupService() {
        // При инициализации создаём пустой список групп
        this.groups = new ArrayList<>();
    }

    // Геттер - получить все группы студентов
    public List<StudentGroup> getAll() {
        return this.groups;
    }

    // Создание группы - добавление в общий список групп
    public void create(List<Student> students, int groupId) {
        StudentGroup group = new StudentGroup(students, groupId);
        groups.add(group);
    }

    // Применим компоратор UserComporator для сортировки студентов группы
    // Передаём индекс группы
    public List<Student> getSortedByFIOStudentGroup(int groupIndex) {
        
        List<Student> students = new ArrayList<>(groups.get(groupIndex).getStudents());

        students.sort(new UserComporator<Student>());

        return students;
    }
}
