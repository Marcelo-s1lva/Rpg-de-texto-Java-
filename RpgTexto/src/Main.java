import gameplay.*;
import java.util.Scanner;


//Exemplo de Gameplay
public class Main {
    
    public static void main(String[] args) {
        //Adiciona persongagem principal
        Player player = Gameplay.mainPlayer;
        Scanner insert = new Scanner(System.in);

        //Coloca os dialogos iniciais
        Gameplay.dialogues.dialogoInicial.runDialogue();
        System.out.println("");
        //Solicitção de inserção de nome
        System.out.println("Insira seu nome:");
        player.setProtagonist(insert.nextLine());
        player.setMoney(0);  //Coloca uma quantia inicial para o jogador
        
        System.out.println("Bem vindo: "+ player.getProtagonistName());
        System.out.println("");
        System.out.println("Aperte qualquer tecla para iniciar");
        insert.nextLine();
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("------Introdução------");
        Gameplay.dialogues.introduction.runDialogue();//Carregar Dialogo de introdução

        Gameplay.battles.main_01.start(player.playerTeam);
        Util.BattleLoop(Gameplay.battles.main_01); //Verifica se o jagador perdeu a batalha, e colocá a batalha em loop até que o jogador vença
        System.out.println("You Win");  //Caso o jogador vença a batalha


        //Em breve: Jogo completo, com mais personagens, localizações, missões. etc
    }
}

