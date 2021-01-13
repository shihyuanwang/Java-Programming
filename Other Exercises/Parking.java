public class Parking {

    public static double calculateFee(float numMins) {
        // First 90 minutes free
        if (numMins <= 90) {
            return 0;
        }  // $1.25 for the next hour
        else if (numMins <= (90+60)) {
            return (0+1.25);
        }   // $1.85 each additional 30 minutes, $17.50 daily maximum
        else {
            double totalFee = 1.25 + (1.85 * Math.ceil((numMins - (90+60))/30));
            return Math.min(totalFee, 17.50);
        }
    }

    public static void main(String args[]) {
        int hours = 4;
        int minutes = 10;
        float numMins = (hours * 60) + minutes;
        double parkingFee = calculateFee(numMins);
        System.out.print("For " + hours + " hours " + minutes +" minutes,the total parking fee: $"
                + String.format("%.2f", parkingFee));

    }
}
