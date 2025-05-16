package gameSystems.inventorySystem;

import gameSystems.inventorySystem.items.*;

import java.util.ArrayList;

public abstract class Item {
    private int iD;
    private int currentStack = 1;
    private int maxStackSize = 64;
    protected ArrayList<String> tags = new ArrayList<>();
    private String itemName;

    public void setName(String name){
        itemName = name;
    }

    public String getName(){
        return itemName;
    }

    public void addTag(String tagToAdd){
        tags.add(tagToAdd);
    }

    public boolean hasTag(String tag){
        if (tags.isEmpty()){
            return false;
        }
        else {
            for (int i = 0; i < tags.size(); i++){
                if(tags.get(i) == tag){
                    return true;
                }
            }
        }
        return false;
    }

    public Item copyClass(){
        Item copy;
        switch (iD){
            case 1:
                copy = new Test();
                break;
            case 2:
                copy = new Test2();
                break;
            default:
                copy = new Empty();
        }
        return copy;
    }

    public Item copyItem(){
        Item copy = copyClass();
        copy.setCurrentStack(this.getCurrentStack());
        return copy;
    }

    public int getCurrentStack(){
        return currentStack;
    }

    public int getMaxStack(){
        return maxStackSize;
    }


    public void setId(int id){
        this.iD = id;
    }

    public int getiD(){
        return iD;
    }

    public void setCurrentStack(int stack){
        this.currentStack = stack;
    }

    public boolean isEmpty(){
        if (this.currentStack == 0 || this.iD == 0){
            return true;
        }
        else {
            return false;
        }
    }


}
