package model.room;

import model.character.Monster;
import model.game.Direction;
import model.item.Item;

import java.util.*;

public class RandomRoomBuilder implements RoomBuilder {


    @Override
    public void generateDoors(Room room) {
        int nbDoor = new Random().nextInt(4)+1;
        List<Direction> directions = Arrays.asList(Direction.values());
        Collections.shuffle(directions);
        for (int index=0 ; index<nbDoor ; index++) {
                room.getDirectionRoom(directions.get(index)).setExistDoor(true);
        }
    }


    @Override
    public void generateItems(Room room, List<Item> allItems) {
        for (DirectionRoom directionRoom : room.getEntireRoom()) {
            int nbOfItems = new Random().nextInt(4);
            Collections.shuffle(allItems);
            for (int index = 0; index<nbOfItems; index++) {
                directionRoom.items[index] = allItems.get(index);
            }
        }

    }


    @Override
    public void generateMonsters(Room room, List<Monster> allMonsters) {
        Random random = new Random();
        for (DirectionRoom directionRoom : room.getEntireRoom()) {
            if (directionRoom.existDoor() && random.nextBoolean()) {
                directionRoom.setMonster(allMonsters.get(random.nextInt(allMonsters.size())).clone());
            }
        }
    }

    @Override
    public boolean isExitRoom() {
        return false;
    }
}