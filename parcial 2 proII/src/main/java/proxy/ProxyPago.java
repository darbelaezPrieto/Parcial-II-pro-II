package proxy;

import adapter.AdaptadorStripe;
import adapter.ProcesadorPago;
import adapter.StripeUSA;

// PATRÓN PROXY (de protección) - Se pone en medio fingiendo ser un ProcesadorPago.
// Valida la petición ANTES de crear/usar el procesador real.
public class ProxyPago implements ProcesadorPago {
    private static final double LIMITE = 5000000;

    // Procesador real: empieza en null y solo se crea si la transacción es válida
    private ProcesadorPago procesadorReal = null;

    public void cobrarEnPesos(String usuario, double montoCOP) {
        // Control 1: usuario reportado
        if (usuario.equals("BLOQUEADO")) {
            System.out.println("   [SEGURIDAD] RECHAZADO: el usuario esta reportado como BLOQUEADO.");
            return;
        }

        // Control 2: tope de dinero
        if (montoCOP > LIMITE) {
            System.out.println("   [SEGURIDAD] RECHAZADO: el monto $" + (long) montoCOP
                    + " supera el limite de $" + (long) LIMITE + " COP.");
            return;
        }

        // Datos válidos: recién aquí se instancia el procesador real
        if (procesadorReal == null) {
            procesadorReal = new AdaptadorStripe(new StripeUSA());
        }
        procesadorReal.cobrarEnPesos(usuario, montoCOP);

        // Auditoría
        System.out.println("   [AUDITORÍA: Transacción aprobada para " + usuario
                + " por $" + (long) montoCOP + " COP]");
    }
}
