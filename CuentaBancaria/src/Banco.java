import java.util.ArrayList;
public class Banco {
    private ArrayList<CuentaBancaria> cuentas;
    private String nombre;
    public Banco(String nombre) {
        if (nombre.isEmpty() || nombre == null){
            throw new IllegalArgumentException("Nombre vacio");
        }
        this.nombre = nombre;
        this.cuentas = new ArrayList<>();
    }

    public static String generarNumeroCuenta(){
        int numero = (int) ((Math.random() * 900000000) +100000000);
        return String.valueOf(numero);
    }

    public void abrirCuenta(CuentaBancaria cuenta){
        if (cuentas == null){
            throw new NullPointerException("Lista de cuentas vacia");
        }
        cuentas.add(cuenta);
    }

    public CuentaBancaria buscar(String n){
        for (CuentaBancaria c: cuentas){
            if(c.getNumCuenta().equals(n)){
                return c;
            }
        }
        return null;
    }

    public void transferir(String origen, String destino, double monto) throws SaldoInsuficienteException{
        if(monto <= 0){
            throw new MontoInvalidoException("Monto invalido para transferir");
        }
        CuentaBancaria o1 = buscar(origen);
        CuentaBancaria d1 = buscar(destino);
        if(o1 == null || d1 ==null){
            throw new IllegalArgumentException("Cuentas no han sido encontradas");
        }
        o1.depositar(monto);
        d1.retirar(monto);
    }

    public void aplicarInteresesAhorros(){
        for (CuentaBancaria c: cuentas){
            if( c instanceof CuentaAhorros){
                if (c.getSaldo() == 0){
                    throw new CuentaInactivaException("Su cuenta esta inactiva");
                }
                ((CuentaAhorros) c).aplicarIntereses();
            }
        }
    }

    public void obtenerSaldoTotal(){
        double saldoTotal = 0.0;
        for(CuentaBancaria c: cuentas){
            if(c.getSaldo() == 0){
                throw new CuentaInactivaException("Cuentas inactivas");
            }
            saldoTotal += c.getSaldo();
        }
        System.out.println("Saldo total: " + saldoTotal);
    }

    public void ordenarPorSaldo(){
        int n = cuentas.size();
        for(int i = 0; i< n -1; i++){
            for(int j = 0; j<n-1-i;j++){
                if(cuentas.get(j).getSaldo() > cuentas.get(j+1).getSaldo()){

                    CuentaBancaria orden = cuentas.get(j);
                    cuentas.set(j,cuentas.get(j+1));
                    cuentas.set(j+1,orden);
                }
            }
        }
    }

    @Override
    public String toString() {
        String info ="=== BANCO ===" + "\nNombre: " + nombre +
                "\nTotal de cuentas: " + cuentas.size();
        for (CuentaBancaria c: cuentas){
            info += "\n -" + c.toString();
        }
        return info;
    }
}
