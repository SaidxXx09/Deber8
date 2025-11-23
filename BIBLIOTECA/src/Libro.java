public class Libro extends MaterialBiblioteca{
    private int numPaginas;
    private String editorial;
    private boolean esDigital;

    public Libro(String codigo, String titulo, String autor, int anioPublicacion, boolean estaPrestado, int numPaginas, String editorial, boolean esDigital) {
        super(codigo, titulo, autor, anioPublicacion, estaPrestado);
        if(numPaginas < 0){
            throw new IllegalArgumentException("Numero de paginas negativo");
        }
        if(editorial ==null || editorial.isEmpty()){
            throw new IllegalArgumentException("Editorial vacio");
        }
        this.numPaginas = numPaginas;
        this.editorial = editorial;
        this.esDigital = esDigital;
    }

    @Override
    public double calcularMultaPorRetraso(int diasRetraso) {
        if (diasRetraso < 0){
            throw new IllegalArgumentException("Dias de retraso negativo");
        }
        if (esDigital == true){
            return diasRetraso * 0.50;
        } else {
            return diasRetraso * 1.00;
        }
    }
    @Override
    public int calcularTiempoMaximoPrestamo() {
        if (esDigital == true){
            return 7;
        } else{
            return 15;
        }
    }
}
