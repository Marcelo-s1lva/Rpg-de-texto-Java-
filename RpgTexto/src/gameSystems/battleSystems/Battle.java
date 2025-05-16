package gameSystems.battleSystems;

import gameSystems.characterSystem.Character;
import gameSystems.battleSystems.arrayCopy.Copy;
import gameSystems.teamSystem.Team;
import gameplay.Gameplay;

//Classe que permite criar uma nova batalha
public class Battle {
    private Character[] player; //time do jogador
    private Character[] enemy; //time do inimigo
    private int turns = 0;
    private boolean yourTurn = true; //Define de quem é o turno
    private boolean team1IsBot; //verifica se os times são administrados por bots
    private boolean team2IsBot;
    private Character[] enemyResetCopy; //Copia dos time para resetar a partida
    private Character[] playerResetCopy;


    //Define os dois times
    public void setTeams(Team team1, Team team2){
        player = Copy.ArrayCopy(team1.getTeamArray());
        enemy = Copy.ArrayCopy(team2.getTeamArray());
        playerResetCopy = Copy.ArrayCopy(team1.getTeamArray());
        enemyResetCopy = Copy.ArrayCopy(team2.getTeamArray());

        team1IsBot = team1.isBot();
        team2IsBot = team2.isBot();
    }

    //Define apenas o inimigo
    public void setEnemy(Team team){

        enemyResetCopy = Copy.ArrayCopy(team.getTeamArray());
        enemy = Copy.ArrayCopy(team.getTeamArray());
        team2IsBot = team.isBot();
    }


    //Define apenas o jogador
    private void setPlayer(Team team){
        playerResetCopy = Copy.ArrayCopy(team.getTeamArray());
        player = Copy.ArrayCopy(team.getTeamArray());
        team1IsBot = team.isBot();
    }

    public Battle (){
    }

    //Reinicia a batalha
    public void reset(){
        enemy = Copy.ArrayCopy(enemyResetCopy);
        player = Copy.ArrayCopy(playerResetCopy);
    }

    //Outra forma de inicializar uma batalha
    public void start(Team player){
        setPlayer(player);
        Initialize();
    }

    //Inicializa a batalha
    public void Initialize(){
        //Verifica se os times não estão vazios
        if (player != null && enemy != null) {
            while (TeamHasAliveCharacter(player) && TeamHasAliveCharacter(enemy)) {
                //Turno do jogador
                if (yourTurn) {

                    //Só irá exibir as informações do time, caso não seja administrado por bot
                    if(!team1IsBot) {
                        Gameplay.display.displayTeamInfo(player);
                        Gameplay.display.displayTeamInfo(enemy);
                    }

                    //Fazer uma ação
                    Manager.selectAction(player, enemy, team1IsBot);

                    Manager.chargeUlti(player);
                    yourTurn = false;

                } else {
                    //Turno do inimigo
                    
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

    //Verifica se o time tem personagens vivos
    private boolean TeamHasAliveCharacter(Character[] team){
        for (int i = 0; i < team.length; i++){
            if (!team[i].isDead()){
                return true;
            }
        }
        return false;
    }

    //Retorna o vencedor
    public int getWinner(){
        if (TeamHasAliveCharacter(player) && !TeamHasAliveCharacter(enemy)){
            return 1; //Jogador 1
        }
        else if (!TeamHasAliveCharacter(player) && TeamHasAliveCharacter(enemy)){
            return -1; //Jogador 2
        }
        else{
            return 0; //Empate
        }
    }

}
