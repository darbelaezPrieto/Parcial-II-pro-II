package decorator;

// PATRÓN DECORATOR - Decorador base: implementa Pedido y además TIENE un Pedido adentro.
public abstract class ServicioAdicional implements Pedido {
    protected Pedido pedido;

    public ServicioAdicional(Pedido pedido) {
        this.pedido = pedido;
    }
}