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
        northRoom.monster = monsters.get(random.nextInt(monsters.size()));
    }






    /*

    @Override
    public Map<Direction, List<Item>> generateItems() {
        Map<Direction, List<Monster>> items = new HashMap<>();
        // TODO: trouver comment générer un objet aléatoirement
        return null;
    }

    @Override
    public Map<Direction, List<Monster>> generateMonsters() {
        Map<Direction, List<Monster>> monsters = new HashMap<>();
        // TODO: trouver comment générer un monstre aléatoirement
        return monsters;
    }

    @Override
    public Map<Direction, Boolean> generateDoors() {
        Map<Direction, Boolean> doors = new HashMap<>(4);
        doors.put(Direction.SOUTH, true);
        doors.put(Direction.NORTH, false);
        doors.put(Direction.WEST, false);
        doors.put(Direction.EST, false);
        return doors;
    }

     */
}
