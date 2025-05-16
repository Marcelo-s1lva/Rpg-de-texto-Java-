package gameSystems.dialogueSystem.dialogues;

import gameSystems.dialogueSystem.Dialogue;

public class DialogoInicial extends Dialogue {
    public DialogoInicial(){
        textBlocks.add("Seja muito bem vindo ao jogo");
        textBlocks.add("Aqui, você pode explorar o mundo, fazer missões entrar em batalhas e ganhar recompensas.");
        textBlocks.add("Alem disso, você pode ter times de personagens, e enfrentar inimigos");
        textBlocks.add("Detalhe, o jogo ainda está em estado inicial, e pode receber atualizações futuras, as quais podem até mesmo adicionar interfaces gráficas");
        textBlocks.add("Mas, apesar das limitações, eu espero que goste.");
        endMessage = "Aproveite o jogo :)";
    }
}
