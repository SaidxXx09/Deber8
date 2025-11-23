public class ProductoElectronico extends Producto{
    private String marca;
    private int garantiaMeses;

    public ProductoElectronico(String codigo, String nombre, double precioBase, int stock, String marca, int garantiaMeses) throws PrecioInvalidoException {
        super(codigo, nombre, precioBase, stock);
        if ( marca == null || marca.isEmpty()){
            throw new IllegalArgumentException("Marca vacia");
        }
        if(garantiaMeses < 0){
            throw new IllegalArgumentException("Garantia de meses negativa");
        }
        this.marca = marca;
        this.garantiaMeses = garantiaMeses;
    }
    @Override
    public double calcularPrecioFinal() {
        return getPrecioBase() * 1.12;
    }

    public double aplicarGarantia(){
        return garantiaMeses = 12;
    }

    public double aplicarGarantia(int mesesExtras){
        if(mesesExtras > 0){
            return garantiaMeses + mesesExtras;
        }
        return garantiaMeses;
    }
}
