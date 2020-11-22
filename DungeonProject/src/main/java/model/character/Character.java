package model.character;

public interface Character {

    // TODO: doit etre une classe abstraite

    int totalLifePoints();
    int totalStrengthPoints();
    int getStrengthPoints();
    int getLifePoints();
    void setStrengthPoints(int strengthPoints);
    void setLifePoints(int lifePoints);
    boolean isAlive();
    void damage(int strengthLost);

}
