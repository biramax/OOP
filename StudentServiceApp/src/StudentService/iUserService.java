package StudentService;

import java.util.List;

// Интерфейс для "сервисов"
// Имплементируем его ко всем ...Service() с типом соотв. объекта
// Это дженерик, которым можно пользоваться и для студентов, и для учителей и т.д.
public interface iUserService<T> {

    // Получаем всех студентов или учителей или работников...
    List<T> getAll();
    
    // Создаём студента, учителя, работника...
    void create(String firstName, String secondName, int age);
}
