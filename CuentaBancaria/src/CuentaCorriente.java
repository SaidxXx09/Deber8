public class CuentaCorriente extends CuentaBancaria{
    //ATRIBUTO
    private double limiteCredito;
    //CONSTRUCTOR CON VALIDACION
    public CuentaCorriente(String numCuenta, String titular, double saldo, double limiteCredito) {
        super(numCuenta, titular, saldo);
        if (limiteCredito < 0){
            throw new IllegalArgumentException("Limite de credito menor a cero invalido");
        }
        this.limiteCredito = limiteCredito;
    }

    //METODOS REQUERIDOS
    @Override
    public void retirar(double monto) throws SaldoInsuficienteException {
        if (monto <= 0){
            throw new MontoInvalidoException("No se puede retirar monto menor o igual a cero");
        }
        if (monto > getSaldo() + limiteCredito){
            throw new SaldoInsuficienteException("Limite alcanzado");
        }
        setSaldo(getSaldo() - monto);
    }
}
