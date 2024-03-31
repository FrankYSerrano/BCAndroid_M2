package cl.billeteraVirtualBootcamp.clases;

import java.util.Scanner;

public class IntercambioUSDaBTC implements TasaInterface {
    public double tasaUSDaBTC;

    public double getTasaUSDaBTC() {
        return tasaUSDaBTC;
    }

    public IntercambioUSDaBTC(double tasaUSDaBTC){
        this.tasaUSDaBTC = tasaUSDaBTC;
    }
    /**
     * Método para ajustar el valor de la tasa USD/BTC
     */
    public void ajustarTasaUSDaBTC(){
        Scanner scannerDatos = new Scanner(System.in);
        double nuevaTasaUSDaBTC;
        System.out.println("Tasa de cambio actual CLP/USD = " + this.tasaUSDaBTC);
        System.out.print("Por favor introduzca la nueva tasa USD/BTC: ");
        nuevaTasaUSDaBTC = scannerDatos.nextDouble();
        this.tasaUSDaBTC = tasaUSDaBTC;
    }

    /** Metodo para ajustar Tasa USD a BTC. Para los tests.
     * @param nuevaTasaUSDaBTC
     */
    public void ajustarTasaUSDaBTC(double nuevaTasaUSDaBTC){
        this.tasaUSDaBTC = nuevaTasaUSDaBTC;
    }

    /** Metodo que convierte la cantidad de CLPs recibidas a BTC según la tasa
     * @param cantidadUSDaBTC
     * @return
     */
        @Override
    public double convertir(double cantidadUSDaBTC) {
        return cantidadUSDaBTC / this.tasaUSDaBTC;
    }

}
