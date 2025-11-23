public class ProductoRopa extends Producto{
    private String talla, material;
    public ProductoRopa(String codigo, String nombre, double precioBase, int stock, String talla, String material) throws PrecioInvalidoException {
        super(codigo, nombre, precioBase, stock);
        if(talla == null || talla.isEmpty()){
            throw new IllegalArgumentException("Talla vacia");
        }
        if(material == null || material.isEmpty()){
            throw new IllegalArgumentException("Material vacio");
        }
        this.talla = talla;
        this.material = material;
    }
    @Override
    public double calcularPrecioFinal() {
        return getPrecioBase() * 1.12;
    }
}
