package StudentService;

import java.util.ArrayList;
import java.util.List;

import StudentDomen.Emploee;
import StudentDomen.UserComporator;

// Здесь будет храниться список всех работников, которые работают в интституте
public class EmploeeService implements iUserService<Emploee> {
    
    private int count; // Сквозной номер всех студентов
    private List<Emploee> emploees; // Список всех работников

    // Конструктор
    public EmploeeService() {
        // При инициализации создаём пустой список работников
        this.emploees = new ArrayList<Emploee>();
    }

    // Геттер - получить всех работников
    // Переопределяем от iUserService
    @Override
    public List<Emploee> getAll() {
        return this.emploees;
    }

    // Создаём работника, добавляем его в общий список работников
    // Переопределяем от iUserService
    @Override
    public void create(String firstName, String secondName, int age) {
        // Вместо создаваемого вручную айди работника мы передаём сквозной номер count
        Emploee person = new Emploee(firstName, secondName, age, count);
        count ++;
        emploees.add(person);
    }

    // Применим компоратор UserComporator для сортировки работников
    // Передаём индекс группы
    public List<Emploee> getSortedByFIOEmploee() {
        
        List<Emploee> emps = new ArrayList<>(emploees);

        emps.sort(new UserComporator<Emploee>());

        return emps;
    }
}