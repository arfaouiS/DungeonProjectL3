package controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import model.character.Player;
import model.item.Item;


import java.net.URL;
import java.util.ResourceBundle;

public class BagContentController  implements Initializable {

    public ListView<Label> items;
    public Player player;
    public Button useItemButton;
    DungeonController dungeonController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void displayItems() {
        for(Item item: player.getBagContent()){
            Label itemDescription = new Label(item.getDescription());
            items.getItems().add(itemDescription);
            items.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        }
    }


    public void useItem() {
        if(items.getSelectionModel().getSelectedIndices().size() > 0) {
            int itemIndex = items.getSelectionModel().getSelectedIndex();
            items.getItems().remove(itemIndex);
            Item item = player.getBagContent().get(itemIndex);
            player.removeFromBag(itemIndex);
            item.usedBy(player);
            dungeonController.displayStrength();
            dungeonController.displayLives();
        }
    }
}
