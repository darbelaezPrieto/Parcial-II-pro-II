package decorator;

import composite.Componente;


public class PedidoBase implements Pedido {
    private Componente contenido;

    public PedidoBase(Componente contenido) {
        this.contenido = contenido;
    }

    public String getDescripcion() {
        return contenido.getNombre();
    }

    public double getCosto() {
        return contenido.getPrecio();
    }
}