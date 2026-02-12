package code;

/**
 * An item is an object which can be picked up, carried in player's backpack or consumed in some cases
 * @author Tony
 */
public class Item {
    private String name;
    private String description;
    private String consumeMessage;
    private int cost;
    private int depressionChange;
    private boolean consumable;

    public Item() {
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCost() {
        return cost;
    }

    public int getDepressionChange() {
        return depressionChange;
    }

    public String getConsumeMessage() {
        return consumeMessage;
    }

    public boolean isConsumable() {
        return consumable;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", depressionChange=" + depressionChange +
                ", consumable=" + consumable +
                ", name='" + consumeMessage + '\'' +
                '}';
    }
}
