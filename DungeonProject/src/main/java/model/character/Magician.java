package model.character;
import model.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Magician implements Player {

    int lifePoints;
    int strengthPoints;
    int gold;
    boolean isAlive;
    List<Item> bag;

    public Magician() {
        this.lifePoints = totalLifePoints() ;
        this.strengthPoints = totalStrengthPoints();
        this.bag = new ArrayList<>();
        this.isAlive = true;
        this.gold = 0;
    }

    @Override
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    @Override
    public void setStrengthPoints(int strengthPoints) {
        this.strengthPoints = strengthPoints;
    }


    @Override
    public int totalLifePoints() {
        return 5;
    }

    @Override
    public int totalStrengthPoints() {
        return 150;
    }

    @Override
    public int getStrengthPoints() {
        return strengthPoints;
    }

    @Override
    public int getLifePoints() {
        return lifePoints;
    }


    @Override
    public boolean isAlive() {
        return lifePoints > 0;
    }

    @Override
    public int getGold() {
        return gold;
    }

    @Override
    public void addGold(int gold) {
        this.gold += gold;
    }

    @Override
    public void putInBag(Item renderedItem) {
        bag.add(renderedItem);
    }

    @Override
    public List<Item> getBagContent() {
        return bag;
    }

    @Override
    public boolean removeFromBag(Item renderedItem) {
        if(bag.contains(renderedItem)){
            bag.remove(renderedItem);
            return true;
        }
        return false;
    }

    @Override
    public String getName() {
        return "Magicien";
    }

    public void loseLife(){
        if(lifePoints > 0) {
            setLifePoints(lifePoints - 1);
            setStrengthPoints(totalStrengthPoints());
        } else
            setStrengthPoints(0);

    }

    @Override
    public void damage(int strengthLost) {
        if(!this.isAlive()) return;
        if(strengthLost < strengthPoints ) {
                setStrengthPoints(strengthPoints - strengthLost);
                return;
        }
        int strength = strengthPoints;
        loseLife();
        damage(strengthLost - strength);
    }


}
