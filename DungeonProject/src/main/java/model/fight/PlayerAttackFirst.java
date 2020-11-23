package model.fight;

import model.character.Character;
import model.game.Message;

import java.util.List;

public class PlayerAttackFirst implements FightSystem{


    @Override
    public Message fight(Character player, Character monster) {
        Message fightDescription = new Message("Debut du combat\n");
        while (player.isAlive() && monster.isAlive()){
            if(player.isAlive()) {
                fightDescription.addInformation("\tLe " + monster.getName() + " perd " + player.getStrengthPoints() + " points de force\n");
                monster.damage(player.getStrengthPoints());
            }
            if(monster.isAlive()) {
                fightDescription.addInformation("\tLe " + player.getName() + " perd " + monster.getStrengthPoints() + " points de force\n");
                player.damage(monster.getStrengthPoints());
            }
        }
        fightDescription.addInformation("Fin du combat\n");
        return fightDescription;
    }

    @Override
    public String fightSystemName() {
        return "Le joueur attaque en premier";
    }
}
