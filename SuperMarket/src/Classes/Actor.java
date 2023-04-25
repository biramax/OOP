package Classes;

import Interfaces.iActorBehaviour;
import Interfaces.iReturnOrder;

/*
Проротип клиента:
- Ordinary - обычный клиент
- Special client - вип клиент
- Action client - акционный клиент, приходит на акцию в магазине
*/
public abstract class Actor implements iActorBehaviour {
    
    protected String name;          // Имя клиента

    protected boolean isMakeOrder;  // Клиент сделал заказ
    protected boolean isTakeOrder;  // Клиент получил заказ

    protected boolean isReturnOrder;  // Клиент вернул заказ
    
    // Конструктор:
    // передаём name - имя клиента
    public Actor(String name) {
        this.name = name;
    }

    // Прототип геттера - получение имени клиента
    public abstract String getName(); 
}
