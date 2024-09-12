package structural.facade.strategy;

import structural.facade.Blackberry;
import structural.facade.MobileShop;

public class BlackBerrySale implements ShopKeeperStrategy {
    private MobileShop blackberrySale=new Blackberry();

    @Override
    public void doOperation() {
        blackberrySale.modelNo();
        blackberrySale.price();
    }
}
