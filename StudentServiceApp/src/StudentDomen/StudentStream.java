package StudentDomen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Группа студентов
// Этот класс не является ничьим потомком
// Подключая интерфейс Iterable, мы говорим, что класс итерируемый
public class StudentStream implements Iterable<StudentGroup> {

    // Список групп студентов (экземпляров класса StudentGroup)
    private List<StudentGroup> groups;

    // Номер курса
    private int courseNum;

    // Название потока
    private String name;

    // Констуктор
    public StudentStream(List<StudentGroup> groups, int courseNum, String name) {
        this.groups = groups;
        this.courseNum = courseNum;
        this.name = name;
    }

    // ГЕТТЕРЫ И СЕТТЕРЫ -----------------------------------------
    // Геттер списка студентов
    public List<StudentGroup> getStudentGroups() {
        return groups;
    }

    // Сеттер списка студентов
    public void setStudentGroups(List<StudentGroup> groups) {
        this.groups = groups;
    }

    // Геттер номера курса
    public int getСourseNum() {
        return courseNum;
    }

    // Сеттер номера курса
    public void setСourseNum(int courseNum) {
        this.courseNum = courseNum;
    }

    // Геттер названия потока
    public String getName() {
        return name;
    }

    // Сеттер названия потока
    public void setName(String name) {
        this.name = name;
    }
    // /ГЕТТЕРЫ И СЕТТЕРЫ -----------------------------------------

    // Переопределяем метод вывода информации о потоке
    @Override
    public String toString() {
        return "Stream{"+
            "courseNum=" +courseNum+", "+
            "streamName="+name+", "+
            "groupsCount="+groups.size()+
        "}";
    }
    
    // Реализуем метод iterator интерфейса Iterable (имплементировали к этому классу) для возможности перечисления списка экземпляров класса.
    // Реализация осуществляется через создание класса итератора, куда в качестве интерфейса пойдёт Iterator. Этот класс будет постоянно возвращать значение следующего элемента списка, пока они не исчерпаются.

    // Делаем через анонимный класс
    // Класс итератора требует переопределить два метода:
    // - hasNext()
    // - next()
    @Override
    public Iterator<StudentGroup> iterator() {

        return new Iterator<StudentGroup>() {

            private int index = 0;
            
            @Override
            public boolean hasNext() {
               return index < groups.size();
            }
            
            @Override
            public StudentGroup next() {
                if(!hasNext())
                    return null;
                return groups.get(index++);    
            }
        };
    }

    // Собираем в общий список всех студентов
    public List<Student> getAllStudents() {
        List<Student> sList = new ArrayList<>();
        
        // Перечисляем группы
        for(StudentGroup group : groups) {
            
            // Перечисляем студентов в каждой группе
            for(Student stud : group)
                sList.add(stud);
        }

        return sList;
    }
}
