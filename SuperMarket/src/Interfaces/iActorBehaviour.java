package Interfaces;

import Classes.Actor;

// Интерфейс клиента
public interface iActorBehaviour {

    // Сделать заказ
    void setMakeOrder(boolean makeOrder);
    
    // Забрать заказ
    void setTakeOrder(boolean pickUpOrder);
    
    // Сделал ли клиент заказ
    boolean isMakeOrder();
    
    // Забрал ли клиент свой заказ
    boolean isTakeOrder();
    
    // Возвращает клиента, которому принадлежит интерфейс
    Actor getActor();
}
