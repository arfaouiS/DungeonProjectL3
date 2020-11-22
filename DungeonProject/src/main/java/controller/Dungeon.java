package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.character.Monster;
import model.item.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Dungeon extends Application {


    private static Monster dragon = new Monster("Dragon", "pictures/monster-dragon.png", 2, 60);
    private static Monster xorn = new Monster("Xorn", "pictures/xorn.png", 1, 100);
    private static Monster mane = new Monster("Mane", "pictures/man.png", 3, 80);

    public static final List<Monster> monsters = Arrays.asList(dragon,xorn,mane);
    public static final List<Item> items = Arrays.asList(new LifePotion(), new Bomb(), new Gold(), new Weapon());


    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/options.fxml"));
        primaryStage.setTitle("controller.Dungeon");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
