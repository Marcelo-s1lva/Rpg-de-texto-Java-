package gameSystems.inventorySystem;

//Define um item vazio
public class Empty extends Item{
    public Empty(){
        setId(0);
        setCurrentStack(0);
    }
}
