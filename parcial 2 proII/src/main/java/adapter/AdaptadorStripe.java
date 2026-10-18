package adapter;


public class AdaptadorStripe implements ProcesadorPago {
    private StripeUSA stripe;
    private String claveComercio = "SHOPMASTER-KEY-001";

    public AdaptadorStripe(StripeUSA stripe) {
        this.stripe = stripe;
    }

    public void cobrarEnPesos(String usuario, double montoCOP) {

        double montoUSD = montoCOP / 4000;

        String email = usuario + "@shopmaster.com";
        System.out.println("   [Adaptador] $" + (long) montoCOP + " COP -> USD $" + montoUSD);

        stripe.chargeInDollars(montoUSD, email, claveComercio);
    }
}