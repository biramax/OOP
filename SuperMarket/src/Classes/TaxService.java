package Classes;

import Interfaces.iActorBehaviour;

// Класс 
public class TaxService implements iActorBehaviour {
    private String name;
    private boolean isTakeOrder;
    private boolean isMakeOrder;

    // Конструктор
    // Даём специальное имя посетителю магазина
    public TaxService() {
        this.name = "Tax audit";
    }

    // Геттер - получаем имя вип-клиента
    // Перезаписываем метод из Actor
    public String getName() {        
        return name;
    }

    // Сделать заказ
    // Перезаписываем метод из интерфейса iActorBehaviour
    @Override
    public void setMakeOrder(boolean makeOrder) {
        isMakeOrder = makeOrder;
    }

    // Забрать заказ
    // Перезаписываем метод из интерфейса iActorBehaviour
    @Override
    public void setTakeOrder(boolean pickUpOrder) {
        isTakeOrder = pickUpOrder;   
    }

    // Сделал ли клиент заказ
    // Перезаписываем метод из интерфейса iActorBehaviour
    @Override
    public boolean isMakeOrder() {
        return isMakeOrder;
    }    

    // Получил ли клиент свой заказ
    // Перезаписываем метод из интерфейса iActorBehaviour
    @Override
    public boolean isTakeOrder() {
        return isTakeOrder;
    }

    // В качестве клиента возвращает самого себя
    // Перезаписываем метод из интерфейса iActorBehaviour
    @Override
    public Actor getActor() {
        return new OrdinaryClient(name);
    }
}
