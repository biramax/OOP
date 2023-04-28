package Controllers;

import StudentDomen.User;

import java.util.List;

import StudentDomen.Emploee;
import StudentService.EmploeeService;

// Бухгалтерия, которая будет заниматься работниками
public class EmploeeContoller implements iUserController<Emploee> {
    
    private final EmploeeService empService = new EmploeeService();

    // Создаём работника, айди работника создастся автоматически в классе EmploeeService
    // Переопределяем от iUserController
    @Override
    public void create(String firstName, String secondName, int age) {
        empService.create(firstName, secondName, age);
    }

    // Метод выплаты зарплаты работнику - дженерик (ставим extends, чтобы ЗП не получил студент, а только Emploee и все его потомки)
    // Делаем метод статичным, чтобы к нему можно было обратиться отовсюду из кода
    static public <T extends Emploee> void paySalary(T person) {
        
        System.out.println(((User) person).getFirstName()+" ЗП 10000р.");
    }

    // Среднее значение - дженерик (принимает все типы, основанные на Number)
    static public <T extends Number> Double mean(T[] num) {
        
        double sum = 0.0;

        for (int i = 0; i < num.length; i ++)
            sum = sum + num[i].doubleValue();
        sum = sum/num.length;
        
        return sum;
    }

    // Возращаем всех работников
    @Override
    public List<Emploee> getAll() {
        return empService.getAll();
    }
}
