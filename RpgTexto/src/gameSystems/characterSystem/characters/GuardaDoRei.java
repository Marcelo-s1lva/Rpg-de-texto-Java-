package gameSystems.characterSystem.characters;

import gameSystems.characterSystem.Character;

public class GuardaDoRei extends Character {
    public GuardaDoRei(){
        setName("Guarda do Rei");
        setDefaultStrength(10);
        setDefaultMaxHealth(20);
        setUltiDelay(5);
        setUltiName("Estocada");
        setUltiStrength(2.5);
        setClassId(5);
    }
}
