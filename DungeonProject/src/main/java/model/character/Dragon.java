package model.character;


public class Dragon implements Monster {

    // TODO: implémenter


    int lifePoints;
    int strengthPoints;

    public Dragon() {
        this.lifePoints = totalLifePoints();
        this.strengthPoints = totalStrengthPoints();
    }

    public String getDescription(){
        return "Dragon: " +
                "Force = "  + strengthPoints + " Vies = " + lifePoints;
    }

    @Override
    public int totalLifePoints() {
        return 2;
    }

    @Override
    public int totalStrengthPoints() {
        return 30;
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
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    @Override
    public void setStrengthPoints(int strengthPoints) {
        this.strengthPoints = strengthPoints;
    }

    @Override
    public boolean isAlive() {
        return  lifePoints > 0;
    }

    @Override
    public void damage(int strengthLost) {
        if(!this.isAlive()) return;
        if(strengthLost < this.strengthPoints) {
            setStrengthPoints(strengthPoints - strengthLost);
            return;
        }
        int strength = strengthPoints;
        loseLife();
        damage(strengthLost - strength);
    }

    public void loseLife(){
        if(lifePoints > 0) {
            setLifePoints(lifePoints - 1);
            setStrengthPoints(totalStrengthPoints());
        } else
            setStrengthPoints(0);
    }


    @Override
    public String getImagePath() {
        return "pictures/monster-dragon.png";
    }


}
