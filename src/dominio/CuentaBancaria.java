package dominio;

import java.util.Date;

public class CuentaBancaria {
    public  banco banco;
    public String tipo; // si es ahorros o corriente
    public persona titular;
    public String numero;
    public double saldo;
    public Date  fechaApertura;
    public String contraseña;
    public String estado;

    public String consultarSaldo(){
        return  "hola" + titular.nombre +", su saldo es:" + this.saldo;
    }

    public boolean retirar(double valorARetirar){
        if(valorARetirar <= this.saldo && this.estado.equals("A")){
        this.saldo = this.saldo - valorARetirar;
        return true;
    }else{
            System.out.println("El valor a retirar es superior al saldo actual");
        return false;
        }
    }
    public boolean consignar(double valorAConsignar){
        if(valorAConsignar > 0 && this.estado.equals("A")){
        this.saldo += valorAConsignar;
        return true;
    }else{
        return false;
        }
    }

    public boolean transferir(double valorATransferir, CuentaBancaria cuentaDestino){
        boolean procesoRetiro = this.retirar(valorATransferir);

        if (procesoRetiro== true){
        boolean procesoConsignacion = cuentaDestino.consignar(valorATransferir);
        boolean procesoTransferencia = procesoRetiro && procesoConsignacion;

        return procesoTransferencia;
        }else{
            return false;
        }
        //return this.retirar(valorATransferir) && cuentaDestino.consignar(valorATransferir);

    }
}
