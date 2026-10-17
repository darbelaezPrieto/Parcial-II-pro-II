package adapter;

// Contrato estándar interno de ShopMaster (la interfaz que el sistema ya conoce).
// PATRÓN ADAPTER: es la interfaz "Target". PATRÓN PROXY: es la interfaz común (Subject).
public interface ProcesadorPago {
    void cobrarEnPesos(String usuario, double montoCOP);
}