package gameSystems.characterSystem.characters;

import gameSystems.characterSystem.Character;

public class Witch extends Character {
    public Witch(){
        setName("Witch");
        setDefaultStrength(15);
        setDefaultMaxHealth(70);
        setUltiDelay(5);
        setUltiName("Fireball");
        setUltiStrength(10);
        setClassId(3);
    }
}
