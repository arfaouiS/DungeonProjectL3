package model.item;

import model.character.Player;

public class Bomb implements Item {

    @Override
    public String getPicturePath() {
        return "pictures/bomb.png";
    }

    @Override
    public boolean isStorableItem() {
        return true;
    }

    @Override
    public String getDescription() {
        return "Bombe: \n Ajoute 30 points de force";
    }


    @Override
    public void usedBy(Player player) {
        int strengthPoints = player.getStrengthPoints();
        player.setStrengthPoints(Math.min(strengthPoints + 30,player.getMaxStrengthPoint()));
    }
}
