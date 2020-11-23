package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import model.character.Monster;
import model.character.Player;
import model.fight.FightSystem;
import model.fight.MonsterAttackFirst;
import model.fight.PlayerAttackFirst;
import model.item.*;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class OptionsController implements Initializable {

    private static final Monster dragon = new Monster("Dragon", "pictures/monster-dragon.png", 2, 60);
    private static final Monster xorn = new Monster("Xorn", "pictures/xorn.png", 1, 100);
    private static final Monster mane = new Monster("Mane", "pictures/mane.png", 3, 80);
    private static final Player magician = new Player("Magicien", 5, 150);
    private static final Player human = new Player("Humain", 5, 100);

    public static final List<Monster> monsters = Arrays.asList(dragon,xorn,mane);
    public static final List<Item> items = Arrays.asList(new LifePotion(), new Bomb(), new Gold(), new Weapon());
    public static final List<Player> players = Arrays.asList(magician,human);
    public static final List<FightSystem> fightSystems = Arrays.asList(new MonsterAttackFirst(),new PlayerAttackFirst());

    public ChoiceBox<String> playersComboBox;
    public ChoiceBox<String> fightSystemComboBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayPlayerChooser();
        displayFightSystemChooser();
    }

    private void displayPlayerChooser() {
        for(Player player: players){
            playersComboBox.getItems().add(player.getName());
        }
        playersComboBox.getSelectionModel().select(0);
    }

    private void displayFightSystemChooser() {
        for(FightSystem fightSystem: fightSystems){
            fightSystemComboBox.getItems().add(fightSystem.fightSystemName());
        }
        fightSystemComboBox.getSelectionModel().select(0);

    }

    public void play(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/dungeon.fxml"));
            Parent root = loader.load();

            DungeonController dungeonController = loader.getController();
            Player player = players.get(playersComboBox.getSelectionModel().getSelectedIndex());
            FightSystem fightSystem = fightSystems.get(fightSystemComboBox.getSelectionModel().getSelectedIndex());
            dungeonController.setUpGame(player,fightSystem);

            Scene scene = new Scene(root);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
