package gameplay;

import gameSystems.characterSystem.characters.Protagonist;
import gameSystems.inventorySystem.Inventory;
import gameSystems.teamSystem.Team;

//Classe que representa um jogdador
public class Player {
    public Team playerTeam = new Team(5, false); //Cria um time. O primeiro parâmetro define o tamanho do time. O segundo parâmetro define se o time é administrado por um bot
    public Team characterInventory = new Team(30); //Adiciona um inventário de personagens. Esse inventário não pode ser colocado em uma batalha. Serve apenas para armazenar os personagens disponíveis para o jogador
    public Inventory inventory = new Inventory(30); // Adiciona um inventárop ao jogador. O parâmetro define o tamanho do inventário
    private int Money = 0; // Define o dinheiro do jogador
    private String protagonistName; // Define o nome do jogador

    //Define o nome do protagonista com base no parâmetro
    public void setProtagonist(String protagonistName){
        playerTeam.setNewCharacter(new Protagonist(), 0);
        playerTeam.getTeamArray()[0].setName(protagonistName); //Muda também o nome do personagem da subClasse protagonista
        this.protagonistName = protagonistName;
    }


    //Getters e setters
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
