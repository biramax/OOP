/*
Переписать код в соответствии с Dependency Inversion Principle.
Разорвать зависимость классов Car и PetrolEngine. У машины же может быть DieselEngine.
*/

/*
Вместо того, чтобы в класс Car передавать конкретный объект PetrolEngine, лучше создать абстракцию Engine (через интерфейс), имплементировать его в классе PetrolEngine и передавать в Car именно Engine. Тогда мы сможем "подсовывать" в Car любой другой двигатель, не только бензиновый, не изменяя класс Car.
*/

public interface Engine {
    void start();
}

public class Car {
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }
    
    public void start() {
        this.engine.start();
    }
}

public class PetrolEngine implements Engine {
    public void start() {
        // Логика запуска двигателя на бензине
    }
}

public class DieselEngine implements Engine {
    public void start() {
        // Логика запуска двигателя на дизеле
    }
}
