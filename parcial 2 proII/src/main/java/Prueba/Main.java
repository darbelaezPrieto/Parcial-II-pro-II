package prueba;

import composite.Componente;
import composite.PaqueteCombo;
import composite.ProductoIndividual;
import facade.CompraRapidaFacade;

public class Main {

    public static void main(String[] args) {
        CompraRapidaFacade tienda = new CompraRapidaFacade();

        // ---------- CASO 1: Compra exitosa completa ----------
        System.out.println("========== CASO 1: Compra exitosa completa ==========");
        PaqueteCombo kit = new PaqueteCombo("Kit de Limpieza");
        kit.agregar(new ProductoIndividual("Spray limpiador", 25000));
        kit.agregar(new ProductoIndividual("Paño de microfibra", 15000));

        PaqueteCombo comboGamer = new PaqueteCombo("Combo Setup Gamer");
        comboGamer.agregar(new ProductoIndividual("Monitor", 800000));
        comboGamer.agregar(new ProductoIndividual("Teclado", 200000));
        comboGamer.agregar(kit); // combo dentro de otro combo

        // usuario válido, con garantía y regalo
        tienda.ejecutarCompraRapida(comboGamer, "cliente_vip", true, true, false);

        // ---------- CASO 2: Rechazo por tope de dinero ----------
        System.out.println();
        System.out.println("========== CASO 2: Rechazo por tope de dinero ==========");
        Componente servidor = new ProductoIndividual("Servidor Empresarial", 6000000);

        // solo manejo frágil
        tienda.ejecutarCompraRapida(servidor, "cliente_normal", false, false, true);

        // ---------- CASO 3: Rechazo por usuario reportado ----------
        System.out.println();
        System.out.println("========== CASO 3: Rechazo por usuario reportado ==========");
        Componente mouse = new ProductoIndividual("Mouse", 150000);

        tienda.ejecutarCompraRapida(mouse, "BLOQUEADO", false, false, false);
    }
}