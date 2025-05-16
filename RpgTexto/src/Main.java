import gameplay.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Player player = Gameplay.mainPlayer;
        Scanner insert = new Scanner(System.in);


        Gameplay.dialogues.dialogoInicial.runDialogue();
        System.out.println("");
        System.out.println("Insira seu nome:");
        player.setProtagonist(insert.nextLine());
        player.setMoney(0);
        System.out.println("Bem vindo: "+ player.getProtagonistName());
        System.out.println("");
        System.out.println("Aperte qualquer tecla para iniciar");
        insert.nextLine();
        System.out.println("");
        System.out.println(Gameplay.mainPlayer.getProtagonistName());
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("------Introdução------");
        Gameplay.dialogues.introduction.runDialogue();

        Gameplay.battles.main_01.start(player.playerTeam);
        Util.BattleLoop(Gameplay.battles.main_01);
        System.out.println("You Win");
    }
}

