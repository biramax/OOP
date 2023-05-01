
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        
        Student<String,Integer,Long> s1 = new Student<String,Integer,Long>("Сергей", "Иванов", 23, (long)101);
        Student<String,Integer,Long> s2 = new Student<String,Integer,Long>("Сергей", "Иванов", 23, (long)101);
        Student<String,Integer,Long> s3 = new Student<String,Integer,Long>("Сергей", "Иванов", 23, (long)101);

        List<Student<String,Integer,Long>> listStud = new ArrayList<>();
        listStud.add(s1);
        listStud.add(s2);
        listStud.add(s3);

        StudentGroup<String,Integer,Long> group = new StudentGroup<String,Integer,Long>(listStud, 0);

        for (Student<String,Integer,Long> stud : group)
            System.out.println(stud);
        
        Collections.sort(group.getStudents());
    }
}
