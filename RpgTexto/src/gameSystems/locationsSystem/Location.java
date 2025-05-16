package gameSystems.locationsSystem;

//representa uma localização
public abstract class Location {
    private boolean inLocation = false;

    //carrega localização
    public void loadLocation(){
        structure();
    }
    //estrutura while do código
    private void structure(){
        inLocation = true;
        while(inLocation == true){
            locationBlock();
        }
        onExit();
    }

    //bloco de código da estrutura
    protected void locationBlock(){
        System.out.println("In location");
        int test = 0;
        if(test == 0){
            exit();
        }
    }

    //bloco de código chamado ao sair da estrutura
    protected void onExit(){
        System.out.println("Set Exit output");
    }

    //sair
    protected void exit(){
        inLocation = false;
    }


}
