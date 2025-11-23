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
        o1.retirar(monto);
        d1.depositar(monto);
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
}
