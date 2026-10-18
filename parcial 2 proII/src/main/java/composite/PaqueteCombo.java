package composite;

import java.util.ArrayList;


public class PaqueteCombo implements Componente {
    private String nombre;
    private ArrayList<Componente> hijos = new ArrayList<Componente>();

    public PaqueteCombo(String nombre) {
        this.nombre = nombre;
    }

    public void agregar(Componente c) {
        hijos.add(c);
    }

    public String getNombre() {
        return nombre;
    }


    public double getPrecio() {
        double total = 0;
        for (int i = 0; i < hijos.size(); i++) {
            total = total + hijos.get(i).getPrecio();
        }
        return total;
    }


    public void mostrar(String sangria) {
        System.out.println(sangria + "[COMBO] " + nombre + " -> $" + (long) getPrecio());
        for (int i = 0; i < hijos.size(); i++) {
            hijos.get(i).mostrar(sangria + "     ");
        }
    }
}