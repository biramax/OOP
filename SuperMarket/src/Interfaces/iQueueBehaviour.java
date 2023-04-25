package Interfaces;

// Интерфейс очереди
public interface iQueueBehaviour {

    // Попасть в очередь
    // Передаём клиента
    void takeInQueue(iActorBehaviour actor);
    
    // Уйти из очереди
    void releaseFromQueue();
    
    // Сделать заказ
    void giveOrder();
    
    // Забрать заказ
    void takeOrder();
}
