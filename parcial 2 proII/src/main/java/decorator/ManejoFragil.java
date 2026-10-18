package decorator;


public class ManejoFragil extends ServicioAdicional {

    public ManejoFragil(Pedido pedido) {
        super(pedido);
    }

    public String getDescripcion() {
        return pedido.getDescripcion() + " + Manejo Prioritario Fragil";
    }

    public double getCosto() {
        return pedido.getCosto() + 25000;
    }
}