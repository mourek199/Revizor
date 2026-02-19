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

    public void talk(Revizor revizor, GameMap gameMap){
        System.out.println(Tools.color("blue", "\""+this.welcomeMessage+"\""));
        Tools.lineSkip(1);
        System.out.println(revizor.addItem(gameMap.getItems().get(this.getCharacterItem())));
        Tools.pressEnter();
        Tools.consoleClear();
        System.out.println(Tools.color("blue", "\""+this.goodbyeMessage+"\""));
        Tools.pressEnter();
        Tools.consoleClear();
    }


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

    public void setName(String name) {
        this.name = name;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public void setGoodbyeMessage(String goodbyeMessage) {
        this.goodbyeMessage = goodbyeMessage;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCharacterItem(String characterItem) {
        this.characterItem = characterItem;
    }
}
