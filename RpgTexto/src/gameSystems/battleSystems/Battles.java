package gameSystems.battleSystems;

import gameSystems.teamSystem.Team;
import gameSystems.teamSystem.Teams;

public class Battles {
    public Battle main_01;
    private Teams teams = new Teams();

    public Battles(){
        main_01 = new Battle();
        main_01.setEnemy(teams.main_01);
    }
}
