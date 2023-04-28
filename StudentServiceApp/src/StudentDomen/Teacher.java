package StudentDomen;

// Класс учителей, настледуется от Юзера
public class Teacher extends User {
    
    private int teacherId; // id учителя
    private String academicDegree; // Учёная степень учителя

    // Конструктор
    public Teacher(String firstName, String secondName, int age, int teacherId) {
        // Вызываем конструктор родителя (Юзера)
        super(firstName, secondName, age);
        // Дополняем айди
        this.teacherId = teacherId;
        // Учёную степень пока оставляем пустой, дополним вручную при создании экземпляра
        this.academicDegree = "";
    }

    // Геттер айди учителя
    public int getTeacherId() {
        return teacherId;
    }

    // Сеттер айди учителя
    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    // Геттер учёной степени учителя
    public String getAcademicDegree() {
        return academicDegree;
    }

    // Сеттер учёной степени учителя
    public void setAcademicDegree(String academicDegree) {
        this.academicDegree = academicDegree;
    }

    // Переопределяем метод вывода информации об учителе
    @Override
    public String toString() {
        return "Teacher{"+
            "firstName=" +super.getFirstName()+", "+
            "secondName="+super.getSecondName()+", "+
            "age=" +super.getAge()+", "+
            "teacherId="+teacherId+
        "}";
    }
}
