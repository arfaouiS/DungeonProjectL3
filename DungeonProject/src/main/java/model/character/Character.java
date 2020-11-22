package model.character;


public abstract class Character {

    int maxLifePoint;
    int maxStrengthPoint;
    int lifePoints;
    int strengthPoints;
    String name;
    boolean isAlive;

    public Character(int maxLifePoint, int maxStrengthPoint, String name) {
        this.name = name;
        this.maxLifePoint = maxLifePoint;
        this.maxStrengthPoint = maxStrengthPoint;
        this.lifePoints = maxLifePoint ;
        this.strengthPoints = maxStrengthPoint;
        this.isAlive = true;
    }

    public String getName() {
        return name;
    }

    public int getMaxLifePoint() {
        return maxLifePoint;
    }

    public int getMaxStrengthPoint() {
        return maxStrengthPoint;
    }


        public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public void setStrengthPoints(int strengthPoints) {
        this.strengthPoints = strengthPoints;
    }


    public int getStrengthPoints() {
        return strengthPoints;
    }

    public int getLifePoints() {
        return lifePoints;
    }


    public boolean isAlive() {
        return lifePoints > 0;
    }



    public void loseLife(){
        if(lifePoints > 0) {
            setLifePoints(lifePoints - 1);
            setStrengthPoints(getMaxStrengthPoint());
        } else
            setStrengthPoints(0);

    }

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

