package Classes;

import java.util.ArrayList;
import java.util.List;

import Interfaces.iActorBehaviour;
import Interfaces.iMarketBehaviour;
import Interfaces.iQueueBehaviour;
import Interfaces.iReturnOrder;


// Класс магазина
public class Market implements iMarketBehaviour, iQueueBehaviour {
    
    // Коллекция очереди с типом интерфейса клиента
    private List<iActorBehaviour> queue;

    // Конструктор
    public Market() {
        // Инициализируем коллекцию очереди
        this.queue = new ArrayList<iActorBehaviour>();
    }

    // Добавляем клиента в очередь
    @Override
    public void takeInQueue(iActorBehaviour actor) {
        this.queue.add(actor);
        System.out.println(actor.getActor().getName()+" клиент добавлен в очередь ");
    }
    
    // Метод из интерфейса iMarketBehaviour
    // Вход клиентов в магазин
    @Override
    public void acceptToMarket(iActorBehaviour actor) {
        System.out.println(actor.getActor().getName()+" клиент пришел в магазин ");
        // Добавляем в очередь
        takeInQueue(actor);
    }

    // Метод из интерфейса iMarketBehaviour
    // Выход клиентов из магазина
    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for(Actor actor:actors) {
            System.out.println(actor.getName()+" клиент ушел из магазина ");
            // Удаляем из очереди
            queue.remove(actor);
        }   
    }

    // Обновление статуса магазина
    // Переопределяем метод из интерфейса iMarketBehaviour
    @Override
    public void update() {
        // Узнать, кто забрал
        takeOrder();
        // Узнать, кто заказал
        giveOrder();
        // Удаляем из очереди
        releaseFromQueue();
    }

    // Уйти из очереди
    // Переопределяем метод из интерфейса iQueueBehaviour
    @Override
    public void releaseFromQueue() {
        // Список удаляемых клиентов
        List<Actor> releaseActors = new ArrayList<>();
        for(iActorBehaviour actor : queue) {
            // Клиент забрал свой заказ
            if (actor.isTakeOrder() || ((iReturnOrder) actor).isReturnOrder()) {
                // Добавляем в список удаляемых клиентов
                releaseActors.add(actor.getActor());
                System.out.println(actor.getActor().getName()+" клиент ушел из очереди ");
            }
        }
        // Удаляем из магазина всех вышедших из очереди
        releaseFromMarket(releaseActors);
    }
        
    // Сделать заказ
    // Перезаписываем метод из интерфейса iQueueBehaviour
    @Override
    public void giveOrder() {
        // Перебираем клиентов
        int i = 0;
        for (iActorBehaviour actor : queue) {
            // Если клиент сделал заказ
            if (actor.isMakeOrder()) {
                
                // Получает заказ
                actor.setTakeOrder(true);
                System.out.println(actor.getActor().getName()+" клиент получил свой заказ");

                // Каждый второй делает возврат заказа, если только это не налоговый инспектор
                if (i % 2 == 0 && actor.getActor().getName() != "Tax audit") {
                    ((iReturnOrder) actor).setReturnOrder(true);
                    System.out.println(actor.getActor().getName()+" клиент вернул свой заказ");
                }
            }
            i ++;
        }
    }

    // Забрать заказ
    // Перезаписываем метод из интерфейса iQueueBehaviour
    @Override
    public void takeOrder() {
        for(iActorBehaviour actor : queue) {
            // Если клиент не сделал заказ
            if(!actor.isMakeOrder()) {
                // Делает заказ
                actor.setMakeOrder(true);
                System.out.println(actor.getActor().getName()+" клиент сделал заказ ");
            }
        }
    }
}
