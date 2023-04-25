package Classes;

import Interfaces.iReturnOrder;

// Класс, описывающий акционного клиента
public class ActionClient extends Actor implements iReturnOrder {
    
    // Название акции
    private String actionName;

    // Номер клиента в акции
    static int clientNumber = 0;

    // Конструктор
    public ActionClient(String name, String actionName) {
        // Вызов конструктора родителя
        super(name);

        // Указываем название акции, под которую пришёл клиент
        this.actionName = actionName;

        // Инкрементируем номер акционного клиента
        clientNumber ++;
    }
    
    // Геттер - получаем имя клиента
    @Override
    public String getName() {        
        return super.name;
    }

    // Сеттер - устанавливаем название акции
    public void setActionName(String actionName) {
        this.actionName = actionName;
    }
    
    // Геттер - получаем название акции
    public String getActionName() {
        return actionName;
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
