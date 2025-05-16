package gameSystems.characterSystem.characteristics;

import gameSystems.characterSystem.Character;

public class Health {
    //Health variables
    private double defaultMaxHealth;
    private double maxHealth;
    private double currentHealth;
    private int healthLevel = 1;

    //default absorption = 1
    //the damage will be multiplied by the target absorption because this value is in percentage value
    //in other words, if the absorption == 0.1, Target will take 10% of the total damage
    private double absorption = 1;


    public void heal(double healValue){
        if (currentHealth > 0) {
            this.currentHealth += healValue;
            if (this.currentHealth > maxHealth) {
                resetHealth();
            }
        }
        else {
            System.out.println("Is dead");
        }
    }

    public void revive(){
        if (currentHealth == 0){
            resetHealth();
        }
        else {
            System.out.println("Alredy Alive");
        }
    }

    private void resetHealth(){
        this.currentHealth = this.maxHealth;
    }

    public void takeDamage(double damage){
        double damageTaken = damage * absorption;
        this.currentHealth -= damageTaken;
        if (getCurrentHealth() <= 0){
            setCurrentHealth(0); // To don't display negative health
        }
    }


    //Getters
    public double getCurrentHealth() {
        return currentHealth;
    }

    public double getMaxHealth() {
        maxHealth = defaultMaxHealth * healthLevel;
        return maxHealth ;
    }

    public double getAbsorption() {
        return absorption;
    }

    public double getDefaultMaxHealth(){
        return defaultMaxHealth;
    }

    public int getHealthLevel(){
        return healthLevel;
    }

    //Setters
    public void setMaxHealth(){
        maxHealth = getMaxHealth();
    }

    public void setDefaultMaxHealth(double maxHealth) {
        this.defaultMaxHealth = maxHealth;
    }

    public void setCurrentHealth(double currentHealth) {
        this.currentHealth = currentHealth;
    }

    public void setHealthLevel(int healthLevel){
        this.healthLevel = healthLevel;
    }

    public void setAbsorption(double absorption) {
        this.absorption = absorption;
    }
}
