package gameSystems.teamSystem;

import gameSystems.characterSystem.characters.*;

public class Teams {
    public Team main_01 = new Team(3);



    public Teams(){
        //team 01
        main_01.setNewCharacter(new GuardaDoRei(), 0);
        main_01.setNewCharacter(new GuardaDoRei(), 1);
        main_01.setNewCharacter(new GuardaDoRei(), 2);

    }
}
