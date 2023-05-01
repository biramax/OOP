package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import Controller.iModel;

// То же, что и Model - та же функция, но Модель работает с памятью, а FileRepo - с файлами
public class FileRepo implements iModel {
    
    private String fileName; // Название файла, где хранятся данные
    private List<Student> students; // Объявляем список, куда будем помещать студентов
    
    // Конструктор
    public FileRepo(String fileName) {
        
        this.fileName = fileName;

        // При инициализации создаём пустой список студентов
        this.students = new ArrayList<>();

        // Проверяем доступность файла
        try(FileWriter fw = new FileWriter(fileName, true)) {
            fw.flush();
        } 
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Метод добавления студентов в List
    public void addStudent(Student student) {
        this.students.add(student);
    }
    
    // Чтение данных студентов из файла
    public void readAllStudentsFromFile() {
        try {
            File file = new File(fileName);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            
            // Перечисляем все строки в цикле
            String line;
            while ((line = reader.readLine()) != null) {
                String[] param = line.split(" ");
                Student person = new Student(
                    param[0], // Имя
                    param[1], // Фамилия
                    Integer.parseInt(param[2]), // Возраст
                    Long.parseLong(param[3]) // id
                );
                addStudent(person);
            }

            reader.close();
        } 
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Сохранение данных студентов в файл
    public void saveAllStudentsToFile() {

        try (FileWriter fw = new FileWriter(fileName, true)) {

            for (Student person : students) {
                fw.write(
                    person.getFirstName()+" "+
                    person.getSecondName()+" "+
                    person.getAge()+" "+
                    person.getStudentID()
                ); 
                fw.append('\n'); // Перевод строки
            }
            fw.flush();
        } 
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Переопределяем метод из интерфейса iModel
    @Override
    public List<Student> getAllStudents() {
        readAllStudentsFromFile();
        // После выполнения предыдущей строки переменная students будет со списком студентов
        return students;
    }

    // Удаляем студента, зная его ID
    // Переопределяем метод из интерфейса iModel
    @Override
    public boolean deleteStudent(long studentID) {        
        
        for (int i = 0; i < students.size(); i ++) {

            if (students.get(i).getStudentID() == studentID) {

                students.remove(i);
       
                // Очищаем файл со студентами и сохраняем обновлённый список
                try (FileWriter fw = new FileWriter(fileName, false)) {
                    fw.flush();
                } catch(Exception e) {
                    System.out.println(e.getMessage());
                }
                saveAllStudentsToFile();

                return true;
            }
        }

        return false;
    }
}
