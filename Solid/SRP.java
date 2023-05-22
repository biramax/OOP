/*
Переписать код в соответствии с Single Responsibility Principle.
Подсказка: вынесите метод calculateNetSalary() в отдельный класс.
*/

public class Employee {

    private String name;
    private Date dob;
    // private int baseSalary; // Переносим в отдельный класс, пояснения ниже (к методу calculateNetSalary)
    
    public Employee(String name, Date dob, int baseSalary) {
        this.name = name;
        this.dob = dob;
        // this.baseSalary = baseSalary; // Переносим в отдельный класс, пояснения ниже (к методу calculateNetSalary)
    }
    
    public String getEmpInfo() {
        return "name - " + name + " , dob - " + dob.toString();
    }
    
    /*
    Этот метод у нас "принадлежит" бухгалтерии, а не работнику.
    Получается, что у нас несколько зон ответственности. 
    Поэтому этот метод нужно вынести в отдельный класс.
    
    public int calculateNetSalary() {
        int tax = (int) (baseSalary * 0.25);
        return baseSalary - tax;
    }
    */
}


// Выносим метод calculateNetSalary в отдельный класс 
// Делаем связки между классами
public сlass salaryService() {
    
    private int baseSalary;
    private Employee employee;

    // Конструктор
    public salaryService(int baseSalary, Employee employee) {
        this.baseSalary = baseSalary;
        this.employee = employee;
    }

    public int calculateNetSalary() {
        int tax = (int) (baseSalary * 0.25);
        return baseSalary - tax;
    }
}
