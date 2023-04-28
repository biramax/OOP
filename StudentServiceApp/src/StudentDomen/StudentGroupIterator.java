package StudentDomen;

import java.util.Iterator;
import java.util.List;

// Класс итератора требует переопределить два метода:
// - hasNext()
// - next()
public class StudentGroupIterator implements Iterator<Student> {
    
    private int counter;
    private final List<Student> students;
    
    // Конструктор
    public StudentGroupIterator(List<Student> students) {
        this.students = students;
        // При инициализации счётчик выставляем в 0
        this.counter = 0;
    }
    
    @Override
    public boolean hasNext() {
       return counter < students.size();
    }
    
    @Override
    public Student next() {
        if(!hasNext())
            return null;
        return students.get(counter++);        
    }
}
