package model.character;

import model.item.Item;
import java.util.ArrayList;
import java.util.List;

public class Player extends Character{

    int gold;
    List<Item> bag;

    public Player(String name, int maxLifePoint, int maxStrengthPoint) {
        super(maxLifePoint,maxStrengthPoint, name);
        this.bag = new ArrayList<>();
        this.gold = 0;
    }


    public int getGold() {
        return gold;
    }

    public void addGold(int gold) {
        this.gold += gold;
    }

    public void putInBag(Item renderedItem) {
        bag.add(renderedItem);
    }

    public List<Item> getBagContent() {
        return bag;
    }

    public boolean removeFromBag(Item renderedItem) {
        if(bag.contains(renderedItem)){
            bag.remove(renderedItem);
            return true;
        }
        return false;
    }




}

