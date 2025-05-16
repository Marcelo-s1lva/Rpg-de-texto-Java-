package gameSystems.locationsSystem;


public abstract class Location {
    private boolean inLocation = false;


    public void loadLocation(){
        structure();
    }

    private void structure(){
        inLocation = true;
        while(inLocation == true){
            locationBlock();
        }
        onExit();
    }

    protected void locationBlock(){
        System.out.println("In location");
        int test = 0;
        if(test == 0){
            exit();
        }
    }

    protected void onExit(){
        System.out.println("Set Exit output");
    }

    protected void exit(){
        inLocation = false;
    }


}
