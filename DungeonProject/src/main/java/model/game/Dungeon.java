package model.game;

import model.character.Monster;
import model.character.Player;
import model.fight.FightSystem;
import model.item.*;
import model.room.ExitRoomBuilder;
import model.room.Room;
import model.room.RoomBuilder;

import java.util.List;

public class Dungeon {

    private final Player player;
    private final FightSystem fightSystem;
    private final int exitRoomId;
    private final List<Monster> monsters;
    private final List<Item> items;
    private final RoomBuilder roomBuilder;
    private Room currentRoom;


    public Dungeon(Room currentRoom, Player player, FightSystem fightSystem,
                   int nbOfRoom, List<Monster> monsters, List<Item> items, RoomBuilder roomBuilder) {
        this.player = player;
        this.currentRoom = currentRoom;
        this.fightSystem = fightSystem;
        this.exitRoomId = nbOfRoom;
        this.roomBuilder = roomBuilder;
        this.monsters = monsters;
        this.items = items;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Player getPlayer() {
        return player;
    }


    public Message enterIn(){
        if(currentRoom.getId() + 1 < exitRoomId ) {
            this.currentRoom = new Room(roomBuilder, items, monsters);
            return new Message("Vous etes rentres dans la salle " + currentRoom.getId());
        }else {
            this.currentRoom = new Room(new ExitRoomBuilder(),items,monsters);
            return new Message("Vous etes rentres dans la derniere salle de ce donjon");
        }
    }

    public Message playerCollect(Item item){
        Message collectMessage = new Message("Le " + player.getName());
        if(item.isStorableItem()){
            player.putInBag(item);
            collectMessage.addInformation(" a collecte l'objet. Allez dans l'inventaire pour l'utiliser");
        } else {
            item.usedBy(player);
            collectMessage.addInformation(" a collecte : " + item.getDescription());
        }
        return collectMessage;
    }

    public Message playerFight(Monster monster){
        return fightSystem.fight(player, monster);
    }






}
