public class CuentaBancaria {
    //ATRIBUTOS PRIVADOS
    private String numCuenta, titular;
    private double saldo;

    //CONSTRUCTOR CON VALIDACIONES
    public CuentaBancaria(String numCuenta, String titular, double saldo) {
        if(numCuenta == null || numCuenta.isEmpty()){
            throw new IllegalArgumentException("Numero de cuenta no puede ser vacio");
        }
        if (titular == null || titular.isEmpty()){
            throw new IllegalArgumentException("Titular de la cuenta no puede ser vacio");
        }
        if ( saldo <= 0){
            throw new IllegalArgumentException("Saldo no puede ser menor a cero");
        }
        this.numCuenta = numCuenta;
        this.titular = titular;
        this.saldo = saldo;
    }

    //CONSTRUCTOR VACIO

    public CuentaBancaria() {
    }


    //GETTERS Y SETTERS

    public String getNumCuenta() {
        return numCuenta;
    }
    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }
    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    //METODOS REQUERIDOS
    public void depositar(double monto) {
        if (monto <= 0) {
            throw new MontoInvalidoException("Monto inválido");
        }
        saldo += monto;
    }

    public void retirar(double monto) throws SaldoInsuficienteException {
        if (monto <= 0) {
            throw new MontoInvalidoException("Monto inválido");
        }
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }
        saldo -= monto;
    }

        @Override
    public String toString() {
        return "CuentaBancaria" +
                "\nNumero de Cuenta: " + numCuenta +
                "\nTitular: " + titular +
                "\nSaldo: " + saldo;
    }

}
