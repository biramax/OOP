package Interfaces;

// Интерфейс возврата товара
public interface iReturnOrder {
    
    // Вернуть товар
    void setReturnOrder(boolean returnOrder);

    // Вернул ли клиент товар
    Boolean isReturnOrder();
}
