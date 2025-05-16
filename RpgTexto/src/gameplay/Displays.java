package gameplay;

import gameSystems.characterSystem.Character;
import gameSystems.inventorySystem.Inventory;

public class Displays {

    private void displayCharacter(Character character){
        System.out.println(character.getName());
        System.out.println(character.getCurrentHealth()+"/"+ character.getMaxHealth());
        System.out.println(character.getRemainingTurnsToUlti());
    }

    public void displayTeamInfo(Character[] team){
        System.out.println("");
        for (int i = 0; i < team.length; i++){
            if(!team[i].isNull()) {
                System.out.println("");
                displayCharacter(team[i]);
                System.out.println("Select Option: "+(i+ 1));
            }
            else{
                System.out.println("");
                System.out.println("Empty Character");
            }
        }
    }
    public void displayInventory(Inventory inventory){
        System.out.println("");
        for(int i = 0; i < inventory.getArray().length; i++){
            System.out.print("|");
            if (!inventory.getItemBySlot(i).isEmpty()){
                System.out.print("Item: "+ inventory.getItemBySlot(i).getName() + " - Count: "+ inventory.getItemBySlot(i).getCurrentStack()+"/"+ inventory.getItemBySlot(i).getMaxStack());

            }
            else{
                System.out.print("Empty");
            }

            System.out.println("|");
            System.out.println("Slot:"+ i);
            System.out.println("");
        }
    }

}
