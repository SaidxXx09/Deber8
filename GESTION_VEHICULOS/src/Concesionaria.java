import java.util.ArrayList;
import java.util.Collections;

public class Concesionaria {
    private ArrayList<Vehiculo> inventario;

    public Concesionaria() {
        this.inventario  = new ArrayList<>();
    }
    public void agregarVehiculo(Vehiculo v){
        if (v == null){
            throw new NullPointerException("No se puede agregar un vehiculo vacio");
        }
        inventario.add(v);
    }
    public double calcularTotalImpuestos(){
        if (inventario.isEmpty()){
            throw new IllegalStateException("Inventario vacio");
        }
        double total = 0;
        for (Vehiculo v: inventario){
            total += v.calcularImpuestoCirculacion();
        }
        return total;
    }

    public void masCaro(){
        if (inventario.isEmpty()){
            throw new IllegalStateException("Inventario vacio");
        }
        Vehiculo mayor = inventario.get(0);
        for (Vehiculo v : inventario){
            if(v.getPrecio() > mayor.getPrecio()){
                mayor = v;
            }
        }
        System.out.println("Vehiculo mas caro: " + mayor);
    }
    public void ordenarPorPrecio(){
        Collections.sort(inventario,(a,b) -> Double.compare(a.getPrecio(), b.getPrecio()));
    }

    @Override
    public String toString() {
        String info = "\n=== CONCENSIONARIA ===";
        info += "\nCantidad de vehiculos: " + inventario.size();
        for (Vehiculo v: inventario){
             info += "\n"+ v.toString() + "\n";
        }
        return info;
    }
}
