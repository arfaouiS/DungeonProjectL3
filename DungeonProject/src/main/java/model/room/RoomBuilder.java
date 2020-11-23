package model.room;

import model.character.Monster;
import model.item.Item;

import java.util.List;

public interface RoomBuilder {

    void generateDoors(Room room);
    void generateItems(Room room, List<Item> items);
    void generateMonsters(Room room, List<Monster> monsters);
    boolean isExitRoom();

}
