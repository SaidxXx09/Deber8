public class CuentaInversion extends CuentaBancaria{
    //ATRIBUTOS
    private double montoMinimo, rendimientoAnual;
    //CONSTRUCTOR CON VALIDACIONES
    public CuentaInversion(String numCuenta, String titular, double saldo, double montoMinimo, double rendimientoAnual) {
        super(numCuenta, titular, saldo);
        if(montoMinimo <= 0){
            throw new IllegalArgumentException("Monto minimo no puede ser menor o igual a cero");
        }
        if(rendimientoAnual < 0){
            throw new IllegalArgumentException("Rendimiento actual no puede ser menor a cero");
        }
        this.montoMinimo = montoMinimo;
        this.rendimientoAnual = rendimientoAnual;
    }

    //METODOS REQUERIDOS
    @Override
    public void depositar(double monto) {
        if(monto < montoMinimo){
            throw new MontoInvalidoException("Monto minimo supera su monto requerido");
        }
        setSaldo(getSaldo() + monto);
    }

    public double calcularRendimiento(){
        return getSaldo()*(rendimientoAnual/12);
    }
    public double calcularRendimiento(int meses){
        return getSaldo() * (rendimientoAnual/12) * meses;
    }
}
