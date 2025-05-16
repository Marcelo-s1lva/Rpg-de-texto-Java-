package gameSystems.characterSystem.characteristics;


import gameSystems.characterSystem.Character;

public class Attack {

    private double defaultStrength;
    private int strengthLevel = 1;


    // Ulti strength variable is a percentage addition to strength
    private double ultiStrength;
    private double attackStrength;



    //after use ulti
    //remainingTurrnsToUlti = ultiDelay
    private int remainingTurnsToUlti;
    private int ultiDelay;
    private String ultiName;

    //Attack functions
    public void attack(Character target){

        if (!target.isDead()) {
            target.takeDamage(getAttackStrength());
        }
        else{
            System.out.println("Target is dead");
        }
    }

    public void ultiAttack(Character target){
        if (canUseUlti()){
            target.takeDamage(getUltiStrength());
            remainingTurnsToUlti = ultiDelay;
        }
    }



    //this function will be called at the end of the team's turn
    public void ultiTimeNear(){
        if (remainingTurnsToUlti > 0){
            remainingTurnsToUlti -= 1;
        }
        else {

        }
    }


    public boolean canUseUlti(){
        if (remainingTurnsToUlti == 0){
            return true;
        }
        else {
            return false;
        }
    }



    //getters

    public double getAttackStrength() {
        return defaultStrength * strengthLevel;
    }

    public double getUltiStrength() {
        return ultiStrength * getAttackStrength();
    }

    public double getUltiPercentage(){
        return ultiStrength;
    }


    public String getUltiName(){
        return ultiName;
    }

    public int getUltiDelay() {
        return ultiDelay;
    }

    public int getRemaingTurnsToUlti(){
        return remainingTurnsToUlti;
    }


    //setters

    public void setDefaultStrength(double defaultStrength){
        this.defaultStrength = defaultStrength;
    }

    public void setUltiStrength(double defaultUltiStrength){
        this.ultiStrength = defaultUltiStrength;
    }

    public void setUltiDelay(int delay){
        this.ultiDelay = delay;
        this.remainingTurnsToUlti = 0;
    }

    public void setUltiName(String ultiName) {
        this.ultiName = ultiName;
    }

}
