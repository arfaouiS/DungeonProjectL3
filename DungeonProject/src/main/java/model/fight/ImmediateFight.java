package model.fight;

import model.character.Character;
import model.game.Message;


public class ImmediateFight implements FightSystem{



    @Override
    public Message fight(Character player, Character monster) {
        Message fightDescription = new Message("Debut du combat\n");
        while (player.isAlive() && monster.isAlive()){
            fightDescription.addInformation("\tLe " + player.getName() + " perd " + monster.getStrengthPoints() + " points de force\n");
            player.damage(monster.getStrengthPoints());
            fightDescription.addInformation("\tLe " + monster.getName() + " perd " + player.getStrengthPoints() + " points de force\n");
            monster.damage(player.getStrengthPoints());
        }
        fightDescription.addInformation("Fin du combat\n");
        return fightDescription;
    }

    @Override
    public String fightSystemName() {
        return "Combat immediat";
    }
}
