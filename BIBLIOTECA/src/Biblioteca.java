import javax.swing.*;
import java.util.ArrayList;
public class Biblioteca {
    private ArrayList<MaterialBiblioteca> catalogo;
    private String nombre;

    public Biblioteca(String nombre) {
        this.catalogo = new ArrayList<>();
        if(nombre == null || nombre.isEmpty()){
            throw new IllegalArgumentException("Nombre vacio");
        }
        this.nombre = nombre;
    }

    public static void validarCodigo(String codigo)throws CodigoInvalidoException {
        if (codigo == null || codigo.isEmpty()) {
            throw new CodigoInvalidoException("Código vacío");
        }
    }

    public static void generarCodigoAleatorio(String tipo){
        int numero = (int)(Math.random()*9000)+1000;
        String codigo = tipo + "-" + numero;
        System.out.println("Codigo generado: " + codigo);
    }

    public void agregarMaterial(MaterialBiblioteca m) throws CodigoInvalidoException{
        if (m == null){
            throw new NullPointerException("Material vacio");
        }
        Biblioteca.validarCodigo(m.getCodigo());
        catalogo.add(m);
    }

    public MaterialBiblioteca buscarMaterial(String codigo)throws MaterialNoDisponibleException{
        for (MaterialBiblioteca m: catalogo){
            if(m.getCodigo().equals(codigo)){
                System.out.println("Libro encontrado");
                return m;
            }
        }
        System.out.println("Libro no encontrado");
        return null;
    }
    public void prestarMaterial(String codigo)throws MaterialNoDisponibleException,MaterialNoEncontradoException{
        MaterialBiblioteca m = buscarMaterial(codigo);
        if(m.isEstaPrestado()==true){
            throw new MaterialNoDisponibleException("Material esta prestado actualmente");
        }
        m.setEstaPrestado(true);
        System.out.println("Material prestado con exito");
    }
    public void devolverMaterial(String codigo, int diasRetraso) throws MaterialNoEncontradoException{
        if (diasRetraso < 0){
            throw new IllegalArgumentException("Dias de retraso negativo");
        }
        MaterialBiblioteca m = buscarMaterial(codigo);
        m.calcularMultaPorRetraso(diasRetraso);
    }
    public void listarMaterialesDisponibles(){
        ArrayList<MaterialBiblioteca> prestados = new ArrayList<>();
        for (MaterialBiblioteca m: catalogo){
            if(m.isEstaPrestado() == false){
                prestados.add(m);
            }
        }
        System.out.println("Libros prestados: \n" + prestados);
    }

    public void ordenarPorAnio(){
        for(int i = 0; i<catalogo.size() - 1;i++){
            for (int j = 0; j < catalogo.size() - 1 - i ; j++){
                if(catalogo.get(j).getAnioPublicacion() < catalogo.get(j+1).getAnioPublicacion()){

                    MaterialBiblioteca cambiar = catalogo.get(j);
                    catalogo.set(j,catalogo.get(j+1));
                    catalogo.set(j+1,cambiar);
                }
            }
        }
    }

    @Override
    public String toString() {
        String info = "=== CATALOGO ===";
        info += "\nNombre: " + nombre +
                "\nCantidad de productos: " + catalogo.size();
        for (MaterialBiblioteca m: catalogo){
            info += " ._" + m.toString();
        }
        info +="\n========================\n";
        return info;
    }
}
