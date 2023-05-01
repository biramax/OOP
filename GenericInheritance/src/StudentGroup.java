
import java.util.Iterator;
import java.util.List;

// Группа студентов
// Этот класс не является ничьим потомком
// Подключая интерфейс Iterable, мы говорим, что класс итерируемый
public class StudentGroup<T,V,S extends Comparable<S>> implements Iterable<Student<T,V,S>>, Comparable<StudentGroup<T,V,S>> {

    // Список студентов (экземпляров класса Student) группы
    private List<Student<T,V,S>> students;

    // Номер группы
    private int groupId;

    // Констуктор
    public StudentGroup(List<Student<T,V,S>> students, int groupId) {
        this.students = students;
        this.groupId = groupId;
    }

    // Геттер списка студентов
    public List<Student<T,V,S>> getStudents() {
        return students;
    }

    // Сеттер списка студентов
    public void setStudents(List<Student<T,V,S>> students) {
        this.students = students;
    }

    // Геттер номера группы
    public int getGroupId() {
        return groupId;
    }

    // Сеттер номера группы
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }    

    // Переопределяем метод вывода информации о группе
    @Override
    public String toString() {
        return "Group{"+
            "groupId=" +groupId+", "+
            "studentsCount="+students.size()+
        "}";
    }
    
    // Реализуем метод iterator интерфейса Iterable (имплементировали к этому классу) для возможности перечисления списка экземпляров класса.
    // Реализация осуществляется через создание класса итератора, куда в качестве интерфейса пойдёт Iterator. Этот класс будет постоянно возвращать значение следующего элемента списка, пока они не исчерпаются.
    
    // 1. Через подключение отдельного класса StudentGroupIterator с подключением интерфейса Iterator

    // @Override
    // public Iterator<Student> iterator() {
    //     return new StudentGroupIterator(students);
    // }

    // 2. Через анонимный класс
    
    // Класс итератора требует переопределить два метода:
    // - hasNext()
    // - next()
    @Override
    public Iterator<Student<T,V,S>> iterator() {

        return new Iterator<Student<T,V,S>>() {

            private int index = 0;
            
            @Override
            public boolean hasNext() {
               return index < students.size();
            }
            
            @Override
            public Student<T,V,S> next() {
                if(!hasNext())
                    return null;
                return students.get(index++);        
            }
        };
    }

    // Переопределяем метод сравнения
    @Override
    public int compareTo(StudentGroup<T,V,S> o) {
        
        // Создаём алгоритм сравнения экземпляров класса
        
        // Сравниваем по количеству студентов в группе, а затем по номеру группы
        if (students.size() == o.getStudents().size()) {
            if (groupId == o.getGroupId()) return 0;
            if (groupId < o.getGroupId()) return -1;
            return 1;
        }
        if (students.size() < o.getStudents().size()) return -1;
        return 1;
    }
}
