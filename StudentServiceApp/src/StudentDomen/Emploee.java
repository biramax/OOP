package StudentDomen;

// Класс работников института, наследуется от Юзера
public class Emploee extends User {
    
    private int empId; // id работника

    // Конструктор
    public Emploee(String firstName, String secondName, int age, int empId) {
        // Вызываем конструктор Юзера
        super(firstName, secondName, age);
        // Дополняем экземпляр айдишником работника
        this.empId = empId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }    
}
