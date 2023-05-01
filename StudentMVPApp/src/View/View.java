package View;

import java.util.List;
import java.util.Scanner;

import Controller.iView;
import Model.Student;

// Считывает с консоли команды от пользователя
// Выводит список всех студентов в консоль
public class View implements iView {
    
    // Вывод в консоль
    public void printAllStudents(List<Student> students) {
        
        System.out.println("===== Список студентов =====");
        for (Student person : students)
            System.out.println(person);

        System.out.println("===== Конец списка =====");
    }

    // Считывание данных с консоли
    public String prompt(String message) {
        Scanner in = new Scanner(System.in, "Cp866");
        System.out.println(message);
        return in.nextLine();
    }

    // Считывание данных с консоли в формате Long
    public Long promptLong(String message) {
        Scanner in = new Scanner(System.in, "Cp866");
        System.out.println(message);
        return in.nextLong();
    }
}
