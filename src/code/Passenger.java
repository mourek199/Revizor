package code;
import java.util.Random;

public class Passenger {
    Random rd = new Random();
    private String firstName;
    private String lastName;
    private int age;
    private boolean female;
    private int usedId;

    public Passenger() {
        this.female = rd.nextBoolean();
        if (this.female) {
            this.firstName = PassengerBuilder.WomanNames.get(rd.nextInt(PassengerBuilder.WomanNames.size()));
            this.lastName = PassengerBuilder.WomanLastnames.get(rd.nextInt(PassengerBuilder.WomanLastnames.size()));
        } else {
            this.firstName = PassengerBuilder.ManNames.get(rd.nextInt(PassengerBuilder.ManNames.size()));
            this.lastName = PassengerBuilder.ManLastNames.get(rd.nextInt(PassengerBuilder.ManLastNames.size()));
        }
        this.age = rd.nextInt(9,81);

        this.usedId = rd.nextInt(0, 4);
        if (PassengerBuilder.identification.get(usedId).getChance() <= rd.nextInt(1, 11)){
            this.usedId = rd.nextInt(0, 4);
        }
    }

    @Override
    public String toString() {
        return  firstName + " " +
                lastName + " (" + age + " let)";
    }

    public int getAge() {
        return age;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getUsedId() {
        return usedId;
    }
}
