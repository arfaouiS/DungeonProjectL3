package model.game;

import model.character.Monster;
import model.character.Player;
import model.fight.FightSystem;
import model.item.*;
import model.room.Room;

public class Dungeon {

    private final Player player;
    private final FightSystem fightSystem;
    private Room currentRoom;

    public Dungeon(Room currentRoom, Player player, FightSystem fightSystem) {
        this.player = player;
        this.currentRoom = currentRoom;
        this.fightSystem = fightSystem;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Player getPlayer() {
        return player;
    }


    public void enterIn(Room room){
        this.currentRoom = room;
    }

    public Message playerCollect(Item renderedItem){
        player.putInBag(renderedItem);
        return new Message("L'objet est dans l'inventaire");
    }

    public void playerFight(Monster monster){
        fightSystem.fight(player, monster);
    }




}
