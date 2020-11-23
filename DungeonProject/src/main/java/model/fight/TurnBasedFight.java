package model.fight;

import model.character.Character;
import model.game.Message;

import java.util.List;

public class TurnBasedFight implements FightSystem{

    //TODO: A implémenter


    @Override
    public Message fight(Character players, Character monsters) {
        return new Message("");
    }

    @Override
    public String fightSystemName() {
        return "Combat tour par tour";
    }
}
