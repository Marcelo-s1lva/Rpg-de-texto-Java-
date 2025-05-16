package gameSystems.dialogueSystem.dialogues;

import gameSystems.dialogueSystem.Dialogue;

//Exemplo de dialogo
public class Example extends Dialogue {
    public Example(){
        //adiciona caixas de texto
        textBlocks.add("this is an example of a dialogue in my RPG game");
        textBlocks.add("in this dialogue system, you can easily create and run a dialogue");
        //Mensagem final
        endMessage = "Enjoy it :)";
    }
}
