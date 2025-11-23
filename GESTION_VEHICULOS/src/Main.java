//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Concesionaria concesionaria = new Concesionaria();
        System.out.println("\n");
        //CALCULAR IMPUESTOS CON LISTA VACIA
        try {
            System.out.println("Total de impuestos: " + concesionaria.calcularTotalImpuestos());
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        System.out.println("\n");

        //ANIO INVALIDO
        try {
            concesionaria.agregarVehiculo(new Auto("Toyota", "AUX", 1899, 120.00, 4));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("\n");

        //PRECIO NEGATIVO
        try {
            concesionaria.agregarVehiculo(new Moto("Honda","4TX",1950,-20.000,150));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("\n");

        //AGREGAR VEHICULOS CORRECTAMENTE
        try {
            Auto a1 = new Auto("Toyota", "Corolla", 2020, 15000);
            Auto a2 = new Auto("Honda", "Civic", 2018, 13000, 2);
            Camion c1 = new Camion("Volvo", "FH16", 2019, 55000, 20);
            Camion c2 = new Camion("Mercedes", "Actros", 2021, 62000, 25);
            Moto m1 = new Moto("Yamaha", "FZ", 2022, 3000, 150);
            Moto m2 = new Moto("Kawasaki", "Ninja ZX6R", 2020, 9000, 600);
            concesionaria.agregarVehiculo(a1);
            concesionaria.agregarVehiculo(a2);
            concesionaria.agregarVehiculo(c1);
            concesionaria.agregarVehiculo(c2);
            concesionaria.agregarVehiculo(m1);
            concesionaria.agregarVehiculo(m2);
            System.out.println("Vehiculos agregados con exito");
        } catch (Exception e) {
            System.out.println("Error: "+ e.getMessage());
        }
        System.out.println("\n");

        try {
            System.out.println("Total de impuestos: " + concesionaria.calcularTotalImpuestos());
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        System.out.println("\n");

        try {
            concesionaria.masCaro();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("\n");

        System.out.println("Ordenado por precio: \n");
        concesionaria.ordenarPorPrecio();
        System.out.println(concesionaria);
    }
}