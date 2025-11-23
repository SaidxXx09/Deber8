//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws CodigoInvalidoException, MaterialNoDisponibleException, MaterialNoEncontradoException {
        Biblioteca bilioteca = new Biblioteca("BILIOTECAX");
        //TITULO VACIO
        System.out.println("\n");
        try {
            MaterialBiblioteca tv = new DVD("1111", "", "Said", 2025, true, 120, "Terror", false);
            bilioteca.agregarMaterial(tv);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n");
        //ANIO MENOR A 1000
        try{
            MaterialBiblioteca ai = new Revistas("1111", "Hola", "Said", 890, false, 7, "Mayo", false);
            bilioteca.agregarMaterial(ai);
        } catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n\n");
        //MATERIALES SIN ERRORES
        try {
            MaterialBiblioteca l1 = new Libro("LIB-101","El Principito","Antoine de Saint-Exupéry",1943,false,120,"Sudamericana",false);
            MaterialBiblioteca l2 = new Libro("LIB-202","Cien Años de Soledad","Gabriel García Márquez",1967,false,380,"Editorial Norma",true);
            MaterialBiblioteca r1 = new Revistas("REV-301","National Geographic","Varios",2020,false,150,"Junio",true);
            MaterialBiblioteca r2 = new Revistas("REV-450","Muy Interesante","Equipo Editorial",2019,false,87,"Octubre",false);
            MaterialBiblioteca d1 = new DVD("DVD-111","Interstellar","Christopher Nolan",2014,false,169,"Ciencia Ficción",true);
            MaterialBiblioteca d2 = new DVD("DVD-222","Matrix","Wachowski",1999,false,136,"Acción",false);
            MaterialBiblioteca l3 = new Libro("LIB-303","Crimen y Castigo","Fiódor Dostoyevski",1866,false,550,"Penguin Classics",false);
            MaterialBiblioteca r3 = new Revistas("REV-777","Science Today","Instituto Científico",2021,false,40,"Marzo",false);
            bilioteca.agregarMaterial(l1);
            bilioteca.agregarMaterial(l2);
            bilioteca.agregarMaterial(r1);
            bilioteca.agregarMaterial(r2);
            bilioteca.agregarMaterial(d1);
            bilioteca.agregarMaterial(d2);
            bilioteca.agregarMaterial(l3);
            bilioteca.agregarMaterial(r3);
            System.out.println("Libros agregados con exito");
            //MULTAS
            l1.calcularMultaPorRetraso(12);
            System.out.println("Multa: " +l1.calcularMultaPorRetraso(12));
            System.out.println("Multa: " +d1.calcularMultaPorRetraso(10));
            System.out.println("Multa: " +r2.calcularMultaPorRetraso(3));
        } catch (CodigoInvalidoException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n");
        //PRESTANDO MATERIAL
        try {
            bilioteca.prestarMaterial("LIB-101");
        } catch (MaterialNoDisponibleException | MaterialNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n");
        //MATERIAL PRESTADO ANTES SE LO VUELVE A PRESTAR(ERROR)
        try {
            bilioteca.prestarMaterial("LIB-101");
        } catch (MaterialNoDisponibleException | MaterialNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n");
        //BUSCAR MATERIAL INEXISTENTE
        try {
            bilioteca.buscarMaterial("AAAA");
        } catch (MaterialNoDisponibleException e) {
            System.out.println("Error:" + e.getMessage());
        }

        System.out.println("\n\n");
        //LISTAR MATERIALES DISPONIBLES
        bilioteca.listarMaterialesDisponibles();

        System.out.println("\n\n");
        //ORDENAR POR ANIO
        bilioteca.ordenarPorAnio();
        System.out.println("Materiales ordenados por anio: \n" + bilioteca);
    }
}