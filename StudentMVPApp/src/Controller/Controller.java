package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Student;
import Model.Model;
import View.View;

// Обрабатывает запросы от View и передаёт в работу в Model.
// При MVP обрабатывает также ответы Model и передаёт во View.
public class Controller {

    private List<Student> students;
    private iView view;
    private iModel model;

    // Конструктор
    // Связывает вьюшку и модель
    public Controller(iView view, iModel model) {
        this.view = view;
        this.model = model;
        this.students = new ArrayList<Student>();
    }

    // Сеттер для языка Вьюшки
    // public void setLang(lang) {
    //     this.lang = lang;
    // }

    // MVC ---------------------------------------------------------------
    // Вьюшка запрашивает у Конроллера список студентов.
    // Модель напрямую передаёт свои данные Вьюшке.
    public void updateViewMVC() {
        view.printAllStudents(model.getAllStudents());
    }
    // /MVC --------------------------------------------------------------

    // MVP ---------------------------------------------------------------
    // Берёт данные о студентах от Модели и кладёт их себе
    public void getAllStudents() {
        // Чтобы не взять данные дважды
        if (students.size() > 0)
            return;

        students = model.getAllStudents();
    }

    // Функция контроля данных, поступающих из Модели
    public boolean testData() {
        return students.size() > 0;
    }

    // Этот медод запрашивает Вьюшка, чтобы вывести нужные данные 
    public void updateView() {
        // Данные о студентах перешли в поле students
        getAllStudents();

        // Если проверка данных неуспешна, выводим ошибку
        if (testData())
            view.printAllStudents(students);    
        else
            System.out.println(Dict.get("emptyList"));
    }
    // /MVP --------------------------------------------------------------

    // Метод, который перехватывает команды от пользователя
    public void run() {

        Commands com = Commands.NONE;

        // Вводим бесконечный цикл, чтобы получать одну за другой команды от пользователя
        while (true) {
            
            String command = view.prompt(Dict.get("enterCommand"));

            try {
                com = Commands.valueOf(command.toUpperCase());
            
                switch(com) {
                    
                    // Команда на выход из программы
                    case EXIT:
                        // Прекращаем бесконечный цикл
                        System.out.println(Dict.get("exit"));
                        return;

                    // Команда на вывод списка студентов
                    case LIST:
                        getAllStudents();
                        updateView();
                        break;
                    
                    // Команда на удаление студента
                    case DELETE:
                        // Собираем список, иначе нельзя будет вызвать DELETE, пока не будет вызван LIST
                        getAllStudents();
                        Long studentID = view.promptLong(Dict.get("enterStudentId"));
                        boolean res = model.deleteStudent(studentID);
                        if (!res)
                            System.out.println(Dict.get("notFound"));
                        else {
                            System.out.println(Dict.get("deleted"));
                            updateView();
                        }
                        break;

                    default:
                        System.out.println(Dict.get("notCorrect"));
                        break;
                }
            }
            catch(Exception e) {
                System.out.println(Dict.get("notCorrect"));
            }
        }
    }
}
