package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.character.Monster;
import model.character.Player;
import model.fight.FightSystem;
import model.fight.MonsterAttackFirst;
import model.fight.PlayerAttackFirst;
import model.item.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Game extends Application {


    private static final Monster dragon = new Monster("Dragon", "pictures/monster-dragon.png", 2, 60);
    private static final Monster xorn = new Monster("Xorn", "pictures/xorn.png", 1, 100);
    private static final Monster mane = new Monster("Mane", "pictures/mane.png", 3, 80);
    private static final Player magician = new Player("Magicien", 5, 150);
    private static final Player human = new Player("Humain", 5, 100);


    public static final List<Monster> monsters = Arrays.asList(dragon,xorn,mane);
    public static final List<Item> items = Arrays.asList(new LifePotion(), new Bomb(), new Gold(), new Weapon());
    public static final List<Player> players = Arrays.asList(magician,human);
    public static final List<FightSystem> fightSystems = Arrays.asList(new MonsterAttackFirst(),new PlayerAttackFirst());


    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/options.fxml"));
        primaryStage.setTitle("controller.Dungeon");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
