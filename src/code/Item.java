package code;

public class Item {
    private String name;
    private String description;
    private int cost;
    private int depressionChange;
    private boolean consumable;

    public Item() {
    }

    public Item(String name, String description, int cost) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.consumable = false;
        this.depressionChange = 0;
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
                '}';
    }
}
