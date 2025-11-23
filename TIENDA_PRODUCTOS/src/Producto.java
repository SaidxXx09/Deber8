public abstract class Producto {
    private String codigo, nombre;
    private double precioBase;
    private int stock;

    public Producto(String codigo, String nombre, double precioBase, int stock) throws PrecioInvalidoException {
        if(codigo == null || codigo.isEmpty()){
            throw new IllegalArgumentException("Codigo vacio");
        }
        if(nombre == null || nombre.isEmpty()){
            throw new IllegalArgumentException("Nombre vacio");
        }
        if (precioBase < 0){
            throw new PrecioInvalidoException("Precio negativo");
        }
        if (stock < 0){
            throw new IllegalArgumentException("Stock negativo");
        }
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.stock = stock;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecioBase() {
        return precioBase;
    }
    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    public abstract double calcularPrecioFinal();

    @Override
    public String toString() {
        return "=== PRODUCTO ===" + "\nCodigo: " + codigo +
                "\nNombre: " + nombre + "\nPrecio: " + precioBase +
                "\nStock: " + stock;
    }
}
