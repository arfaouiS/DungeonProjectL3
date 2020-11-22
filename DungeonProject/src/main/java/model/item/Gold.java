package model.item;

import model.character.Player;

import java.util.Random;

public class Gold implements Item {

    @Override
    public void usedBy(Player player) {
        int MAX_AMOUNT = 200;
        int MIN_AMOUNT = 10;
        int amount = new Random().nextInt(MAX_AMOUNT) + MIN_AMOUNT;
        player.addGold(amount);
    }

    @Override
    public String getPicturePath() {
        return "pictures/gold.png";
    }

    @Override
    public boolean isStorableItem() {
        return false;
    }

    @Override
    public String getDescription() {
        return "Bourse d'or";
    }


}
