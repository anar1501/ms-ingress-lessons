package structural.facade.strategy;

import structural.facade.Iphone;
import structural.facade.MobileShop;

public class IphoneSale implements ShopKeeperStrategy {
    private MobileShop iphone =new Iphone();

    @Override
    public void doOperation() {
        iphone.modelNo();
        iphone.price();
    }
}
