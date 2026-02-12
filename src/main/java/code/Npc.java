package code;

/**
 * This class represents a character which the player can interact with
 * @author Tony
 */
public class Npc {
    private String name;
    private String welcomeMessage;
    private String goodbyeMessage;
    private String description;
    private String characterItem;


    public Npc() {
    }

    public String getName() {
        return name;
    }

    public String getWelcomeMessage() {
        return name +": \"" +welcomeMessage +"\"";
    }

    public String getGoodbyeMessage() {
        return goodbyeMessage;
    }

    public String getDescription() {
        return description;
    }
    public String getCharacterItem() {
        return characterItem;
    }
}
