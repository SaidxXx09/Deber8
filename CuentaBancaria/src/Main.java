//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco("Said");

        //TITULAR VACIO
        try{
            CuentaBancaria v1 = new CuentaBancaria("1111","",100);
        } catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }

        //SALDO NEGATIVO
        try{
            CuentaBancaria n1 = new CuentaBancaria("1111","Said",-1000);
        } catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }

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

        a1.depositar(50);
        System.out.println("Saldo Cuenta Ahorros 1: " + a1.getSaldo());

        try {
            a1.retirar(300); // saldo insuficiente
        } catch (SaldoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }

        c1.depositar(80);
        System.out.println("Saldo Cuenta corriente 1: " + c1.getSaldo());


        try {
            c1.depositar(-10);
        } catch (MontoInvalidoException e) {
            System.out.println("OK (monto negativo): " + e.getMessage());
        }

        // 5. Transferencia exitosa
        System.out.println("\n===== TRANSFERENCIA =====");
        try {
            banco.transferir(a1.getNumCuenta(), c1.getNumCuenta(), 5);
            System.out.println("Transferencia exitosa!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            banco.transferir(a1.getNumCuenta(),a2.getNumCuenta(),5);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


        System.out.println("\n===== INTERESES =====");
        try {
            a2.setSaldo(0);
            banco.aplicarInteresesAhorros();
        } catch (CuentaInactivaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}