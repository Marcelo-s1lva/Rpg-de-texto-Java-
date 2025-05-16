package gameSystems.inventorySystem;


//static functions represents interactions between two inventories
public class Inventory {
    private Item[] inventory;

    public Inventory(int size){
        inventory = new Item[size];

        for (int i = 0;i < size ; i++ ){
            inventory[i] = new Empty();
        }
    }

    //int parameter must receive an inventory Slot as parameter
    public void setOnSlot(int slotToSet, int slot){
        if (isOnLength(slot) && isOnLength(slotToSet) && !inventory[slotToSet].isEmpty()){
            if (inventory[slot].isEmpty()){
                setItem(slotToSet, slot);
            }
            else {
                swap(slotToSet, slot);
            }

        }
        else{
            System.out.println("Error, invalid slot");
        }
    }

    //Item parameter must receive an inventory Slot as parameter
    public static void setOnSlot(Inventory inventory1 ,int slotToSet, Inventory inventory2, int slot){
        if (inventory1.isOnLength(slotToSet) && inventory2.isOnLength(slot)){
            if (inventory2.inventory[slot].isEmpty()){
                swap(inventory1, slotToSet, inventory2, slot);
            }
            else {
                swap(inventory1, slotToSet, inventory2, slot);
            }

        }
        else{
            System.out.println("Error, invalid slot");
        }
    }

    public void setOnSlot(int slotToSet, int slot, int stackAmount){
        if (stackAmount <= inventory[slotToSet].getCurrentStack() && stackAmount > 0 && isOnLength(slot) && isOnLength(slotToSet)){
            if(inventory[slot].getiD() == inventory[slotToSet].getiD() || inventory[slot].isEmpty()){
                if (inventory[slot].isEmpty()) {
                    inventory[slot] = inventory[slotToSet].copyItem();
                    inventory[slot].setCurrentStack(stackAmount);
                    inventory[slotToSet].setCurrentStack(inventory[slotToSet].getCurrentStack() - stackAmount);
                }
                else{
                    if(inventory[slot].getCurrentStack() + stackAmount <= inventory[slot].getMaxStack()) {
                        inventory[slot].setCurrentStack(inventory[slot].getCurrentStack() + stackAmount);
                        inventory[slotToSet].setCurrentStack(inventory[slotToSet].getCurrentStack() - stackAmount);
                    }
                    else {
                        int addition = inventory[slot].getMaxStack() - inventory[slot].getCurrentStack();
                        inventory[slot].setCurrentStack((inventory[slot].getCurrentStack() + addition));
                        inventory[slotToSet].setCurrentStack(inventory[slotToSet].getCurrentStack() - addition);


                        int otherSlotAddition = stackAmount - addition;
                        boolean foundFreeSlot = false;
                        int freeSlot = 0;

                        //find free slot
                        for(int i = 0; i < inventory.length; i++){
                            if(inventory[i].isEmpty()){
                                foundFreeSlot = true;
                                freeSlot = i;
                                break;
                            }
                        }

                        if(foundFreeSlot){
                            inventory[freeSlot] = inventory[slotToSet].copyItem();
                            inventory[freeSlot].setCurrentStack(otherSlotAddition);
                            inventory[slotToSet].setCurrentStack(inventory[slotToSet].getCurrentStack() - otherSlotAddition);
                        }

                    }
                }
            }
            else {
                System.out.println("[Error]There is an other item here");
            }
        }
        else {
            System.out.println("[Error] couldn't put an stack in inventory");
        }
    }



    public static void setOnSlot(Inventory inventory1,int slotToSet,Inventory inventory2, int slot, int stackAmount){
        if (stackAmount <= inventory1.getItemBySlot(slotToSet).getCurrentStack() && stackAmount > 0 && inventory2.isOnLength(slot) && inventory1.isOnLength(slotToSet)){
            if(inventory2.getArray()[slot].getiD() == inventory1.getArray()[slotToSet].getiD() || inventory2.getArray()[slot].isEmpty()){
                if (inventory2.getArray()[slot].isEmpty()) {
                    inventory2.getArray()[slot] = inventory1.getArray()[slotToSet].copyItem();
                    inventory2.getArray()[slot].setCurrentStack(stackAmount);
                    inventory1.getArray()[slotToSet].setCurrentStack(inventory1.getArray()[slotToSet].getCurrentStack() - stackAmount);
                }
                else{
                    if(inventory2.getArray()[slot].getCurrentStack() + stackAmount <= inventory2.getArray()[slot].getMaxStack()) {
                        inventory2.getArray()[slot].setCurrentStack(inventory2.getArray()[slot].getCurrentStack() + stackAmount);
                        inventory1.getArray()[slotToSet].setCurrentStack(inventory1.getArray()[slotToSet].getCurrentStack() - stackAmount);
                    }
                    else {
                        int addition = inventory2.getArray()[slot].getMaxStack() - inventory2.getArray()[slot].getCurrentStack();
                        inventory2.getArray()[slot].setCurrentStack((inventory2.getArray()[slot].getCurrentStack() + addition));
                        inventory1.getArray()[slotToSet].setCurrentStack(inventory1.getArray()[slotToSet].getCurrentStack() - addition);


                        int otherSlotAddition = stackAmount - addition;
                        boolean foundFreeSlot = false;
                        int freeSlot = 0;

                        //find free slot
                        for(int i = 0; i < inventory2.getArray().length; i++){
                            if(inventory2.getArray()[i].isEmpty()){
                                foundFreeSlot = true;
                                freeSlot = i;
                                break;
                            }
                        }

                        if(foundFreeSlot){
                            inventory2.getArray()[freeSlot] = inventory1.getArray()[slotToSet].copyItem();
                            inventory2.getArray()[freeSlot].setCurrentStack(otherSlotAddition);
                            inventory1.getArray()[slotToSet].setCurrentStack(inventory1.getArray()[slotToSet].getCurrentStack() - otherSlotAddition);
                        }

                    }
                }
            }
            else {
                System.out.println("[Error]There is an other item here");
            }
        }
        else {
            System.out.println("[Error] couldn't put an stack in inventory");
        }
    }


    public Item getItemBySlot(int slot){
        if (isOnLength(slot) && !inventory[slot].isEmpty()){
            Item itemGot = inventory[slot].copyItem();
            return itemGot;
        }
        else{
            return new Empty();
        }
    }



    //this will add an Item in a free slot
    //Recommendation: add only new instances in Item parameter
    public void addItem(Item itemToAdd){
        boolean foundFreeSlot = false;
        for (int i = 0; i < inventory.length; i++){
            if (inventory[i].isEmpty()){
                foundFreeSlot = true;
                inventory[i] = itemToAdd.copyItem();
                break;
            }
            else if(itemToAdd.getiD() == inventory[i].getiD() && inventory[i].getCurrentStack() < inventory[i].getMaxStack()){
                inventory[i].setCurrentStack(inventory[i].getCurrentStack() + 1);
                foundFreeSlot = true;
                break;
            }
        }
        if (!foundFreeSlot){
            System.out.println("[Error] : there is no free slot");
        }
    }

    //Add Item with stack amount
    public void addItem(Item itemToAdd, int amount){
        boolean foundFreeSlot = false;
        int amountToAdd = amount;
        if(amount <= itemToAdd.getMaxStack()) {
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i].isEmpty()) {
                    foundFreeSlot = true;
                    inventory[i] = itemToAdd.copyItem();
                    inventory[i].setCurrentStack(amountToAdd);
                    amountToAdd = 0;
                    if (amountToAdd == 0) {
                        break;
                    }
                } else if (itemToAdd.getiD() == inventory[i].getiD() && inventory[i].getCurrentStack() + amountToAdd <= inventory[i].getMaxStack()) {
                    inventory[i].setCurrentStack(inventory[i].getCurrentStack() + amountToAdd);
                    amountToAdd = 0;
                    if (amountToAdd == 0) {
                        foundFreeSlot = true;
                        break;
                    }
                } else if (itemToAdd.getiD() == inventory[i].getiD() && inventory[i].getCurrentStack() + amountToAdd > inventory[i].getMaxStack()) {
                    int addHere = inventory[i].getMaxStack() - inventory[i].getCurrentStack();
                    inventory[i].setCurrentStack(inventory[i].getCurrentStack() + addHere);
                    amountToAdd = amountToAdd - addHere;
                    if (amountToAdd == 0) {
                        foundFreeSlot = true;
                        break;

                    }
                }
            }
            if (!foundFreeSlot) {
                System.out.println("[Error] : there is no free slot");
            }
        }
        else{
            System.out.println("[Error] : Stack Overflow");
        }
    }

    public Item[] getArray(){
        return inventory;
    }


    protected void setItem(int slotToSet, int slot){
        if (isOnLength(slot)) {
            inventory[slot] = inventory[slotToSet].copyItem();
            inventory[slotToSet] = new Empty();
        }
    }


    private void swap(int slot1, int slot2){
        Item swap = inventory[slot2].copyItem();
        inventory[slot2] = inventory[slot1].copyItem();
        inventory[slot1] = swap.copyItem();

    }

    private static void swap(Inventory inventory1,int slot1, Inventory inventory2, int slot2){
        Item swap = inventory2.inventory[slot2].copyItem();
        inventory2.inventory[slot2] = inventory1.inventory[slot1].copyItem();
        inventory1.inventory[slot1] = swap.copyItem();

    }

    public void removeItemBySLot(int slot){
        inventory[slot] = new Empty();
    }

    public void removeItem(Item item){
        for (int i = 0; i < inventory.length; i++){
            if (inventory[i].getiD() == item.getiD()){
                inventory[i] = new Empty();
            }
        }
    }

    public void removeItem(Item item, int amount){
        int amountToRemove = amount;
        for (int i = 0; i < inventory.length; i++){
            if (amountToRemove > 0) {
                if (inventory[i].getiD() == item.getiD() && inventory[i].getCurrentStack() >= amountToRemove) {
                    inventory[i].setCurrentStack(inventory[i].getCurrentStack() - amountToRemove);
                    amountToRemove = 0;
                } else if (inventory[i].getiD() == item.getiD() && inventory[i].getCurrentStack() < amountToRemove) {
                    amountToRemove = amountToRemove - inventory[i].getCurrentStack();
                    inventory[i] = new Empty();
                }
            }
            else{
                System.out.println("Amount is 0");
                break;
            }
        }
    }

    public boolean hasItem(Item item){
        for (int i = 0; i < inventory.length; i++){
            if (inventory[i].getiD() == item.getiD()){
                return true;
            }
        }
        return false;
    }

    public int getItemCount(Item item){
     int count = 0;

        for (int i = 0; i < inventory.length; i++){
            if (inventory[i].getiD() == item.getiD()){
               count += inventory[i].getCurrentStack();
            }
        }
        return count;
    }



    private Boolean isOnLength(int value){
        if (value >= 0 && value < inventory.length){
            return true;
        }
        else {
            return false;
        }
    }


}
