package Classes;

import Interfaces.iReturnOrder;

// Обычный клиент
// Наследует прототип клиентов - Actor
public class OrdinaryClient extends Actor implements iReturnOrder {

    // Конструктор
    public OrdinaryClient(String name) {
        // Вызов конструктора родителя
        super(name);
    }

    // Геттер - получаем имя клиента
    @Override
    public String getName() {        
        return super.name;
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
