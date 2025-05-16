package gameSystems.teamSystem;

import gameSystems.characterSystem.Character;
import gameSystems.characterSystem.EmptyChar;

//classe que representa um time
public class Team {
    private Character[] team;
    private boolean isBot;

    public boolean isBot() {
        return isBot;
    }

    //cria um novo time
    public Team(int size, boolean isBot){
        team = new Character[size];
        for (int i = 0;i < size ; i++ ){
            team[i] = new EmptyChar();
        }

        this.isBot = isBot;
    }

    //outra forma de criar um time(aqui, a variável isBot será por padrão true)
    public Team(int size){
        team = new Character[size];
        for (int i = 0;i < size ; i++ ){
            team[i] = new EmptyChar();
        }

        this.isBot = true;
    }

    public Character[] getTeamArray(){
        return team;
    }

    public void setNewCharacter(Character character, int slot){
        team[slot] = character;
    }

    //troca as posições no time
    public void swapCharacterPosition(int character1, int character2){
        if (isOnLength(character1) && isOnLength(character2)){
            Character swap = team[character1].copyObject();
            team[character1] = team[character2].copyObject();
            team[character2] = swap.copyObject();
        }
    }

    //verifica se um valor é válido
    private boolean isOnLength(int value){
        if (value >= 0 && value < team.length){
            return true;
        }
        else {
            return false;
        }
    }

    //troca as posições de personagens em diferentes inventários
    public static void swapCharacterPosition(Character[] character1 ,int slot1 , Character[] character2, int slot2){
        if (slot1 >= 0 && slot1 < character1.length && slot2 >= 0 && slot2 < character2.length){
            Character swap = character1[slot1].copyObject();
            character1[slot1] = character2[slot2].copyObject();
            character2[slot2] = swap.copyObject();
        }
    }

}
