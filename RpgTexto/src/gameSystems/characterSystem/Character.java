package gameSystems.characterSystem;

import gameSystems.characterSystem.characteristics.*;


public abstract class Character {


    //Adciona as características do personagem
    private Health hp = new Health(); //Vida
    private Attack atk = new Attack(); //Ataque
    private Copy cp = new Copy(); // Copia

    private String name; //nome do personagem

    //Verifica se está vazio
    public boolean isNull(){
        if(this.getId() == 0){
            return true;
        }
        else {
            return false;
        }
    }

    //Pega o id da classe
    public int getId(){
        return cp.getClassId();
    }

   //Carrega a ulti, e será chamada ao final de um turno
    public void ultiTimeNear(){
       atk.ultiTimeNear();
    }

    //verifica se pode usar uma ulti
    public boolean canUseUlti(){
        return atk.canUseUlti();
    }

    //Verifica se o personagem está morto
    public boolean isDead(){
        if (getCurrentHealth() <= 0){
            return true;
        }
        else {
            return false;
        }
    }

    //Tomae dano
    public void takeDamage(double damage){
        hp.takeDamage(damage);
    }

    //Cura o peronagem
    public void heal(double healValue){
        hp.heal(healValue);
    }



    //Ataca um outo personagem
    public void attack(Character target){
        atk.attack(target);
    }

    //Ataque de Ulti
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

    //Copia a classe de um personagem
    public Character copyClass(){
        return cp.copyClass();
    }

    //Copia um objeto como um todo
    public Character copyObject(){
        return cp.copyObject(this);
    }



}
