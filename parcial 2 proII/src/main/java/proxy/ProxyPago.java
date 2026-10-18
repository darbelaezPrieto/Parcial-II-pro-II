package proxy;

import adapter.AdaptadorStripe;
import adapter.ProcesadorPago;
import adapter.StripeUSA;


public class ProxyPago implements ProcesadorPago {
    private static final double LIMITE = 5000000;


    private ProcesadorPago procesadorReal = null;

    public void cobrarEnPesos(String usuario, double montoCOP) {

        if (usuario.equals("BLOQUEADO")) {
            System.out.println("   [SEGURIDAD] RECHAZADO: el usuario esta reportado como BLOQUEADO.");
            return;
        }


        if (montoCOP > LIMITE) {
            System.out.println("   [SEGURIDAD] RECHAZADO: el monto $" + (long) montoCOP
                    + " supera el limite de $" + (long) LIMITE + " COP.");
            return;
        }


        if (procesadorReal == null) {
            procesadorReal = new AdaptadorStripe(new StripeUSA());
        }
        procesadorReal.cobrarEnPesos(usuario, montoCOP);


        System.out.println("   [AUDITORÍA: Transacción aprobada para " + usuario
                + " por $" + (long) montoCOP + " COP]");
    }
}
