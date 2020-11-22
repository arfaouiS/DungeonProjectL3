package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import model.character.Player;
import model.fight.FightSystem;
import model.fight.ImmediateFight;
import model.fight.TurnBasedFight;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class OptionsController implements Initializable {

    public ChoiceBox<String> playersComboBox;
    public ChoiceBox<String> fightSystemComboBox;

    List<Player> players = Arrays.asList(new Player("Magician", 5, 150));
    List<FightSystem> fightSystems = Arrays.asList(new ImmediateFight(),new TurnBasedFight());

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
