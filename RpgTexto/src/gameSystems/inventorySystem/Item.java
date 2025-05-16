package gameSystems.inventorySystem;

import gameSystems.inventorySystem.items.*;

import java.util.ArrayList;


//Sistema de um item
public abstract class Item {
    private int iD; //Id do item
    private int currentStack = 1; //Stack mínimo
    private int maxStackSize = 64; //Stack máximo
    protected ArrayList<String> tags = new ArrayList<>(); //tags
    private String itemName; //nome do item

    public void setName(String name){
        itemName = name;
    }

    public String getName(){
        return itemName;
    }

    //adiciona uma tag ao item
    public void addTag(String tagToAdd){
        tags.add(tagToAdd);
    }

    //verifica se o item possui uma tag específica
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

    //copia a classe
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
    
    //copia o item
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

    //verifica se está vazio
    public boolean isEmpty(){
        if (this.currentStack == 0 || this.iD == 0){
            return true;
        }
        else {
            return false;
        }
    }


}
