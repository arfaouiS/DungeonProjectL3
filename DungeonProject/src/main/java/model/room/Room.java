package model.room;

import model.character.Monster;
import model.game.Direction;
import model.item.Item;

import java.util.Arrays;
import java.util.List;


public class Room {

    private static int id=0;
    private final DirectionRoom north = new DirectionRoom(Direction.NORTH);
    private final DirectionRoom south = new DirectionRoom(Direction.SOUTH);
    private final DirectionRoom west = new DirectionRoom(Direction.WEST);
    private final DirectionRoom east = new DirectionRoom(Direction.EAST);
    private final List<DirectionRoom> entireRoom = Arrays.asList(north, south, west, east);
    private final boolean isExitRoom;


    public Room(RoomBuilder roomBuilder, List<Item> items, List<Monster> monsters) {
        roomBuilder.generateDoors(this);
        roomBuilder.generateItems(this, items);
        roomBuilder.generateMonsters(this, monsters);
        this.isExitRoom = roomBuilder.isExitRoom();
        id++;
    }

    public List<DirectionRoom> getEntireRoom() {
        return entireRoom;
    }

    public DirectionRoom getDirectionRoom(Direction direction){
        switch (direction){
            case NORTH: return north;
            case SOUTH: return south;
            case WEST: return west;
            case EAST: return east;
        }
        return null;
    }

    public boolean isExitRoom(){
        return isExitRoom;
    }

    public int getId() {
        return id;
    }



}
