package Classes;

import Interfaces.iReturnOrder;

// ВИП-клиент, наследует прототип (абстрактный класс) клиентов Actor
public class SpecialClient extends Actor implements iReturnOrder{
    
    // id вип-клиента
    private int idVIP;

    // Конструктор - даём имя клиенту и его id
    public SpecialClient(String name, int idVIP) {
        // Вызываем конструктор родителя
        super(name);
        this.idVIP = idVIP;
    }

    // Геттер - получаем имя вип-клиента
    // Перезаписываем метод из Actor
    @Override
    public String getName() {
        return super.name;
    }
    
    // Геттер - получаем id вип-клиента
    public int getIdVIP() {
        return idVIP;
    }

    // Сделать заказ
    // Перезаписываем метод из интерфейса iActorBehaviour
    @Override
    public void setMakeOrder(boolean makeOrder) {
       super.isMakeOrder = makeOrder;
    }

    // Забрать заказ
    // Перезаписываем метод из интерфейса iActorBehaviour
    @Override
    public void setTakeOrder(boolean pickUpOrder) {
       super.isTakeOrder = pickUpOrder;   
    }

    // Сделал ли клиент заказ
    // Перезаписываем метод из интерфейса iActorBehaviour
    @Override
    public boolean isMakeOrder() {
        return super.isMakeOrder;
    }

    // Получил ли клиент свой заказ
    // Перезаписываем метод из интерфейса iActorBehaviour
    @Override
    public boolean isTakeOrder() {
        return super.isTakeOrder;
    }

    // В качестве клиента возвращает самого себя
    // Перезаписываем метод из интерфейса iActorBehaviour
    @Override
    public Actor getActor() {
        return this;
    }

    // Вернуть заказ
    // Перезаписываем метод из интерфейса iReturnOrder
    @Override
    public void setReturnOrder(boolean returnOrder) {
        super.isReturnOrder = returnOrder; 
    }

    // Вернул ли клиент свой заказ
    // Перезаписываем метод из интерфейса iReturnOrder
    @Override
    public Boolean isReturnOrder() {
        return super.isReturnOrder;
    }
}