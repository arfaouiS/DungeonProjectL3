package controller;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.character.*;
import model.fight.FightSystem;
import model.game.Direction;
import model.game.Dungeon;
import model.item.*;
import model.room.DirectionRoom;
import model.room.RandomRoomBuilder;
import model.room.Room;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class DungeonController implements Initializable {

    public Label message;
    public Pane game;
    public Rectangle inFront;
    public Rectangle directionImage;
    public Polyline right;
    public Polyline left;
    public ImageView doorPicture;
    public ImageView monsterImage;
    public Label monsterDescription;
    public VBox monsterVBox;
    public Pane door;
    public Button fightButton;
    public ImageView item1, item2, item3, item4;
    public Label goldQuantity;
    public Label roomId;
    public Label roomDirection;

    public ProgressBar strengthBar;
    public Label strength;
    public HBox lifeBox;
    public Label life;
    public static int MAX_LIFE_POINTS = 5;

    Player player;
    FightSystem fightSystem;
    Dungeon dungeon;
    DirectionRoom currentDirectionRoom;
    Map<DirectionRoom, Map<ImageView, Item>> itemLocalisation = new HashMap<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void setUpGame(Player player, FightSystem fightSystem) {
        Room room = new Room(new RandomRoomBuilder(), controller.Dungeon.items, controller.Dungeon.monsters);
        this.player = player;
        this.fightSystem = fightSystem;
        this.dungeon = new Dungeon(room, player, fightSystem);
        displayGUI();
    }


    public void displayGUI() {
        displayGoldAmount();
        displayLives();
        displayStrength();
        displayRoom();
    }

    public void displayGoldAmount() {
        goldQuantity.setText(String.valueOf(dungeon.getPlayer().getGold()));
    }

    public void displayStrength() {
        int playerStrength = dungeon.getPlayer().getStrengthPoints();
        int maxStrength = dungeon.getPlayer().getMaxStrengthPoint();
        strength.setText(playerStrength + "/" + maxStrength);
        strengthBar.setStyle("-fx-accent: black;");
        DoubleProperty dp = new SimpleDoubleProperty();
        dp.setValue((double) playerStrength / maxStrength);
        strengthBar.progressProperty().bind(dp);
    }


    public void displayLives() {
        life.setText(player.getLifePoints() + "/" + player.getMaxLifePoint());
        for(int index = 0 ; index <= player.getLifePoints(); index++){
            lifeBox.getChildren().get(index).setVisible(true);
        }
        for (int index = player.getLifePoints() + 1; index <= MAX_LIFE_POINTS; index++){
            lifeBox.getChildren().get(index).setVisible(false);
        }
    }

    public void displayRoom() {
        roomId.setText(String.valueOf(dungeon.getCurrentRoom().getId()));
        currentDirectionRoom = (dungeon.getCurrentRoom().getDirectionRoom(Direction.NORTH));

        Image wall = new Image("pictures/wall.png");
        Image sideWall = new Image("pictures/sideWall.png");
        Image door = new Image("pictures/door1.png");

        inFront.setFill(new ImagePattern(wall));
        right.setFill(new ImagePattern(sideWall));
        left.setFill(new ImagePattern(sideWall));
        this.doorPicture.setImage(door);

        displayDirectionRoom(currentDirectionRoom);
    }

    public void displayDirectionRoom(DirectionRoom directionRoom) {
        roomDirection.setText(directionRoom.getDirection().toString());
        doorPicture.setVisible(directionRoom.existDoor());
        directionImage.setFill(new ImagePattern(new Image(currentDirectionRoom.getDirection().getImagePath())));

        this.monsterVBox.setVisible(currentDirectionRoom.existMonster());
        if (currentDirectionRoom.existMonster()) {
            Monster monster = directionRoom.getMonster();
            this.monsterImage.setImage(new Image(monster.getImagePath()));
            this.monsterDescription.setText(monster.getDescription());
        }
        displayItems(directionRoom);
    }


    public void displayItems(DirectionRoom directionRoom) {
        itemLocalisation.put(directionRoom, new HashMap<>());
        List<ImageView> itemsPicture = Arrays.asList(item1, item2, item3, item4);
        Collections.shuffle(itemsPicture);
        for (int index = 0; index < 4; index++) {
            if (directionRoom.existItem(index)) {
                itemLocalisation.get(directionRoom).put(itemsPicture.get(index), directionRoom.items[index]);
                Item item = directionRoom.items[index];
                itemsPicture.get(index).setImage(new Image(item.getPicturePath()));
                itemsPicture.get(index).setVisible(true);
            } else
                itemsPicture.get(index).setVisible(false);
        }
    }


    public void playerMove(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case UP:
                currentDirectionRoom = (dungeon.getCurrentRoom().getDirectionRoom(Direction.NORTH));
                displayDirectionRoom(currentDirectionRoom);
                break;
            case DOWN:
                currentDirectionRoom = (dungeon.getCurrentRoom().getDirectionRoom(Direction.SOUTH));
                displayDirectionRoom(currentDirectionRoom);
                break;
            case LEFT:
                currentDirectionRoom = (dungeon.getCurrentRoom().getDirectionRoom(Direction.WEST));
                displayDirectionRoom(currentDirectionRoom);
                break;
            case RIGHT:
                currentDirectionRoom = (dungeon.getCurrentRoom().getDirectionRoom(Direction.EAST));
                displayDirectionRoom(currentDirectionRoom);
                break;
        }
    }

    public void createRoom() {
        Room newRoom = new Room(new RandomRoomBuilder(), controller.Dungeon.items, controller.Dungeon.monsters);
        dungeon.enterIn(newRoom);
        for(Monster monster: controller.Dungeon.monsters){
            monster.setStrengthPoints(monster.getMaxStrengthPoint());
            monster.setLifePoints(monster.getMaxLifePoint());
        }
        displayRoom();
    }


    public void displayBag() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/bag.fxml"));
            Parent root = loader.load();

            BagContentController bagContentController = loader.getController();
            bagContentController.player = player;
            bagContentController.displayItems();

            Stage newWindow = new Stage();
            newWindow.setScene(new Scene(root));
            newWindow.initModality(Modality.WINDOW_MODAL);
            Stage primaryStage = (Stage) this.game.getScene().getWindow();
            newWindow.initOwner(primaryStage);
            newWindow.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void collectItem(MouseEvent mouseEvent) {
        ImageView itemView = (ImageView) mouseEvent.getSource();
        Item item = itemLocalisation.get(currentDirectionRoom).get(itemView);
        currentDirectionRoom.deleteItem(item);
        itemView.setVisible(false);
        if(item.isStorableItem()){
            player.putInBag(item);
        } else {
            item.usedBy(player);
            displayGoldAmount();
        }

    }

    public void fight() {
        dungeon.playerFight(currentDirectionRoom.getMonster());
        displayDirectionRoom(currentDirectionRoom);
        displayStrength();
        displayLives();
    }
}

