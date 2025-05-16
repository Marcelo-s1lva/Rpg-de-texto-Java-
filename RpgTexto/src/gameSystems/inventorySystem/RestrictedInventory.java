package gameSystems.inventorySystem;

import java.util.Arrays;
import java.util.List;

//Adciona um itém caso ele siga a regra de um inventário
public class RestrictedInventory {
    private Inventory inventory;
    private List<String> allowedTags;

    public RestrictedInventory(int size){
        inventory = new Inventory(size);
    }


    public void setAllowedTags(String... tags) {
        this.allowedTags = Arrays.asList(tags);
    }

    public void SwapItemsInInventory(int slotToSet, int slot){
        inventory.setOnSlot(slotToSet, slot);
    }

    public void addItem(Item item, int slot){
        if (hasOneOfAllowedTags(item)) {
            inventory.getArray()[slot] = item.copyItem();
        }
    }

    public void setItemFrom(Inventory inventory,int slotToSet,int thisInventorySlot ){
        if(hasOneOfAllowedTags(inventory.getArray()[slotToSet])){
            Inventory.setOnSlot(inventory, slotToSet, this.inventory,thisInventorySlot);
        }


    }

    public void setItemFrom(Inventory inventory,int slotToSet,int thisInventorySlot, int amount ){
        if(hasOneOfAllowedTags(inventory.getArray()[slotToSet])){
            Inventory.setOnSlot(inventory, slotToSet, this.inventory,thisInventorySlot,amount);
        }


    }


    private boolean hasOneOfAllowedTags(Item item){
        for (int i = 0; i < allowedTags.size(); i++){
            if(item.hasTag(allowedTags.get(i))){
                return true;
            }
        }
        return false;
    }

    public Item[] getArray(){
        return inventory.getArray();
    }

    public Item getItemBySlot(int slot){
        return inventory.getItemBySlot(slot);
    }


}
