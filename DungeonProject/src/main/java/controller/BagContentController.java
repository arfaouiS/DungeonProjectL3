package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.character.Player;
import model.item.Item;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BagContentController  implements Initializable {

    public ListView<Label> items;
    public Player player;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void displayItems() {
        for(Item item: player.getBagContent()){
            items.getItems().add(new Label(item.getDescription()));
        }

    }

    public void play(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/dungeon.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
