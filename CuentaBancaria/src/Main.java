//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco("PRODUBANCO");

        System.out.println("\n");
        //TITULAR VACIO
        try{
            CuentaBancaria v1 = new CuentaBancaria("1111","",100);
        } catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n");

        //SALDO NEGATIVO
        try{
            CuentaBancaria n1 = new CuentaBancaria("1111","Said",-1000);
        } catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n");
        //CUENTAS AGREGADAS CORRECTAMENTE
        CuentaBancaria a1 = new CuentaAhorros("1111", "Said", 0.05,1);
        CuentaBancaria a2 = new CuentaAhorros("2222", "Emily", 1500,0);

        CuentaBancaria c1 = new CuentaCorriente("3334", "Valeria", 200,1200);
        CuentaBancaria c2 = new CuentaCorriente("4444", "Camilo", 1321,4000);

        CuentaBancaria i1 = new CuentaInversion("6666", "Sonia", 1002, 0.10,1);
        CuentaBancaria i2 = new CuentaInversion("5555", "Saul", 15321, 0.08,2);

        banco.abrirCuenta(a1);
        banco.abrirCuenta(a2);
        banco.abrirCuenta(c1);
        banco.abrirCuenta(c2);
        banco.abrirCuenta(i1);
        banco.abrirCuenta(i2);
        System.out.println("Cuentas abiertas con exito");

        System.out.println("\n");

        //DEPOSITOS Y RETIROS
        try {
            a1.depositar(50);
            System.out.println("Saldo Cuenta Ahorros 1: " + a1.getSaldo());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("\n");

        try {
            a1.retirar(300); // saldo insuficiente(menor a cincuenta)
        } catch (SaldoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("\n");

        try {
            c1.depositar(80);
            System.out.println("Saldo Cuenta corriente 1: " + c1.getSaldo());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n");

        //RETIRO INVALIDO
        try {
            c1.retirar(500000000);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("\n");
        // TRANSFERENCIA EXITOSA
        System.out.println("\n===== TRANSFERENCIA =====");
        try {
            banco.transferir(a1.getNumCuenta(), c1.getNumCuenta(), 500);
            System.out.println("Transferencia exitosa!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n");
        //TRANSFERENCIA FALLIDA
        try {
            banco.transferir(a1.getNumCuenta(),a2.getNumCuenta(),-500);
        } catch (MontoInvalidoException | SaldoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n");
        //SALDO TOTAL DEL BANCO
        banco.obtenerSaldoTotal();

        //APLICAR INTERECES
        System.out.println("\n===== INTERESES =====");
        try {
            banco.aplicarInteresesAhorros();
        } catch (CuentaInactivaException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n");
        //ORDENAR POR SALDO
        banco.ordenarPorSaldo();
        System.out.println(banco);
    }
}