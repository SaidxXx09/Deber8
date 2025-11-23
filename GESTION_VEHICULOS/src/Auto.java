public class Auto extends Vehiculo{
    private int numPuertas;

    public Auto(int numPuertas) {
        if (numPuertas < 0){
            throw new IllegalArgumentException("Numero de puertas menor a cero invalido");
        }
        this.numPuertas = numPuertas;
    }

    public Auto(String marca, String modelo, int anio, double precio) {
        super(marca, modelo, anio, precio);
        this.numPuertas = 4;
    }

    public Auto(String marca, String modelo, int anio, double precio, int numPuertas) {
        super(marca, modelo, anio, precio);
        if (numPuertas < 0){
            throw new IllegalArgumentException("Numero de puertas menor a cero invalido");
        }
        this.numPuertas = numPuertas;
    }

    @Override
    public double calcularImpuestoCirculacion() {
        return getPrecio()*0.05;
    }

    @Override
    public String toString() {
        return  super.toString()+ "\n=== AUTO ===" + "\nPuertas: " + numPuertas + "\nImpuesto: " +calcularImpuestoCirculacion();
    }
}
