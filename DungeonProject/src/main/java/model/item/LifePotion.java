package model.item;

import model.character.Player;

public class LifePotion implements Item {

    @Override
    public String getPicturePath() {
        return "pictures/potion.png";
    }

    @Override
    public boolean isStorableItem() {
        return true;
    }

    @Override
    public String getDescription() {
        return "Potion de vie: \n Ajoute 1 vie";
    }


    @Override
    public void usedBy(Player player) {
        int lifePoints = player.getLifePoints();
        player.setLifePoints(Math.min(lifePoints + 1,player.getMaxLifePoint()));
    }
}
