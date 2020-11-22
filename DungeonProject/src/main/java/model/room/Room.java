package model.room;

import model.character.Monster;
import model.game.Direction;
import model.item.Item;

import java.util.Arrays;
import java.util.List;


public class Room {

    private static int id=0;
    private  DirectionRoom north = new DirectionRoom(Direction.NORTH);
    private  DirectionRoom south = new DirectionRoom(Direction.SOUTH);
    private  DirectionRoom west = new DirectionRoom(Direction.WEST);
    private  DirectionRoom est = new DirectionRoom(Direction.EAST);
    private  List<DirectionRoom> entireRoom = Arrays.asList(north, south, west, est);


    public Room(RoomBuilder roomBuilder, List<Item> items, List<Monster> monsters) {
        roomBuilder.generateDoors(this);
        roomBuilder.generateItems(this, items);
        roomBuilder.generateMonsters(this, monsters);
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
            case EAST: return est;
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public boolean existMonsterAlive(){
        for(DirectionRoom directionRoom: entireRoom){
            if(directionRoom.existMonster()) return true;
        }
        return false;
    }

}
