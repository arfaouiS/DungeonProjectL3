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


    public Message enterIn(Room room){
        this.currentRoom = room;
        return new Message("Vous etes rentres dans la salle " + currentRoom.getId());
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
