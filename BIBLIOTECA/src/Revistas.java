public class Revistas extends MaterialBiblioteca{
    private int numEdicion;
    private String mesPublicacion;
    private boolean esEspecializada;

    public Revistas(String codigo, String titulo, String autor, int anioPublicacion, boolean estaPrestado, int numEdicion, String mesPublicacion, boolean esEspecializada) {
        super(codigo, titulo, autor, anioPublicacion, estaPrestado);
        if (numEdicion < 0){
            throw new IllegalArgumentException("Numero de edicion negativo");
        }
        if(mesPublicacion ==null || mesPublicacion.isEmpty()){
            throw new IllegalArgumentException("Mes publicacion vacio");
        }
        this.numEdicion = numEdicion;
        this.mesPublicacion = mesPublicacion;
        this.esEspecializada = esEspecializada;
    }

    @Override
    public double calcularMultaPorRetraso(int diasRetraso) {
        if (diasRetraso < 0){
            throw new IllegalArgumentException("Dias de retraso negativo");
        }
        if (esEspecializada == true){
            return diasRetraso * 2.00;
        } else {
            return diasRetraso * 0.75;
        }
    }

    @Override
    public int calcularTiempoMaximoPrestamo() {
        if(esEspecializada==true){
            return  5;
        }
        else {
            return 7;
        }
    }
}
