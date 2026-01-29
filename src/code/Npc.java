package code;

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
