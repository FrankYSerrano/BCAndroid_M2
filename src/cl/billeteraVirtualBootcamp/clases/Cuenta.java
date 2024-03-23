package cl.billeteraVirtualBootcamp.clases;

public class Cuenta {
    /* Atributos */
    private String titular;
    private String numeroDeCuenta;
    private double saldoCLP;
    private double saldoUSD;
    private double saldoBTC;

    /* Constructor */
    public Cuenta(){
    }
    public Cuenta(String numeroDeCuentaCuenta, String titular, double saldoCLP, double saldoUSD, double saldoBTC){
        this.numeroDeCuenta = numeroDeCuentaCuenta;
        this.titular = titular;
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
    public String getNumeroDeCuenta() {
        return numeroDeCuenta;
    }
    public void setNumeroDeCuenta(String numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }
    public double getSaldoCLP() {
        return saldoCLP;
    }
    public void setSaldoCLP(double saldoCLP) {
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
    public void agregarSaldo(double saldoAAgregar){
        this.saldoCLP = this.saldoCLP + saldoAAgregar;
    }
    public boolean retirarSaldo(double saldoARetirar){
        boolean procede = false;
        if (saldoARetirar <= this.saldoCLP){
            procede = true;
            this.saldoCLP = this.saldoCLP - saldoARetirar;
        }
        return procede;
    }
    public void convierteCLPaUSD(double cantidadCLP, double tasaDeCambio){
        this.setSaldoCLP(this.getSaldoCLP()-cantidadCLP);
        this.setSaldoUSD(this.getSaldoUSD()+cantidadCLP/tasaDeCambio);
    }
    public void convierteUSDaBTC(double cantidadUSD, double tasaDeCambio){
        this.setSaldoUSD(this.getSaldoUSD()-cantidadUSD);
        this.setSaldoBTC(this.getSaldoBTC()+cantidadUSD/tasaDeCambio);
    }
    /* Metodos utilitarios */
}
