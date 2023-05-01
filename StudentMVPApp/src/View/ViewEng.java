package View;

import java.util.List;
import java.util.Scanner;

import Controller.iView;
import Model.Student;

// Вариант класса View на английском языке
// Считывает с консоли команды от пользователя
// Выводит список всех студентов в консоль
public class ViewEng implements iView {
    
    // Вывод в консоль
    public void printAllStudents(List<Student> students) {
        
        System.out.println("===== Students List =====");
        for (Student person : students)
            System.out.println(person);

        System.out.println("===== List End =====");
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
