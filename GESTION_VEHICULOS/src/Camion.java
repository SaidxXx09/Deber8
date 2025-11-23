public class Camion extends Vehiculo {

    private double capacidadCarga;

    public Camion(String marca, String modelo, int anio, double precio, double capacidadCarga) {
        super(marca, modelo, anio, precio);

        if (capacidadCarga <= 0) {
            throw new IllegalArgumentException("Capacidad de carga inválida");
        }
        this.capacidadCarga = capacidadCarga;
    }


    @Override
    public double calcularImpuestoCirculacion() {
        return (getPrecio() * 0.08) + (capacidadCarga * 50);
    }

    @Override
    public String toString() {
        return  super.toString() +"\n=== CAMIÓN ==="+ "\nCarga: " + capacidadCarga + " toneladas" + "\nImpuestos: "+ calcularImpuestoCirculacion();
    }
}
