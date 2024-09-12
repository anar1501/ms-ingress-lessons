package structural.facade;

import structural.facade.strategy.ShopKeeperStrategy;

public class ShopKeeper {
    private MobileShop iphone;
    private MobileShop samsung;
    private MobileShop blackberry;

    public ShopKeeper() {
        iphone = new Iphone();
        samsung = new Samsung();
        blackberry = new Blackberry();
    }

    public static void doOperation(ShopKeeperStrategy shopKeeperStrategy) {
        shopKeeperStrategy.doOperation();
    }
}
