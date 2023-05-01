
// Чтобы можно было сортировать студентов, имплементируем к классу  интерфейс Comparable
public class Student<T, V, S extends Comparable<S>> extends User<T, V> implements Comparable<Student<T,V,S>> {
    
    // К полям родителя (имя, фамилия, возраст) добавляем id студента
    private S studentID;

    // Конструктор
    public Student(T firstName, T secondName, V age, S studentID) {
        // Вызываем конструктор родителя для определения значений полей
        super(firstName, secondName, age);
        // id студента
        this.studentID = studentID;
    }

    // Геттер id студента
    public S getStudentID() {
        return studentID;
    }

    // Сеттер id студента
    public void setStudentID(S studentID) {
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
    public int compareTo(Student<T, V, S> o) {
        
        return this.studentID.compareTo(o.studentID);
    }
}
