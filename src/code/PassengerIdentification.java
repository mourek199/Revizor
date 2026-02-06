package code;

/**
 * Each passenger has their identification document
 */
public class PassengerIdentification {
    private String idType;
    private String color;
    private int chance;

    public PassengerIdentification(String idType, String color, int chance) {
        this.idType = idType;
        this.color = color;
        this.chance = chance;
    }

    public String getIdType() {
        return idType;
    }

    public String getColor() {
        return color;
    }

    public int getChance() {
        return chance;
    }

}


