package structural.facade.strategy;

import structural.facade.MobileShop;
import structural.facade.Samsung;

public class SamsungSale implements ShopKeeperStrategy {
    private MobileShop samsung=new Samsung();

    @Override
    public void doOperation() {
        samsung.modelNo();
        samsung.price();
    }
}
