package gameSystems.battleSystems;

import gameSystems.characterSystem.Character;
import gameSystems.battleSystems.arrayCopy.Copy;
import gameSystems.teamSystem.Team;
import gameplay.Gameplay;


public class Battle {
    private Character[] player; //player team
    private Character[] enemy; //enemy team
    private int turns = 0;
    private boolean yourTurn = true;
    private boolean team1IsBot;
    private boolean team2IsBot;
    private Character[] enemyResetCopy;
    private Character[] playerResetCopy;


    public void setTeams(Team team1, Team team2){
        player = Copy.ArrayCopy(team1.getTeamArray());
        enemy = Copy.ArrayCopy(team2.getTeamArray());
        playerResetCopy = Copy.ArrayCopy(team1.getTeamArray());
        enemyResetCopy = Copy.ArrayCopy(team2.getTeamArray());

        team1IsBot = team1.isBot();
        team2IsBot = team2.isBot();
    }

    public void setEnemy(Team team){

        enemyResetCopy = Copy.ArrayCopy(team.getTeamArray());
        enemy = Copy.ArrayCopy(team.getTeamArray());
        team2IsBot = team.isBot();
    }


    private void setPlayer(Team team){
        playerResetCopy = Copy.ArrayCopy(team.getTeamArray());
        player = Copy.ArrayCopy(team.getTeamArray());
        team1IsBot = team.isBot();
    }

    public Battle (){
    }

    public void reset(){
        enemy = Copy.ArrayCopy(enemyResetCopy);
        player = Copy.ArrayCopy(playerResetCopy);
    }


    public void start(Team player){
        setPlayer(player);
        Initialize();
    }

    public void Initialize(){
        if (player != null && enemy != null) {
            while (TeamHasAliveCharacter(player) && TeamHasAliveCharacter(enemy)) {

                if (yourTurn) {
                    if(!team1IsBot) {
                        Gameplay.display.displayTeamInfo(player);
                        Gameplay.display.displayTeamInfo(enemy);
                    }

                    Manager.selectAction(player, enemy, team1IsBot);

                    Manager.chargeUlti(player);
                    yourTurn = false;

                } else {
                    if(!team2IsBot) {
                        Gameplay.display.displayTeamInfo(enemy);
                        Gameplay.display.displayTeamInfo(player);
                    }
                    Manager.selectAction(enemy, player, team2IsBot);
                    Manager.chargeUlti(enemy);
                    yourTurn = true;

                }

                turns++;

            }
        }
        else{
            System.out.println("Some team is Pointing to Null");
        }
    }

    //Verify if team has an alive character
    private boolean TeamHasAliveCharacter(Character[] team){
        for (int i = 0; i < team.length; i++){
            if (!team[i].isDead()){
                return true;
            }
        }
        return false;
    }

    public int getWinner(){
        if (TeamHasAliveCharacter(player) && !TeamHasAliveCharacter(enemy)){
            return 1;
        }
        else if (!TeamHasAliveCharacter(player) && TeamHasAliveCharacter(enemy)){
            return -1;
        }
        else{
            return 0;
        }
    }

}
