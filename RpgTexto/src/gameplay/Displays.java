package gameplay;

import gameSystems.characterSystem.Character;
import gameSystems.inventorySystem.Inventory;

public class Displays {


    //Exibe individualmente as caracteríticas de um personagem
    private void displayCharacter(Character character){
        System.out.println(character.getName()); //Exibe o nome do personagem
        System.out.println(character.getCurrentHealth()+"/"+ character.getMaxHealth()); //Exibe a vida do personagem
        System.out.println(character.getRemainingTurnsToUlti()); //Exibe o número de turnos faltando para usar a Ulti
    }

    //Exibe as características da equipe
    public void displayTeamInfo(Character[] team){
        System.out.println("");
        for (int i = 0; i < team.length; i++){
            if(!team[i].isNull()) {
                System.out.println("");
                displayCharacter(team[i]);
                System.out.println("Select Option: "+(i+ 1));
                //O select Option representa o valor que deve ser digitado para selecionar um personagem em uma batalha
            }
            else{
                System.out.println("");
                System.out.println("Empty Character");
                //Caso não tenha nenhhum personagem aqui
            }
        }
    }
    
    //Exibe o inventário
    public void displayInventory(Inventory inventory){
        System.out.println("");
        for(int i = 0; i < inventory.getArray().length; i++){
            System.out.print("|");
            if (!inventory.getItemBySlot(i).isEmpty()){
                System.out.print("Item: "+ inventory.getItemBySlot(i).getName() + " - Count: "+ inventory.getItemBySlot(i).getCurrentStack()+"/"+ inventory.getItemBySlot(i).getMaxStack());
                //Exibira o nome e a contagem do item
            }
            else{
                System.out.print("Empty"); //Caso o espaço esteja vazio
            }
            System.out.println("|");
            System.out.println("Slot:"+ i);
            System.out.println("");
        }
    }

}
