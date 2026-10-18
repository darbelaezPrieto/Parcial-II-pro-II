package facade;

import adapter.ProcesadorPago;
import composite.Componente;
import decorator.EmpaqueRegalo;
import decorator.GarantiaExtendida;
import decorator.ManejoFragil;
import decorator.Pedido;
import decorator.PedidoBase;
import proxy.ProxyPago;


public class CompraRapidaFacade {

    public void ejecutarCompraRapida(Componente producto, String usuario,
                                     boolean garantia, boolean regalo, boolean fragil) {

        System.out.println("Cliente: " + usuario);


        System.out.println("Productos:");
        producto.mostrar("  ");


        Pedido pedido = new PedidoBase(producto);
        System.out.println("Calculo:");
        System.out.println("  Subtotal productos: $" + (long) pedido.getCosto());

        if (garantia) {
            pedido = new GarantiaExtendida(pedido);
            System.out.println("  + Garantia Extendida (10%) -> $" + (long) pedido.getCosto());
        }
        if (regalo) {
            pedido = new EmpaqueRegalo(pedido);
            System.out.println("  + Empaque de Regalo ($15.000) -> $" + (long) pedido.getCosto());
        }
        if (fragil) {
            pedido = new ManejoFragil(pedido);
            System.out.println("  + Manejo Prioritario Fragil ($25.000) -> $" + (long) pedido.getCosto());
        }

        System.out.println("  Pedido: " + pedido.getDescripcion());
        System.out.println("  TOTAL A PAGAR: $" + (long) pedido.getCosto() + " COP");

        System.out.println("Cobro:");
        ProcesadorPago procesador = new ProxyPago();
        procesador.cobrarEnPesos(usuario, pedido.getCosto());
    }
}