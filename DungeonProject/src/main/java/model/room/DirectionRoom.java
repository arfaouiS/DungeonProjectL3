package model.room;

import model.character.Monster;
import model.game.Direction;
import model.item.Item;

public class DirectionRoom {

    private final Direction direction;
    public Item[] items;
    public Monster monster;
    private boolean existDoor;


    public DirectionRoom(Direction direction) {
        this.direction = direction;
        this.items = new Item[4];
        this.monster = null;
        this.existDoor = false;
    }

    public void setExistDoor(boolean existDoor){
        this.existDoor = existDoor;
    }

    public boolean existDoor(){
        return existDoor;
    }

    public boolean existMonster(){
        return (this.monster != null && monster.isAlive());
    }

    public boolean existItem(int index){
        return items[index] != null;
    }

    public boolean deleteItem(Item item){
        for(int index = 0; index<items.length; index++) {
            if (existItem(index) && items[index].equals(item)) {
                items[index] = null;
                return true;
            }
        }
        return false;
    }

    public Direction getDirection() {
        return direction;
    }
}
