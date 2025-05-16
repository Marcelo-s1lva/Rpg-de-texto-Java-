package gameplay;

import gameSystems.battleSystems.Battle;

import java.util.Scanner;

public class Util {
    public static void BattleLoop(Battle battle){
        if(battle.getWinner() == 1){
            //Continue
        }
        else{
            while (battle.getWinner() != 1) {
                Scanner insert = new Scanner(System.in);
                System.out.println("You Loose");
                System.out.println("Reset fight");
                insert.nextLine();
                Gameplay.battles.main_01.reset();
                Gameplay.battles.main_01.Initialize();
            }
        }
    }
    public static boolean wonBattle(Battle battle){
        if(battle.getWinner() == 1){
            return true;
        }
        else{
            return false;
        }

    }
}
