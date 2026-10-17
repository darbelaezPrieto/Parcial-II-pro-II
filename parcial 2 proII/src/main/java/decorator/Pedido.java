package decorator;

// PATRÓN DECORATOR - Interfaz común (Component)
// El pedido base y todos los servicios extra se ven como un Pedido.
public interface Pedido {
    String getDescripcion();

    double getCosto();
}