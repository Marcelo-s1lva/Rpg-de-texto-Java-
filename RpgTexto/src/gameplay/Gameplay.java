package gameplay;

import gameSystems.battleSystems.Battles;
import gameSystems.dialogueSystem.Dialogues;


public class Gameplay {
    public static Dialogues dialogues = new Dialogues();
    public static Player mainPlayer = new Player();
    public static Displays display = new Displays();
    public static Battles battles = new Battles();
}
