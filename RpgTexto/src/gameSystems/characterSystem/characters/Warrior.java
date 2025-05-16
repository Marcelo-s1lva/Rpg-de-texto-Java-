package gameSystems.characterSystem.characters;

import gameSystems.characterSystem.Character;

public class Warrior extends Character {
    public Warrior(){
        setName("Warrior");
        setDefaultStrength(20);
        setDefaultMaxHealth(150);
        setUltiDelay(3);
        setUltiName("Slash");
        setUltiStrength(3.70);
        setClassId(1);
    }

}
