package adapter;


public class StripeUSA {

    public void chargeInDollars(double amountUSD, String customerEmail, String merchantKey) {
        System.out.println("   [StripeUSA] Charging USD $" + amountUSD
                + " to " + customerEmail + " (merchantKey: " + merchantKey + ")");
    }
}