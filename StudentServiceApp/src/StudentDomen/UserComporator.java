package StudentDomen;

import java.util.Comparator;

// Дженерик компоратор для сравнения наших объектов (студентов, учителей, рабонтиков...).
// extends User - ограничиваем, что этот класс работает для Юзеров и всех его потомков.
public class UserComporator<T extends User> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        
        // Сравниваем по именам
        int resultOfComparing = o1.getFirstName().compareTo(o2.getFirstName());

        // Если имена совпадают, сравниваем по фамилиям
        if (resultOfComparing == 0) {
            resultOfComparing = o1.getSecondName().compareTo(o2.getSecondName());
            return resultOfComparing;
        } else
            return resultOfComparing;
    }
}
