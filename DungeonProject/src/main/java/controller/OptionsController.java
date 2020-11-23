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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OptionsController implements Initializable {

    public ChoiceBox<String> playersComboBox;
    public ChoiceBox<String> fightSystemComboBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayPlayerChooser();
        displayFightSystemChooser();
    }

    private void displayPlayerChooser() {
        for(Player player: Game.players){
            playersComboBox.getItems().add(player.getName());
        }
        playersComboBox.getSelectionModel().select(0);
    }

    private void displayFightSystemChooser() {
        for(FightSystem fightSystem: Game.fightSystems){
            fightSystemComboBox.getItems().add(fightSystem.fightSystemName());
        }
        fightSystemComboBox.getSelectionModel().select(0);

    }

    public void play(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/dungeon.fxml"));
            Parent root = loader.load();

            DungeonController dungeonController = loader.getController();
            Player player = Game.players.get(playersComboBox.getSelectionModel().getSelectedIndex());
            FightSystem fightSystem = Game.fightSystems.get(fightSystemComboBox.getSelectionModel().getSelectedIndex());
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
