import Classes.ActionClient;
import Classes.Market;
import Classes.OrdinaryClient;
import Classes.SpecialClient;
import Classes.TaxService;
import Interfaces.iActorBehaviour;

public class App {
    public static void main(String[] args) throws Exception {
        
        Market market = new Market();
        iActorBehaviour item1 = new OrdinaryClient("Boris");
        iActorBehaviour item2 = new SpecialClient("Fedor", 1101);
        iActorBehaviour item3 = new OrdinaryClient("Dasha");
        iActorBehaviour item4 = new SpecialClient("Dima", 1102);
        iActorBehaviour item5 = new TaxService();
        iActorBehaviour item6 = new ActionClient("Denis", "Третий товар бесплатно!");
        iActorBehaviour item7 = new ActionClient("Prohor", "Третий товар бесплатно!");
 
        market.acceptToMarket(item1);
        market.acceptToMarket(item2);
        market.acceptToMarket(item3);
        market.acceptToMarket(item4);
        market.acceptToMarket(item5);
        market.acceptToMarket(item6);
        market.acceptToMarket(item7);
        market.update();
    }
}
