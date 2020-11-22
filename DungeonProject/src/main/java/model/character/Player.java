package model.character;

import model.item.Item;

import java.util.List;

public interface Player extends Character{

    int getGold();
    void addGold(int gold);
    void putInBag(Item renderedItem);
    List<Item> getBagContent();
    boolean removeFromBag(Item renderedItem);
    String getName();
}
