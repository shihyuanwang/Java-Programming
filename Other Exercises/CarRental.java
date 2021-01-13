// Modify fee according to rules to calculate the car rental

public class CarRental {
    public static long dailyRenterFee(int age) {
        // Driver must be 18 or older and base fee is $20 per day
        if (age < 18) {
            return -1;   // Can't rent car
        }
        // Drivers under 21 years of age pays extra fee $57 per day
        else if ((18 <= age) && (age < 21)) {
            return (20+57);
        }
        // Drivers between 21-24 years of age pays additional $20 per day
        else if ((21 <= age) && (age <= 24)) {
            return (20+20);
        }
        else {
            return 20;
        }
    }

    public static void main(String[] args) {
        // Calculate the car rental per day based on variable age
        long fee = dailyRenterFee(18);
        if (fee > 0) {
            System.out.print("Driver pays $" + fee);
        }
        else {
            System.out.print("Driver can't rent a car.");
        }
    }
}
