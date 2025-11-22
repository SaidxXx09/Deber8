import java.util.ArrayList;

public class Concesionaria {
    private ArrayList<Vehiculo> inventario = new ArrayList<>();

    public Concesionaria(ArrayList<Vehiculo> inventario) {
        this.inventario = inventario;
    }

    public ArrayList<Vehiculo> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<Vehiculo> inventario) {
        this.inventario = inventario;
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

}
