package decorator;

// PATRÓN DECORATOR - Decorador concreto: suma $15.000 fijos
public class EmpaqueRegalo extends ServicioAdicional {

    public EmpaqueRegalo(Pedido pedido) {
        super(pedido);
    }

    public String getDescripcion() {
        return pedido.getDescripcion() + " + Empaque de Regalo";
    }

    public double getCosto() {
        return pedido.getCosto() + 15000;
    }
}