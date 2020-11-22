package model.fight;

import model.character.Character;

import java.util.List;

public interface FightSystem {

    void fight(Character player, Character monster);
    String fightSystemName();
}
