import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import Controller.Controller;
import Controller.iModel;
import Controller.iView;
import Controller.Langs;
import Model.FileRepo;
import Model.HashMapDB;
import Model.Model;
import Model.Student;
import View.View;
import View.ViewEng;

public class App {
    
    public static void main(String[] args) throws Exception {

        // Выбор языка
        langSelect();

        // В зависимости от выбранного языка, загружаем русскую или английскую Вьюшку
        iView view = Langs.lang.equals("RUS") ? new View() : new ViewEng();

        // Формат Модели
        String modelType = "file"; // ram, file, hashmap

        // Используем Модель, работающую с памятью
        if (modelType == "ram") {

            List<Student> students = new ArrayList<Student>(Arrays.asList(
                new Student("Сергей", "Иванов", 22, (long)101),
                new Student("Андрей", "Сидоров", 22, (long)111),
                new Student("Иван", "Петров", 22, (long)121),
                new Student("Игорь", "Иванов", 23, (long)301),
                new Student("Даша", "Цветкова", 23, (long)171),
                new Student("Лена", "Незабудкина", 23, (long)104)
            ));
    
            iModel model = new Model(students);
            
            Controller control = new Controller(view, model);
            control.run();
        }
        
        // Используем Модель, работающую с файлами
        else if (modelType == "file") {
            
            FileRepo fileRepo = new FileRepo("StudentsDb.txt");
            
            /* Код на один раз - сохраняем список в файле ======================            
            // Переносим студентов в fileRepo
            for (Student person : students)
            fileRepo.addStudent(person);
            
            // И сохраняем в файл
            fileRepo.saveAllStudentsToFile();
            /Код на один раз - сохраняем список в файле ===================== */

            iModel modelFileRepo = fileRepo;

            Controller control = new Controller(view, modelFileRepo);
            control.run();
        }

        // Используем Модель, работающую с ХэшМап
        else if (modelType == "hashmap") {
            
            HashMapDB hashMapDB = new HashMapDB();

            hashMapDB.addStudent("Сергей", "Иванов", 22, (long)101);
            hashMapDB.addStudent("Андрей", "Сидоров", 22, (long)111);
            hashMapDB.addStudent("Иван", "Петров", 22, (long)121);
            hashMapDB.addStudent("Игорь", "Иванов", 23, (long)301);
            hashMapDB.addStudent("Даша", "Цветкова", 23, (long)171);
            hashMapDB.addStudent("Лена", "Незабудкина", 23, (long)104);
            
            iModel modelHashMap = hashMapDB;

            Controller control = new Controller(view, modelHashMap);
            control.run();
        }        
    }

    public static void langSelect() {

        Scanner in = new Scanner(System.in, "Cp866");
        
        System.out.println("Интерфейс программы доступен на следующих языках:");

        for (Langs lang : Langs.values())
            System.out.println("- "+lang.name()+" ("+lang.label+")");

        // Вводим бесконечный цикл, чтобы получать одну за другой команды от пользователя
        while (true) {

            System.out.println("Введите нужный язык (либо EXIT для выхода):");
            
            String command = in.nextLine();

            try {
                command = command.toUpperCase();
                if (command.equals("EXIT")) {
                    System.out.println("Выход из программы.");
                    System.exit(0);
                }

                Langs com = Langs.valueOf(command.toUpperCase());
                Langs.lang = com.name();
                System.out.println("Выбран язык - "+com.label);
                System.out.println("=====");
                return;
            }
            catch(Exception e) {
                System.out.println("Некорректная команда!");
            }
        }
    }
}
