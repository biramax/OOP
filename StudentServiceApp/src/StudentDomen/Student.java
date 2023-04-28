package StudentDomen;

// Чтобы можно было сортировать студентов, имплементируем к классу  интерфейс Comparable
public class Student extends User implements Comparable<Student> {
    
    // К полям родителя (имя, фамилия, возраст) добавляем id студента
    private long studentID;

    // Конструктор
    public Student(String firstName, String secondName, int age, long studentID) {
        // Вызываем конструктор родителя для определения значений полей
        super(firstName, secondName, age);
        // id студента
        this.studentID = studentID;
    }

    // Геттер id студента
    public long getStudentID() {
        return studentID;
    }

    // Сеттер id студента
    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    // Переопределяем метод вывода информации о студенте
    @Override
    public String toString() {
        return "Student{"+
            "firstName=" +super.getFirstName()+", "+
            "secondName="+super.getSecondName()+", "+
            "age=" +super.getAge()+", "+
            "studentID="+studentID+
        "}";
    }

    // Переопределяем метод сравнения
    @Override
    public int compareTo(Student o) {
        
        // Посмотреть сравниваемые пары
        //System.out.println(super.getFirstName()+" - "+o.getFirstName());
        
        // Создаём алгоритм сравнения экземпляров класса
        
        // Сравниваем по возрасту
        if (super.getAge() == o.getAge()) {

            // Если возраст одинаковый, сортируем по ID
            if (this.studentID == o.studentID) return 0;
            if (this.studentID < o.studentID)  return -1;
            return 1;
        }
        if (super.getAge() < o.getAge()) return -1;
        return 1;
    }
}
