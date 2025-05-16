package gameSystems.characterSystem.characters;

import gameSystems.characterSystem.Character;

public class Protagonist extends Character {
    public Protagonist(){
        setName("Protagonista");
        setDefaultStrength(50);
        setDefaultMaxHealth(150);
        setUltiDelay(3);
        setUltiName("Estocada");
        setUltiStrength(3.70);
        setClassId(4);
    }

}
