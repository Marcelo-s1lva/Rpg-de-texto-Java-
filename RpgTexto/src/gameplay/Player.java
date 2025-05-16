package gameplay;

import gameSystems.characterSystem.characters.Protagonist;
import gameSystems.inventorySystem.Inventory;
import gameSystems.teamSystem.Team;

public class Player {
    public Team playerTeam = new Team(5, false);
    public Team characterInventory = new Team(30);
    public Inventory inventory = new Inventory(30);
    private int Money = 0;
    private String protagonistName;

    public void setProtagonist(String protagonistName){
        playerTeam.setNewCharacter(new Protagonist(), 0);
        playerTeam.getTeamArray()[0].setName(protagonistName);
        this.protagonistName = protagonistName;
    }
    public String getProtagonistName(){
        if(protagonistName != null) {
            return protagonistName;
        }
        return "Null pointer Exception";
    }

    public void setMoney(int Money){
        this.Money = Money;
    }

    public int getMoney(){
        return Money;
    }

}
