package VendingMachine;

import VendingMachine.VendingMachines.VendingMachine;
import VendingMachine.Products.Product;
import VendingMachine.Products.BottleOfWater;
import VendingMachine.Products.HotDrink;

public class App {
    
    public static void main(String[] args) {
        
        VendingMachine itemMachine = new VendingMachine(300);

        // Добавляем продукты - название, цена
        Product item1 = new Product("Pasta", 88.0);
        item1.setPrice(98.0);
        itemMachine.addProduct(item1);
        itemMachine.addProduct(new Product("Oil", 60.0));
        itemMachine.addProduct(new Product("Bread", 50.0));
        itemMachine.addProduct(new Product("Snack", 40.0));

        // Добавляем продукты в бутылках
        itemMachine.addProduct(new BottleOfWater("Cola", 88.0, 500));
        itemMachine.addProduct(new BottleOfWater("Water", 188.0, 1500));

        // Добавляем горячие напитки
        itemMachine.addProduct(new HotDrink("Tea", 40.0, 250, 80));
        itemMachine.addProduct(new HotDrink("Coffee", 80.0, 350, 90));

        for(Product prod : itemMachine.getProdAll()) {
            System.out.println(prod.toString());
        }
    }
}
