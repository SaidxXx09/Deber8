import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
public class Inventario {
    private ArrayList<Producto> productos;
    private String nombreTienda;

    public Inventario(String nombreTienda) {
        this.productos = new ArrayList<>();
        if (nombreTienda == null || nombreTienda.isEmpty()){
            throw new IllegalArgumentException("Nombre de tienda vacio");
        }
        this.nombreTienda = nombreTienda;
    }

    public static String generarCodigo(String categoria){
        int numero = (int) ((Math.random() * 9000) + 1000);
        return categoria +"-" + numero;
    }

    public void agregarProducto(Producto p){
        if (p == null){
            throw new NullPointerException("Producto nulo o vacio");
        }
        productos.add(p);
    }

    public Producto buscarPorCodigo(String codigo)throws ProdcutoNoEncontradoException{
        for (Producto p: productos){
            if(p.getCodigo().equals(codigo)){
                return p;
            }
        }
        throw new ProdcutoNoEncontradoException("Producto no encontrado");
    }

    public void venderProducto(String codigo,int cantidad) throws StockInsuficienteException, ProdcutoNoEncontradoException {
        if (cantidad < 0){
            throw new IllegalArgumentException("Cantidad negativa");
        }
        Producto p = buscarPorCodigo(codigo);
        if (p.getStock() < cantidad){
            throw new StockInsuficienteException("Producto agotado");
        }
        p.setStock(p.getStock() - cantidad);
        System.out.println("Precio total: " + p.getPrecioBase() * cantidad);
    }

    public void calcularValorInventario(){
        double suma = 0;
        if (productos.isEmpty()){
            throw new IllegalArgumentException("Lista vacia");
        }
        for (Producto p: productos){
            suma += p.calcularPrecioFinal() * p.getStock();
        }
        System.out.println("Valor total del inventario: " + suma);
    }

    public ArrayList<Producto> listarProductosBajoStock(int minimo){
        ArrayList <Producto> produ = new ArrayList<>();
        for (Producto p: productos){
            if(p.getStock() < minimo){
                produ.add(p);
            }
        }
        return produ;
    }

    public void ordenarPorPrecio(){
        for (int i =0; i<productos.size() - 1 ; i++){
            for(int j =0; j < productos.size() - 1 - i ; j++){
                if(productos.get(j).getPrecioBase() > productos.get(j+1).getPrecioBase()){
                    Producto orden = productos.get(j);
                    productos.set(j, productos.get(j+1));
                    productos.set(j+1,orden);
                }
            }
        }
        System.out.println(productos);
    }

    @Override
    public String toString() {
        String info = "===== INVENTARIO =====";
        info += "\nTienda: " + nombreTienda;
        info += "\nTotal productos: " + productos.size();
        info += "\nProductos:\n";

        for (Producto p : productos) {
            info += " ._" + p.toString() + "\n";
        }
        info += "\n======================\n";
        return info;
    }


}
