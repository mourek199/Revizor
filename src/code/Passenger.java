package code;
import java.util.Random;

public class Passenger {
    Random rd = new Random();
    private String firstName;
    private String lastName;
    private int age;
    private boolean female;

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
    }

    @Override
    public String toString() {
        return  firstName + " " +
                lastName + " (" + age + " let)";
    }
}
