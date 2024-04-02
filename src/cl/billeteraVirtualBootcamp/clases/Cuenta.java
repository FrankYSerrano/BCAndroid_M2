package cl.billeteraVirtualBootcamp.clases;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Clase Cuenta que tiene un número de cuenta y almacena los saldos
 * en las diferentes monedas que aloja la cuenta: CLP, USD y BTC
 */
public class Cuenta {
    /* Atributos */
    private String titular;
    private long numeroDeCuenta;
    private int saldoCLP;
    private double saldoUSD;
    private double saldoBTC;

    /* Constructor */
    /**
     * Constructor de clase: Solicita y asigna los atributos al instanciar
     */
    public Cuenta(Cliente cliente){
        Scanner scannerDatos = new Scanner(System.in);
        System.out.println("* Procedamos a crear su cuenta   *");
        System.out.println("* Por favor introduzca los siguientes datos: *");
        this.titular = cliente.getNombreCliente();
        this.numeroDeCuenta = cliente.getIdCliente();
        System.out.print("* Saldo de apertura en CLP: ");
        this.saldoCLP = scannerDatos.nextInt();
        System.out.print("* Saldo de apertura en USD: ");
        this.saldoUSD = scannerDatos.nextDouble();
        System.out.print("* Saldo de apertura en BTC: ");
        this.saldoBTC = scannerDatos.nextDouble();
        System.out.println("* Cuenta creada! Bienvenido!                 *");
    }

    /** Metodo para instanciar una cuenta con parámetros. Para los Tests.
     * @param titular
     * @param numeroDeCuenta
     * @param saldoCLP
     * @param saldoUSD
     * @param saldoBTC
     */
    public Cuenta(String titular, long numeroDeCuenta, int saldoCLP, double saldoUSD, double saldoBTC) {
        this.titular = titular;
        this.numeroDeCuenta = numeroDeCuenta;
        this.saldoCLP = saldoCLP;
        this.saldoUSD = saldoUSD;
        this.saldoBTC = saldoBTC;
    }

    /* Getters y Setters */
    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }
    public long getNumeroDeCuenta() {
        return this.numeroDeCuenta;
    }
    public void setNumeroDeCuenta(long numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }
    public int getSaldoCLP() {
        return saldoCLP;
    }
    public void setSaldoCLP(int saldoCLP) {
        this.saldoCLP = saldoCLP;
    }
    public double getSaldoUSD() {
        return saldoUSD;
    }
    public void setSaldoUSD(double saldoUSD) {
        this.saldoUSD = saldoUSD;
    }
    public double getSaldoBTC() {
        return saldoBTC;
    }
    public void setSaldoBTC(double saldoBTC) {
        this.saldoBTC = saldoBTC;
    }

    /* Metodos de Acceso */
    /* Metodos de Comportamiento */

    /**
     * Método para desplegar toda la información de la cuenta por consola
     */
    public void consultaCuenta(){
        DecimalFormat df8D = new DecimalFormat("#.########");
        DecimalFormat df2D = new DecimalFormat("#.##");
        System.out.print("Nombre: " + this.getTitular());
        System.out.println("  ||  Cuenta: " + this.getNumeroDeCuenta());
        System.out.println("Saldo CLP: " + this.getSaldoCLP());
        System.out.println("Saldo USD: " + df2D.format(this.getSaldoUSD()));
        System.out.println("Saldo BTC: " + df8D.format(this.getSaldoBTC()));
    }
    /**
     * Método que permite incrementar el saldo en CLP de la cuenta
     */
    public void agregarSaldoCLP(){
        Scanner scannerDatos = new Scanner(System.in);
        int saldoCLP;
        System.out.print("Por favor introduzca el monto en CLP a depositar: ");
        saldoCLP = scannerDatos.nextInt();
        this.saldoCLP = this.saldoCLP + saldoCLP;
        System.out.println("Su nuevo saldo de CLP es: " + this.getSaldoCLP());
    }

    /** Método que permite incrementar el saldo en CLP de la cuenta. Para los Tests
     * @param saldoCLP
     * @return
     */
    public int agregarSaldoCLP (int saldoCLP){
        return this.saldoCLP + saldoCLP;
    }
    /**
     * Método para retirar CLPs de la cuenta
     */
    public void retirarSaldoCLP(){
        Scanner scannerDatos = new Scanner(System.in);
        int saldoARetirarCLP;
        System.out.print("Por favor introduzca el monto en CLP a retirar: ");
        saldoARetirarCLP = scannerDatos.nextInt();
        if (saldoARetirarCLP <= this.saldoCLP){
            this.saldoCLP = this.saldoCLP - saldoARetirarCLP;
            System.out.println("Operación EXITOSA!");
            System.out.println(" Su nuevo saldo de CLP es: " + this.getSaldoCLP());
        }else{
            System.out.println("Operación FALLIDA! El monto supera su saldo en cuenta!");
        }
    }

    /** Método para retirar CLPs de la cuenta por parámetro. Para los tests
     * @param saldoCLP
     * @return
     */
    public int retirarSaldoCLP(int saldoCLP){
        return this.saldoCLP - saldoCLP;
    }
    /**
     * Método que permite convertir CLP a USD
     * @param tasaCLPaUSD variable Global a la que se realizará el cambio.
     */
    public void convierteCLPaUSD(IntercambioCLPaUSD tasaCLPaUSD){
        Scanner scannerDatos = new Scanner(System.in);
        int cantidadCLPaUSD;
        DecimalFormat df2D = new DecimalFormat("#.##");
        System.out.println("Su saldo de CLP es: " + this.getSaldoCLP());
        System.out.println("Tasa de cambio actual: " + tasaCLPaUSD);
        System.out.print("Indique cuantos CLP desea convertir a USD: ");
        cantidadCLPaUSD = scannerDatos.nextInt();
        if (cantidadCLPaUSD <= this.getSaldoCLP()){
            this.setSaldoCLP(this.getSaldoCLP()- cantidadCLPaUSD);
            this.setSaldoUSD(this.getSaldoUSD() + tasaCLPaUSD.convertir(cantidadCLPaUSD));
            System.out.println("Operación EXITOSA!");
            System.out.println("Su nuevo saldo en CLP es: " + this.getSaldoCLP());
            System.out.println("Su nuevo saldo en USD es: " + df2D.format(this.getSaldoUSD()));
        }else{
            System.out.println("Operación FALLIDA! El monto ingresado excede su saldo en CLP!");
        }
    }
    /**
     * Método que permite convertir USD a BTC
     * @param tasaDeCambio variable Global a la que se realizará el cambio.
     */
    public void convierteUSDaBTC(IntercambioUSDaBTC tasaDeCambio){
        Scanner scannerDatos = new Scanner(System.in);
        double cantidadUSDaBTC;
        DecimalFormat df8D = new DecimalFormat("#.########");
        DecimalFormat df2D = new DecimalFormat("#.##");
        System.out.println("Su saldo de USD es: " + this.getSaldoUSD());
        System.out.println("Tasa de cambio actual: " + tasaDeCambio);
        System.out.print("Indique cuantos USD desea convertir a BTC: ");
        cantidadUSDaBTC = scannerDatos.nextDouble();
        if (cantidadUSDaBTC <= this.getSaldoUSD()){
            this.setSaldoUSD(this.getSaldoUSD() - cantidadUSDaBTC);
            this.setSaldoBTC(this.getSaldoBTC() + tasaDeCambio.convertir(cantidadUSDaBTC));
            System.out.println("Operación EXITOSA!");
            System.out.println("Su nuevo saldo en USD es: " + df2D.format(this.getSaldoUSD()));
            System.out.println("Su nuevo saldo en BTC es: " + df8D.format(this.getSaldoBTC()));
        }else{
            System.out.println("El monto ingresado excede su saldo en USD!");
        }
    }
    /* Metodos utilitarios */
}