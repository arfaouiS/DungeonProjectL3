package model.room;

import model.character.Monster;
import model.game.Direction;
import model.item.Item;

public class DirectionRoom {

    private final Direction direction;
    public Item[] items;
    private Monster monster;
    private boolean existDoor;


    public DirectionRoom(Direction direction) {
        this.direction = direction;
        this.items = new Item[4];
        this.monster = null;
        this.existDoor = false;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setExistDoor(boolean existDoor){
        this.existDoor = existDoor;
    }

    public boolean existDoor(){
        return existDoor;
    }

    // TODO : verifier cette méthode
    public boolean existMonster(){
        return (this.monster != null && monster.isAlive());
    }

    public boolean existItem(int index){
        return items[index] != null;
    }

    public void deleteItem(Item item){
        for(int index = 0; index<items.length; index++) {
            if (existItem(index) && items[index].equals(item)) {
                items[index] = null;
            }
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public void printRoom(){
        System.out.println(direction.toString() + this + ": \n\tDoor=" + existDoor + "\n\tMonster=" + monster);
    }
}
