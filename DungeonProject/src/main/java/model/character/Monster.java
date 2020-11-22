package model.character;

public class Monster extends Character{

    private final String imagePath;

    public Monster(String name, String imagePath, int maxLifePoint, int maxStrengthPoint) {
        super(maxLifePoint, maxStrengthPoint, name);
        this.imagePath = imagePath;
    }


    public String getImagePath() {
        return imagePath;
    }

    public String getDescription(){
        return name + ": Force = "  + strengthPoints + " Vies = " + lifePoints;
    }
}
