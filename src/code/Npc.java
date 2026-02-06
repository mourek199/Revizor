package code;

/**
 * This class represents a character which the player can interact with
 */
public class Npc {
    private String name;
    private String welcomeMessage;
    private String description;

    public Npc() {
    }

    public String getName() {
        return name;
    }

    public String getWelcomeMessage() {
        return name +": \"" +welcomeMessage +"\"";
    }

    public String getDescription() {
        return description;
    }
}
