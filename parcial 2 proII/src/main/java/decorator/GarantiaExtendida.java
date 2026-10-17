package decorator;

// PATRÓN DECORATOR - Decorador concreto: suma el 10% del valor actual
public class GarantiaExtendida extends ServicioAdicional {

    public GarantiaExtendida(Pedido pedido) {
        super(pedido);
    }

    public String getDescripcion() {
        return pedido.getDescripcion() + " + Garantia Extendida";
    }

    public double getCosto() {
        double actual = pedido.getCosto();
        return actual + (actual * 0.10);
    }
}