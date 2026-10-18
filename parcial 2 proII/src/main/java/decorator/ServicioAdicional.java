package decorator;


public abstract class ServicioAdicional implements Pedido {
    protected Pedido pedido;

    public ServicioAdicional(Pedido pedido) {
        this.pedido = pedido;
    }
}