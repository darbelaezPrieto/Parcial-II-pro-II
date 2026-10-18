package composite;


public class ProductoIndividual implements Componente {
    private String nombre;
    private double precio;

    public ProductoIndividual(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void mostrar(String sangria) {
        System.out.println(sangria + "- " + nombre + " -> $" + (long) precio);
    }
}