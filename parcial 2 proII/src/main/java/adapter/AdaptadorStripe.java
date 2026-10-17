package adapter;

// PATRÓN ADAPTER - Adaptador: implementa ProcesadorPago (lo que el sistema espera)
// y por dentro usa StripeUSA (lo que realmente existe), traduciendo la llamada.
public class AdaptadorStripe implements ProcesadorPago {
    private StripeUSA stripe;
    private String claveComercio = "SHOPMASTER-KEY-001";

    public AdaptadorStripe(StripeUSA stripe) {
        this.stripe = stripe;
    }

    public void cobrarEnPesos(String usuario, double montoCOP) {
        // 1. Conversión de moneda: 1 USD = 4000 COP
        double montoUSD = montoCOP / 4000;
        // 2. Convertimos el nombre de usuario en el "email" que pide Stripe
        String email = usuario + "@shopmaster.com";
        System.out.println("   [Adaptador] $" + (long) montoCOP + " COP -> USD $" + montoUSD);
        // 3. Llamamos al método en inglés de la pasarela, enviando la clave de comercio
        stripe.chargeInDollars(montoUSD, email, claveComercio);
    }
}