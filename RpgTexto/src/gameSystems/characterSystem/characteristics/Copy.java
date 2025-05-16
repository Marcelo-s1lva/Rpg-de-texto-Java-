package gameSystems.characterSystem.characteristics;


import gameSystems.characterSystem.Character;
import gameSystems.characterSystem.EmptyChar;
import gameSystems.characterSystem.characters.*;

public class Copy {

    //identifies the class by an ID
    private int classId;

    public void setClassId(int id){
        classId = id;
    }

    public Character copyClass(){

        switch (this.classId){
            case 1:
                return new Default();
            case 2:
                return new Warrior();
            case 3:
                return new Witch();
            case 4:
                return new Protagonist();
            case 5:
                return new GuardaDoRei();
            default:
                return new EmptyChar();
        }

    }


    public Character copyObject(Character character){
        Character copy;
        copy = copyClass();

        copy.setName(character.getName());
        copy.setDefaultStrength(character.getAttackStrength());
        copy.setDefaultMaxHealth(character.getDefaultMaxHealth());
        copy.setCurrentHealth(character.getCurrentHealth());
        copy.setHealthLevel(character.getHealthLevel());
        copy.setUltiDelay(character.getUltiDelay());
        copy.setUltiName(character.getUltiName());
        copy.setUltiStrength(character.getUltiPercentage());
        copy.setAbsorption(character.getAbsorption());


        return copy;

    }


    public int getClassId(){
        return classId;
    }
}
