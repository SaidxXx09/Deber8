public class CuentaAhorros extends CuentaBancaria{
    //ATRIBUTO
    private double tasaInteres;

    //CONSTRUCTOR CON VALIDACION
    public CuentaAhorros(String numCuenta, String titular, double saldo, double tasaInteres) {
        super(numCuenta, titular, saldo);
        if (tasaInteres < 0 || tasaInteres > 1){
            throw new IllegalArgumentException("Tasa de intereses valida entre cero y uno");
        }
        this.tasaInteres = tasaInteres;
    }

    //METODOS REQUERIDOS
    @Override
    public void retirar(double monto) throws SaldoInsuficienteException {
        if (monto <= 0){
            throw new MontoInvalidoException("No se puede retirar monto menor a cero");
        }
        if (getSaldo() - monto < 50){
            throw new SaldoInsuficienteException("Saldo menor a cincuenta invalido");
        }
        setSaldo(getSaldo()-monto);
    }

    public void aplicarIntereses() {
        double saldo = getSaldo() + (getSaldo() * tasaInteres);
        setSaldo(saldo);
    }
}
