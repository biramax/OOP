
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import Controllers.EmploeeContoller;
import Controllers.StudentController;
import StudentDomen.AverageAge;
import StudentDomen.Emploee;
import StudentDomen.Student;
import StudentDomen.StudentGroup;
import StudentDomen.StudentStream;
import StudentDomen.Teacher;
import StudentDomen.User;
import StudentService.StudentGroupService;
import StudentService.TeacherService;

public class App {

    private static StudentGroup group;
    private static StudentStream stream;
    private static TeacherService tService;

    public static void main(String[] args) throws Exception {
        
        // Всю нашу практику распределяю по методам, чтобы не было здесь кучи всего. Для этого создаём некоторые поля, чтобы с ними работать из разных методов.

        // Создаём просто юзера и создаём студента, выводим через переопределённый toString()
        startPractice();

        // Создаём группу студентов
        createGroup();

        // Перечисляем группу студентов
        iterateGroup();

        // Cортируем студентов в группе, выводим
        sortStudentsInGroup();

        // Создаём поток студентов
        createStream();

        // Перечисляем поток студентов
        iterateStream();

        // Cортируем группы в потоке студентов, выводим
        sortGroupsInStream();

        // Выплачиваем зарплату работнику
        paySalary();

        // Считаем средние значения
        mean();

        // Создаём учителей и выводим в отсортированном виде
        createAndSortTeachers();

        // Выводим средний возраст учителей и студентов
        averageAge();
    }

    public static void startPractice() {

        User u1 = new User("Сергей","Иванов",25);
        Student s1 = new Student("Сергей", "Иванов", 22, (long)101);
        
        System.out.println("\n===== Просто экземпляр User и Student =====");
        System.out.println(u1);
        System.out.println(s1);
    }

    public static void createGroup() {

        // Создаём экземпляры студентов, чтобы потом включить их в группу
        Student s1 = new Student("Сергей", "Иванов", 22, (long)101);
        Student s2 = new Student("Андрей", "Сидоров", 22, (long)111);
        Student s3 = new Student("Иван", "Петров", 22, (long)121);
        Student s4 = new Student("Игорь", "Иванов", 23, (long)301);
        Student s5 = new Student("Даша", "Цветкова", 23, (long)171);
        Student s6 = new Student("Лена", "Незабудкина", 23, (long)104);

        // Создаём список из экземпляров студентов
        List<Student> listStud = new ArrayList<Student>();
        listStud.add(s1);
        listStud.add(s2);
        listStud.add(s3);
        listStud.add(s4);
        listStud.add(s5);
        listStud.add(s6);

        // Создаём экземпляр группы студентов
        group = new StudentGroup(listStud, 577);
    }

    public static void iterateGroup() {
        
        // Можно перечислить сам массив студентов, входящих в группу
        System.out.println("\n===== Перечисляем студентов, входящих в группу, как массив =====");
        for(Student stud : group.getStudents())
            System.out.println(stud);
    
        // Благодаря внедрению итератора в классе StudentGroup мы можем перечислять саму группу, как массив
        System.out.println("\n===== Перечисляем группу студентов через итератор =====");
        for(Student stud : group)
            System.out.println(stud);
    }

    public static void sortStudentsInGroup() {

        // Для возможности сравнения массива студентов, входящих в группу, мы имплементировали к классу Student интерфейс Comparable и реализовали в нём метод compareTo      
        
        System.out.println("\n===== В сортировке по возрасту и ID =====");
        
        // Сортируем массив по возрасту и id (с одинаковым возрастом)
        Collections.sort(group.getStudents());

        // Перечисляем
        for(Student stud : group)
            System.out.println(stud);
    }

    public static void createStream() {
        
        // Создаём ещё пару групп, объединяем все три в массиве и передаём в поток
        stream = new StudentStream(new ArrayList<StudentGroup>(Arrays.asList(
            group,
            new StudentGroup(
                new ArrayList<Student>(Arrays.asList(
                    new Student("Максим", "Бобков", 34, (long)1105),    
                    new Student("Иван", "Каплин", 32, (long)1108),
                    new Student("Лариса", "Емцова", 30, (long)1109),
                    new Student("Валера", "Лисицин", 33, (long)1106),
                    new Student("Анна", "Харламова", 31, (long)1102)
                )), 579
            ),

            new StudentGroup(
                new ArrayList<Student>(Arrays.asList(
                    new Student("Константин", "Камшин", 34, (long)1204),
                    new Student("Елена", "Черткова", 32, (long)1208),
                    new Student("Сергей", "Репников", 40, (long)1209),
                    new Student("Наталья", "Еланцева", 33, (long)1206),
                    new Student("Лев", "Ноппе", 31, (long)1202)
                )), 578
            )
        )), 1, "Физмат");
    }

    public static void iterateStream() {
        
        // Благодаря внедрению итератора в классе StudentStream мы можем перечислять поток, как массив
        System.out.println("\n===== Перечисляем поток студентов через итератор =====");
        
        System.out.println(stream);

        // Перечисляем группы в потоке
        for(StudentGroup group : stream) {

            System.out.println("  "+group);
            
            // Перечисляем студентов в каждой группе
            for(Student stud : group)
                System.out.println("    "+stud);
        }
    }

    public static void sortGroupsInStream() {

        // Для возможности сравнения массива групп, входящих в поток, мы имплементировали к классу StudentGroup интерфейс Comparable и реализовали в нём метод compareTo
        
        System.out.println("\n===== Сортировка групп по числу студентов =====");
        
        // Сортируем массив по числу студентов в группах и по номеру группы
        Collections.sort(stream.getStudentGroups());

        System.out.println(stream);

        // Перечисляем
        for(StudentGroup group : stream)
            System.out.println("  "+group);
    }

    public static void paySalary() {

        System.out.println("\n===== Выплата зарплаты =====");

        Emploee person1 = new Emploee("Иванов", "Олег", 55, 110);

        // Если бы метод EmploeeContoller.paySalary() не был статичным
        //EmploeeContoller contrEmp = new EmploeeContoller();
        //contrEmp.paySalary(person1);

        EmploeeContoller.paySalary(person1);
    }

    public static void mean() {
        
        System.out.println("\n===== Среднее значение посещаемости =====");
        Integer studHour[] = {124, 234, 231, 1, 45};
        System.out.println(EmploeeContoller.mean(studHour));

        System.out.println("\n===== Среднее значение зарплаты =====");
        Double emplSalary[] = {12555.23, 34213.5, 10000.0};
        System.out.println(EmploeeContoller.mean(emplSalary));        
    }

    public static void createAndSortTeachers() {

        System.out.println("\n===== Вывод учителей в сортировке по имени и фамилии =====");

        // Создаём учителей
        tService = new TeacherService();
        tService.create("Екатерина", "Икаева", 43);
        tService.create("Андрей", "Нечеткин", 35);
        tService.create("Андрей", "Луцкий", 44);
        tService.create("Роза", "Иванова", 55);
        tService.create("Любовь", "Макарова", 51);
        tService.create("Иван", "Дмитриев", 49);
        
        // Сортировка учителей 
        List<Teacher> tSorted = tService.getSortedByFIOTeachers();
        
        for (Teacher t : tSorted)
            System.out.println(t);
    }

    public static void averageAge() {

        System.out.println("\n===== Средний возраст учителей =====");

        AverageAge<Teacher> avAgeTeachers = new AverageAge<Teacher>();
        System.out.println(avAgeTeachers.calcAverageAge(tService.getAll()));

        System.out.println("\n===== Средний возраст студентов =====");

        // У нас уже есть поток студентов, созданный ранее. Можно им воспользоваться. Для этого я добавил в класс StudentStream() метод getAllStudents(), чтобы получить студентов во всех группах единым списком
        AverageAge<Student> avAgeStudents = new AverageAge<Student>();
        System.out.println(avAgeStudents.calcAverageAge(stream.getAllStudents()));
    }
}
