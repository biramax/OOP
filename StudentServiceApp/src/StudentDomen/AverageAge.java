package StudentDomen;

import java.util.List;

// Дженерик по всем Юзерам (студенты, учителя, работники) для подсчёта среднего возраста
public class AverageAge<T extends User> {

    public Double calcAverageAge(List<T> users) {
        
        int sum = 0;
        for (T user : users)
            sum += user.getAge();

        return (double) (sum / users.size());
    }
}
