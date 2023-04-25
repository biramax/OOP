package Interfaces;

import java.util.List;

import Classes.Actor;


// Интерфес магазина
public interface iMarketBehaviour {
    
    // Клиент заходит в магазин
    // Передаём клиента
    void acceptToMarket(iActorBehaviour actor);
    
    // Клиент уходит из магазина
    // Передаём коллекцию клиентов
    void releaseFromMarket(List<Actor> actors);
    
    // Обновить статус
    void update();    
}
