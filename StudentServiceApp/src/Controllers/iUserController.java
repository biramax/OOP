package Controllers;

import java.util.List;

import StudentDomen.User;

// Каркас, сделаем дженериком
public interface iUserController<T extends User> {
    
    void create(String firstName, String secondName, int age);

    List<T> getAll();
}
