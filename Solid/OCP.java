/*
Переписать код SpeedCalculation в соответствии с Open-Closed Principle.
Подсказка: создайте два дополнительных класса Car и Bus (наследников Vehicle), напишите метод calculateAllowedSpeed(). Использование этого метода позволит сделать класс SpeedCalculation соответствующим OCP.
*/

/*
С добавлением каждого нового типа автомобиля мы будем вынуждены менять этот класс.
Поэтому решением будет выделить каждый тип атомобиля в свой отдельный класс-наследник класса Vehicle.
Непосредственный расчёт скорости производить в соответствующих классах.
*/
public class SpeedCalculation {
    
    public double calculateAllowedSpeed(Vehicle vehicle) {  
        /*
        if (vehicle.getType().equalsIgnoreCase("Car")) {
            return vehicle.getMaxSpeed() * 0.8;
        } 
        else if (vehicle.getType().equalsIgnoreCase("Bus")) {
            return vehicle.getMaxSpeed() * 0.6;
        }
        return 0.0;

        return vehicle.calculateAllowedSpeed();
        */

        return vehicle.calculateAllowedSpeed();
    }     
}

// Переводим класс в абстракцию, чтобы добавить метод calculateAllowedSpeed, который должны будут реализовывать наследники.
public abstract class Vehicle {
    
    int maxSpeed;
    String type;
    
    public Vehicle(int maxSpeed, String type) {
        this.maxSpeed = maxSpeed;
        this.type = type;
    }

    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    public String getType() {
        return this.type;
    }
    
    public abstract double calculateAllowedSpeed();
}

// Создадим отдельный класс для типа атомобилей Car
public class Car extends Vehicle {
    
    public Car(int maxSpeed) {
        super(maxSpeed, "Car");
    }

    public double calculateAllowedSpeed() {
        return super.getMaxSpeed() * 0.8;
    }
}

// Создадим отдельный класс для типа атомобилей Bus
public class Bus extends Vehicle {

    public Bus(int maxSpeed) {
        super(maxSpeed, "Bus");
    }

    public double calculateAllowedSpeed() {
        return super.getMaxSpeed() * 0.6;
    }
}
