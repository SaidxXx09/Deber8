public abstract class Vehiculo {
    private String marca, modelo;
    private int anio;
    private double precio;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, int anio, double precio) {
        if (marca == null || marca.equals("")){
            throw new IllegalArgumentException ("Marca no puede estar vacia");
        }
        if (modelo == null || modelo.equals("")){
            throw new IllegalArgumentException("Modelo no puede estar vacio");
        }
        if (anio < 1900 || anio > 2025){
            throw new IllegalArgumentException("Año fuerea de rango (1900/2025)");
        }
        if (precio < 0){
            throw new IllegalArgumentException("Precio menor a cero no valido");
        }
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public abstract double calcularImpuestoCirculacion();

    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anio=" + anio +
                ", precio=" + precio +
                '}';
    }
}
