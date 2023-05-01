package Model;

public class User {
    
    private String firstName;
    private String secondName;
    private int age;

    // Конструктор
    public User(String firstName, String secondName, int age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    // ГЕТТЕРЫ И СЕТТЕРЫ ------------------------------------
    // Геттер - имя
    public String getFirstName() {
        return firstName;
    }
    
    // Сеттер - имя
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Геттер - фамилия
    public String getSecondName() {
        return secondName;
    }

    // Сеттер - фамилия
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    // Геттер - возраст
    public int getAge() {
        return age;
    }

    // Сеттер - возраст
    public void setAge(int age) {
        this.age = age;
    }
    // /ГЕТТЕРЫ И СЕТТЕРЫ -----------------------------------

    // Переопределяем метод вывода информации о юзере
    @Override
    public String toString() {
        return "User{"+
            "firstName='"+firstName+'\''+", "+
            "secondName='"+secondName+'\''+", "+
            "age="+age+
        "}";
    }
}
