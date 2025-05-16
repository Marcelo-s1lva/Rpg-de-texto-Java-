package gameSystems.battleSystems.arrayCopy;

import gameSystems.characterSystem.Character;

public class Copy {


    public static Character[] ArrayCopy(Character[] reference){


        Character[] copy = new Character[reference.length];
        for (int i = 0; i < reference.length; i++) {
            if (reference[i] != null) {
                copy[i] = reference[i].copyObject();
            }
            else{
                copy[i] = null;
            }
        }

        return copy;
    }
}
