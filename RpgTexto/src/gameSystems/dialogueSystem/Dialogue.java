package gameSystems.dialogueSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Dialogue {
    protected List<String> textBlocks; //Caixas de texto
    protected String endMessage; //Mensagem final

    private Scanner insert = new Scanner(System.in);

    
    public Dialogue(){
        this.textBlocks = new ArrayList<>();
    }

    //Executa o dialogo
    public void runDialogue(){
        for (int block = 0; block < textBlocks.size(); block ++){

            try{
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("-----------");
                System.out.println(textBlocks.get(block));
                System.out.println("-----------");
                System.out.println("Press Enter to continue:");
                insert.nextLine();


            } catch (Exception e) {

                System.out.println("[Error]: Empty dialogue");
            }
        }
        if (endMessage != null){
            System.out.println(endMessage);
        }
    }


}
