public class DVD extends MaterialBiblioteca{
    private int duracionMinutos;
    private String genero;
    private boolean tieneSubtitulos;

    public DVD(String codigo, String titulo, String autor, int anioPublicacion, boolean estaPrestado, int duracionMinutos, String genero, boolean tieneSubtitulos) {
        super(codigo, titulo, autor, anioPublicacion, estaPrestado);
        if(duracionMinutos<0){
            throw new IllegalArgumentException("Duracion de la pelicula negativa");
        }
        if(genero ==null || genero.isEmpty()){
            throw new IllegalArgumentException("Genero vacio");
        }
        this.duracionMinutos = duracionMinutos;
        this.genero = genero;
        this.tieneSubtitulos = tieneSubtitulos;
    }

    @Override
    public double calcularMultaPorRetraso(int diasRetraso) {
        if (diasRetraso < 0){
            throw new IllegalArgumentException("Dias de retraso negativo");
        }
        return diasRetraso * 1.50;
    }

    @Override
    public int calcularTiempoMaximoPrestamo() {
        return 3;
    }

    public double calcularMultaPorRetraso(int diasRetraso, boolean esEstreno){
        if(esEstreno == true){
            return calcularMultaPorRetraso(diasRetraso) * 2;
        }
        else return calcularMultaPorRetraso(diasRetraso);
    }
}
