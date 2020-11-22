package model.room;

import model.character.Monster;
import model.game.Direction;
import model.item.Item;
import java.util.List;
import java.util.Random;

public class ExitRoomBuilder implements RoomBuilder {

    @Override
    public void generateDoors(Room room) {
        Direction[] directions = Direction.values();
        for (Direction direction : directions) {
                room.getDirectionRoom(direction).setExistDoor(false);
        }
    }

    @Override
    public void generateItems(Room room, List<Item> items) {
        // TODO: Décider p
    }

    @Override
    public void generateMonsters(Room room, List<Monster> monsters) {
        Random random = new Random();
        DirectionRoom northRoom = room.getDirectionRoom(Direction.NORTH);
        northRoom.setMonster(monsters.get(random.nextInt(monsters.size())));
    }

}
