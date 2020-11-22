package model.item;

import model.character.Player;

public interface Item {

    void usedBy(Player player);
    String getPicturePath();
    boolean isStorableItem();
    String getDescription();

}
