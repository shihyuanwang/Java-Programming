// SHIH-YUAN WANG - Currency Exchange
/*
Given a file with the USD to <CURR> conversion rate
Convert X amount of Currency A to Currency B
User inputs are the source and destination currency symbols and the amount.
$3000 AUD = $42,641.40  MXN
*/

import java.io.FileReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Hashtable;
import java.util.Scanner;

public class CurrencyExchange {
    String sourceCurrency;
    BigDecimal amount;
    String destinationCurrency;

    public CurrencyExchange(String sourceCurrency, BigDecimal amount, String destinationCurrency) {
        this.sourceCurrency = sourceCurrency;
        this.amount = amount;
        this.destinationCurrency = destinationCurrency;
    }

    public BigDecimal ExchangeRate () {
        Hashtable <String, BigDecimal> ht_rate = new Hashtable <String, BigDecimal> ();
        try {
            String contents = "";
            Scanner in = new Scanner(new FileReader("src/forex.csv"));
            int iteration = 0;
            while (in.hasNextLine()) {
                contents = in.nextLine();
                //skip first column name line
                if(iteration == 0) {
                    iteration++;
                    continue;
                }
                //use comma as separator
                String[] curRate = contents.split(",");
                //System.out.println(curRate[0]+ " " + curRate[2]);

                //put currency and its rate into hashtable
                ht_rate.put(curRate[0], new BigDecimal(curRate[2]));
            }

        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }
        //System.out.println(ht_rate);
        //System.out.println(ht_rate.size());

        //get source currency and destination currency rate from hashtable
        BigDecimal rateS = ht_rate.get(this.sourceCurrency);
        BigDecimal rateD = ht_rate.get(this.destinationCurrency);

        //exchangeRate = destinationCurrency(rateD)/sourceCurrency(rateS)
        BigDecimal exchangeRate = rateD.divide(rateS, 10, RoundingMode.HALF_UP);
        return exchangeRate ;
    }

    public BigDecimal convertCurrency (BigDecimal exchangeRate) {
        //convert currency using calculated exchangeRate
        BigDecimal convertedAmount = this.amount.multiply(exchangeRate);
        convertedAmount = convertedAmount.setScale(2, RoundingMode.HALF_UP);
        return convertedAmount;
    }

    public static void main(String args[]) {
        String again;
        do { //prompts user for inputs
            System.out.println("Inputs the source currency symbol: ");
            Scanner scan = new Scanner(System.in);
            String sourceCurrency = scan.nextLine().toUpperCase().trim();

            System.out.println("Inputs the amount of the source currency: ");
            Scanner scan2 = new Scanner(System.in);
            BigDecimal amount = new BigDecimal(scan2.nextLine());

            System.out.println("Inputs the destination currency symbol: ");
            Scanner scan3 = new Scanner(System.in);
            String destinationCurrency = scan3.nextLine().toUpperCase().trim();


            //create new instance of CurrencyExchange class
            CurrencyExchange ce = new CurrencyExchange(sourceCurrency, amount, destinationCurrency);
            //calculate exchangeRate
            BigDecimal exchangeRate = ce.ExchangeRate();
            System.out.println("Exchange Rate: " + exchangeRate);
            //convert currency
            BigDecimal convertedAmount = ce.convertCurrency(exchangeRate);
            System.out.println("$" + amount.toString() + " " + sourceCurrency + " = $" + convertedAmount.toString() + " " + destinationCurrency);
            //ask users if they want to exchange again
            System.out.println("\nDo you want to exchange again? (y/n)");
            Scanner scan4 = new Scanner(System.in);
            again = scan4.nextLine().toLowerCase().trim();
            //if they want to exchange again, repeat the loop

        } while (again.equals("y"));
    }
}
