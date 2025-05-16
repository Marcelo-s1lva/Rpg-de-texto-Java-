package gameSystems.locationsSystem.shopSystem.shops;

import gameSystems.inventorySystem.items.*;
import gameSystems.locationsSystem.shopSystem.Shop;


public class ShopExample extends Shop {


    public ShopExample(){
        addItem(new Test(), 50);
        addItem(new Test2(), 200);
    }

    @Override
    protected void locationBlock() {
        System.out.println("Select an item");
        shopBlock();
        exit();
    }

    @Override
    protected void onExit(){
        System.out.println("Exit");
    }


}
