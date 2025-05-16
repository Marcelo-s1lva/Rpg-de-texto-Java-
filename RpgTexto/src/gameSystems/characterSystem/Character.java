package gameSystems.characterSystem;

import gameSystems.characterSystem.characteristics.*;


public abstract class Character {



    private Health hp = new Health();
    private Attack atk = new Attack();
    private Copy cp = new Copy();


    private String name;

    public boolean isNull(){
        if(this.getId() == 0){
            return true;
        }
        else {
            return false;
        }
    }

    public int getId(){
        return cp.getClassId();
    }

    //this function will be called at the end of the team's turn
    public void ultiTimeNear(){
       atk.ultiTimeNear();
    }

    public boolean canUseUlti(){
        return atk.canUseUlti();
    }

    public boolean isDead(){
        if (getCurrentHealth() <= 0){
            return true;
        }
        else {
            return false;
        }
    }

    public void takeDamage(double damage){
        hp.takeDamage(damage);
    }

    public void heal(double healValue){
        hp.heal(healValue);
    }




    //Attack functions
    public void attack(Character target){
        atk.attack(target);
    }

    public void ultiAttack(Character target){
        atk.ultiAttack(target);
    }


    //Getters
    public double getCurrentHealth() {
        return hp.getCurrentHealth();
    }

    public double getMaxHealth() {
        return hp.getMaxHealth();
    }

    public double getDefaultMaxHealth(){
        return hp.getDefaultMaxHealth();
    }

    public int getHealthLevel(){
        return hp.getHealthLevel();
    }

    public String getName() {
        return name;
    }

    public String getUltiName(){
        return atk.getUltiName();
    }

    public int getRemainingTurnsToUlti (){
        return atk.getRemaingTurnsToUlti();
    }

    public int getUltiDelay() {
        return atk.getUltiDelay();
    }

    public double getAbsorption() {
        return hp.getAbsorption();
    }

    public double getAttackStrength() {
        return atk.getAttackStrength();
    }

    public double getUltiStrength() {
        return atk.getUltiStrength();
    }

    public double getUltiPercentage(){
        return atk.getUltiPercentage();
    }
    //Setters
    public void setDefaultMaxHealth(double maxHealth){
        hp.setDefaultMaxHealth(maxHealth);
        hp.setMaxHealth();
        hp.setCurrentHealth(maxHealth);
    }

    public void setCurrentHealth(double currentHealth) {
        hp.setCurrentHealth(currentHealth);
    }

    public void setHealthLevel(int healthLevel){
        hp.setHealthLevel(healthLevel);
    }

    public void setAbsorption(double absorption){
        hp.setAbsorption(absorption);
    }

    public void setDefaultStrength(double defaultStrength){
        atk.setDefaultStrength(defaultStrength);
    }

    public void setUltiStrength(double defaultUltiStrength){
       atk.setUltiStrength(defaultUltiStrength);
    }

    public void setUltiDelay(int delay){
        atk.setUltiDelay(delay);
    }

    public void setUltiName(String ultiName) {
        atk.setUltiName(ultiName);
    }

    public void setName(String name){
        this.name = name;
    }


    public void setClassId(int id){
        cp.setClassId(id);
    }

    public Character copyClass(){
        return cp.copyClass();
    }


    public Character copyObject(){
        return cp.copyObject(this);
    }



}
