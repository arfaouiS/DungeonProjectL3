package model.fight;

import model.character.Character;


public class ImmediateFight implements FightSystem{



    @Override
    public void fight(Character player, Character monster) {
        while (player.isAlive() && monster.isAlive()){
            player.damage(monster.getStrengthPoints());
            monster.damage(player.getStrengthPoints());
        }
    }

    @Override
    public String fightSystemName() {
        return "Combat immediat";
    }
}
