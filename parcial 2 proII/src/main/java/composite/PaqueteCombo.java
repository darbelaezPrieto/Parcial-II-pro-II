package composite;

import java.util.ArrayList;

// PATRÓN COMPOSITE - Compuesto (Composite): un combo que guarda otros Componentes
// (pueden ser productos u otros combos, sin importar cuántos niveles haya).
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

    // El precio del combo es la suma de sus hijos (cada hijo calcula el suyo)
    public double getPrecio() {
        double total = 0;
        for (int i = 0; i < hijos.size(); i++) {
            total = total + hijos.get(i).getPrecio();
        }
        return total;
    }

    // Muestra el combo y luego a cada hijo con más sangría (el árbol)
    public void mostrar(String sangria) {
        System.out.println(sangria + "[COMBO] " + nombre + " -> $" + (long) getPrecio());
        for (int i = 0; i < hijos.size(); i++) {
            hijos.get(i).mostrar(sangria + "     ");
        }
    }
}