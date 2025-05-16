package gameSystems.characterSystem.characters;

import gameSystems.characterSystem.Character;

//Exemplo de personagem padrão
public class Default extends Character {
    //Construção de personagem
    public Default(){
        setName("None");//Nome do personagem
        setDefaultStrength(0);// Força padrão
        setDefaultMaxHealth(0); //vida maxima padrão
        setUltiDelay(1); //delay para ulti
        setUltiName("None"); //Nome da ulti
        setUltiStrength(0); //Força da ulti(em acréscimo de porcentagem)
        setClassId(2); //Id da classe
    }
}
