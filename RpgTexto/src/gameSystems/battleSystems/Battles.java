package gameSystems.battleSystems;

import gameSystems.teamSystem.Team;
import gameSystems.teamSystem.Teams;

//Adciona instâncias de batalhas
public class Battles {
    private Teams teams = new Teams(); //Adciona os times
    public Battle main_01;


    public Battles(){
        //Exembplo de uma batalaha sendo criada
        main_01 = new Battle();
        main_01.setEnemy(teams.main_01);
    }
}
