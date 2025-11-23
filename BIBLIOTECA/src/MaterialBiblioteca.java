public abstract class MaterialBiblioteca {
    private String codigo, titulo, autor;
    private int anioPublicacion;
    private boolean estaPrestado;

    public MaterialBiblioteca(String codigo, String titulo, String autor, int anioPublicacion, boolean estaPrestado) {
        if (codigo == null || codigo.isEmpty()){
            throw new IllegalArgumentException("Codigo vacio");
        }
        if (titulo == null || titulo.isEmpty()){
            throw new IllegalArgumentException("Titulo vacio");
        }
        if (autor == null || autor.isEmpty()){
            throw new IllegalArgumentException("Autor vacio");
        }
        if(anioPublicacion < 1000 || anioPublicacion > 2025){
            throw new IllegalArgumentException("Año de publicacion fuera de rango");
        }
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.estaPrestado = estaPrestado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public boolean isEstaPrestado() {
        return estaPrestado;
    }

    public void setEstaPrestado(boolean estaPrestado) {
        this.estaPrestado = estaPrestado;
    }

    public abstract double calcularMultaPorRetraso(int diasRetraso);
    public abstract int calcularTiempoMaximoPrestamo();

    public void prestar(){
        if(estaPrestado== true){
            System.out.println("Material ya estaba prestado anteriormente");
        }
        else {
            estaPrestado = true;
            System.out.println("Material prestado con exito");

        }
    }

    public void devolver(){
        if (estaPrestado == false){
            System.out.println("Material no estaba prestado");
        }
        else {
            estaPrestado = false;
            System.out.println("Material devuelto con exito");
        }
    }

    @Override
    public String toString() {
        return "\nCodigo: " + codigo + "\nTitulo: " + titulo + "\nAutor: " + autor+
                "\nAño de publicacion: " + anioPublicacion + "\nPrestado: " + (estaPrestado? "Si":"No");
    }
}
