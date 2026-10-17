package decorator;

import composite.Componente;

// PATRÓN DECORATOR - Componente concreto: el pedido sin ningún extra.
// Su costo viene del producto o combo (Composite) que contiene.
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