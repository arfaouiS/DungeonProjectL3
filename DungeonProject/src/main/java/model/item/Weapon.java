package model.item;

import model.character.Player;

public class Weapon implements Item {

    @Override
    public void usedBy(Player player) {
        int strengthPoints = player.getStrengthPoints();
        player.setStrengthPoints(Math.min(strengthPoints + 10,player.getMaxStrengthPoint()));
    }

    @Override
    public String getPicturePath() {
        return "pictures/weapon.png";
    }

    @Override
    public boolean isStorableItem() {
        return true;
    }

    @Override
    public String getDescription() {
        return "Arm: \n Ajoute 10 points de force";
    }

}
