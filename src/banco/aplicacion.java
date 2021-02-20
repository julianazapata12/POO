package banco;

import dominio.CuentaBancaria;
import dominio.persona;

public class aplicacion {
    public static void main(String[] args) {
        System.out.println("hola mundo!");

        persona juliana = new persona();
        persona juanSebastian= new persona();

        CuentaBancaria micuenta = new CuentaBancaria();
        CuentaBancaria cuentaSebas= new CuentaBancaria();

        juliana.nombre = "juliana";
        micuenta.titular = juliana;
        micuenta.saldo = 316000;
        micuenta.estado="A";

        juanSebastian.nombre = "Juan Sebastian";
        cuentaSebas.titular = juanSebastian ;
        cuentaSebas.saldo = 0;
        cuentaSebas.estado="A";

        System.out.println(micuenta.consultarSaldo());
        System.out.println(cuentaSebas.consultarSaldo());

        boolean resultadoTransferencia = micuenta.transferir(216000, cuentaSebas);

        System.out.println(resultadoTransferencia);
        System.out.println(micuenta.consultarSaldo());
        System.out.println(cuentaSebas.consultarSaldo());

    }
}
