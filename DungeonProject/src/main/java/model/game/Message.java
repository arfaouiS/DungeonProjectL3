package model.game;

public class Message {

    private String message;

    public Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

    public void addInformation(String information) {
        this.message = this.message + information;
    }
}
