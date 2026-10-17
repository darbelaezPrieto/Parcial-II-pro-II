package adapter;

// Librería externa del proveedor (simulada). NO SE PUEDE MODIFICAR.
// PATRÓN ADAPTER: es la clase "Adaptee" (la que tiene la interfaz incompatible).
public class StripeUSA {

    public void chargeInDollars(double amountUSD, String customerEmail, String merchantKey) {
        System.out.println("   [StripeUSA] Charging USD $" + amountUSD
                + " to " + customerEmail + " (merchantKey: " + merchantKey + ")");
    }
}