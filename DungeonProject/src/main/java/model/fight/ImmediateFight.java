package model.fight;

import model.character.Character;


public class ImmediateFight implements FightSystem{



    @Override
    public void fight(Character player, Character monster) {
        while (player.isAlive() && monster.isAlive()){
            System.out.println("Avant: Player=" + player.getStrengthPoints()+"/"+player.getLifePoints() + " Monster=" + monster.getStrengthPoints()+"/" + monster.getLifePoints());
            player.damage(monster.getStrengthPoints());
            System.out.println("Monstre a attaqué: Player=" + player.getStrengthPoints()+"/"+player.getLifePoints() + " Monster=" + monster.getStrengthPoints()+"/" + monster.getLifePoints());
            monster.damage(player.getStrengthPoints());
            System.out.println("Player a attaqué: Player=" + player.getStrengthPoints()+"/"+player.getLifePoints() + " Monster=" + monster.getStrengthPoints()+"/" + monster.getLifePoints());
        }
        System.out.println("Monstre est en vie: " + monster.isAlive());
        System.out.println("Player est en vie: " + player.isAlive());
        System.out.print("\n");
    }

    @Override
    public String fightSystemName() {
        return "Combat immediat";
    }
}
