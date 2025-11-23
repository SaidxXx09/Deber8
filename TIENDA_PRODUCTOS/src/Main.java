import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws StockInsuficienteException,ProdcutoNoEncontradoException,PrecioInvalidoException{
        Inventario tienda = new Inventario("Vale Todo");
        //PRECIO NEGATIVO
        try {
            Producto n1 = new ProductoAlimenticio("LECHE_1234","Leche",-1500,5,"12/12/2025",true);
            tienda.agregarProducto(n1);
        } catch (PrecioInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            Producto v1 = new ProductoAlimenticio("","Huevo",3,5,"12/12/2025",true);
            tienda.agregarProducto(v1);
        } catch (IllegalArgumentException | PrecioInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // ELECTRONICOS
            Producto p1 = new ProductoElectronico("ELEC-1001", "Laptop", 1500, 10, "HP", 12);
            Producto p2 = new ProductoElectronico("ELEC-1002", "Smartphone", 800, 20, "Samsung", 24);
            Producto p3 = new ProductoElectronico("ELEC-1003", "Tablet", 500, 15, "Apple", 12);
            Producto p4 = new ProductoElectronico("ELEC-1004", "Auriculares", 150, 30, "Sony", 6);

            // ALIMENTICIOS
            Producto p5 = new ProductoAlimenticio("ALI-2001", "Leche", 2.5, 50, "12/12/2025", true);
            Producto p6 = new ProductoAlimenticio("ALI-2002", "Pan", 1.2, 40, "05/12/2025", false);
            Producto p7 = new ProductoAlimenticio("ALI-2003", "Queso", 5.0, 25, "20/12/2025", true);

            //ROPA
            Producto p8 = new ProductoRopa("ROP-3001", "Camiseta", 15, 30, "M", "Algodón");
            Producto p9 = new ProductoRopa("ROP-3002", "Pantalón", 25, 20, "L", "Mezclilla");
            Producto p10 = new ProductoRopa("ROP-3003", "Chaqueta", 50, 10, "XL", "Cuero");

            tienda.agregarProducto(p1);
            tienda.agregarProducto(p2);
            tienda.agregarProducto(p3);
            tienda.agregarProducto(p4);
            tienda.agregarProducto(p5);
            tienda.agregarProducto(p6);
            tienda.agregarProducto(p7);
            tienda.agregarProducto(p8);
            tienda.agregarProducto(p9);
            tienda.agregarProducto(p10);
            System.out.println(tienda);
        } catch (PrecioInvalidoException e) {
            System.out.println("Error de precio: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error de argumento: " + e.getMessage());
        }

        try {
            tienda.venderProducto("ROP-3001",6);
            System.out.println("$$ Vendido $$");
        } catch (StockInsuficienteException | ProdcutoNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            tienda.venderProducto("ROP-3002",-5);
        } catch (StockInsuficienteException | ProdcutoNoEncontradoException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            tienda.venderProducto("ELEC-1001",30);
        } catch (StockInsuficienteException | ProdcutoNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            tienda.buscarPorCodigo("HOLA");
        } catch (ProdcutoNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }
        tienda.calcularValorInventario();
        tienda.ordenarPorPrecio();

        int minimo = 5;
        ArrayList<Producto> bajosStock = tienda.listarProductosBajoStock(minimo);
        if (bajosStock.isEmpty()) {
            System.out.println("No hay productos con stock bajo.");
        } else {
            for (Producto p : bajosStock) {
                System.out.println(p);
            }
        }
    }
}