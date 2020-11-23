package model.fight;

import model.character.Character;
import model.game.Message;

import java.util.List;

public interface FightSystem {

    Message fight(Character player, Character monster);
    String fightSystemName();
}
