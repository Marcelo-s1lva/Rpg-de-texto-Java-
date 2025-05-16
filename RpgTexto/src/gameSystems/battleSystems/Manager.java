package gameSystems.battleSystems;
import gameSystems.characterSystem.Character;

import java.util.Scanner;
import java.util.Random;



public class Manager {
    protected static void chargeUlti(Character[] team){
        for (int i = 0; i < team.length; i++){
            if (team[i] != null && !team[i].isNull()){
                team[i].ultiTimeNear();
            }
        }
    }



    protected static void selectAction(Character[] player, Character[] enemy, boolean botTurn){
        boolean next = false; //to go to next turn
        int choice;
        Scanner insert = new Scanner(System.in);
        Random rand = new Random();


        int characterChoice;
        int targetChoice = 1;

            while (!next){

                if (!botTurn){
                    System.out.println("Select some action");
                    System.out.println("(1) Use character Action");
                    System.out.println("(2) Use potion");
                    choice = insert.nextInt();
                }
               else {
                   choice = rand.nextInt(1, 2);
                }

                if (choice ==1){
                    if(!botTurn) {
                        System.out.println("Select an character");
                        System.out.println("(0) To cancel");
                        characterChoice = insert.nextInt();
                    }
                    else{
                        characterChoice = rand.nextInt(1, player.length + 1);
                    }
                        if (characterChoice >= 1 && characterChoice <= player.length && player[characterChoice - 1] != null && !player[characterChoice - 1].isNull() && !player[characterChoice -1].isDead()){
                            boolean validTarget = false;
                            while(!validTarget){
                                if(!botTurn) {
                                    System.out.println("Select an target");
                                    System.out.println("(0 to cancel)");
                                    targetChoice = insert.nextInt();
                                }
                                else {
                                    targetChoice = rand.nextInt(1, enemy.length + 1);
                                }
                                if (targetChoice == 0){
                                    break;
                                }
                                if (targetChoice >= 1 && targetChoice <= enemy.length && enemy[targetChoice - 1] != null && !enemy[targetChoice - 1].isNull() && !enemy[targetChoice - 1].isDead()){
                                    attack(characterChoice - 1, targetChoice - 1, player, enemy);
                                    validTarget = true;
                                    next = true;

                                }
                                else {
                                    if(!botTurn){
                                        System.out.println("invalid target, select other target");
                                    }

                                }

                            }


                        }
                        else {
                            if (!botTurn) {
                                System.out.println("Action Canceled");

                            }
                        }

                }
                else if (choice == 2) {
                    System.out.println("Potions are coming soon, select an character action");


                }
                else{
                    System.out.println("[Error] : invalid Option. Select another option");
                }

            }

    }

    private static void attack(int character, int target, Character[] team, Character[] targetTeam){
        if (team[character].canUseUlti()){
            team[character].ultiAttack(targetTeam[target]);

            System.out.println(team[character].getName()+ " used ulti "+ team[character].getUltiName() + " in "+ targetTeam[target].getName() +" with "+team[character].getUltiStrength()+ " damage");
        }
        else{
            team[character].attack(targetTeam[target]);

            System.out.println(team[character].getName()+ " attacked "+ targetTeam[target].getName() +" with "+team[character].getAttackStrength()+ " damage");
        }

    }

}
