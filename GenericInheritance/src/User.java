
public class User<T, V> {
    
    private T firstName;
    private T secondName;
    private V age;

    // Конструктор
    public User(T firstName, T secondName, V age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    // ГЕТТЕРЫ И СЕТТЕРЫ ------------------------------------
    // Геттер - имя
    public T getFirstName() {
        return firstName;
    }
    
    // Сеттер - имя
    public void setFirstName(T firstName) {
        this.firstName = firstName;
    }

    // Геттер - фамилия
    public T getSecondName() {
        return secondName;
    }

    // Сеттер - фамилия
    public void setSecondName(T secondName) {
        this.secondName = secondName;
    }

    // Геттер - возраст
    public V getAge() {
        return age;
    }

    // Сеттер - возраст
    public void setAge(V age) {
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
