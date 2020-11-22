package model.game;

import model.character.Monster;
import model.character.Player;
import model.fight.FightSystem;
import model.item.*;
import model.room.Room;

import java.util.ArrayList;
import java.util.List;

public class Dungeon {

    private final Player player;
    private final FightSystem fightSystem;
    private Room currentRoom;
    private List<Room> visitedRooms;

    public Dungeon(Room currentRoom, Player player, FightSystem fightSystem) {
        this.player = player;
        this.currentRoom = currentRoom;
        this.fightSystem = fightSystem;
        this.visitedRooms = new ArrayList<>();
        visitedRooms.add(currentRoom);
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Player getPlayer() {
        return player;
    }


    public void enterIn(Room room){
        this.currentRoom = room;
        this.visitedRooms.add(currentRoom);
    }

    public Message playerCollect(Item renderedItem){
        player.putInBag(renderedItem);
        return new Message("L'objet est dans l'inventaire");
    }

    public void playerFight(Monster monster){
        fightSystem.fight(player,monster);
    }




}
