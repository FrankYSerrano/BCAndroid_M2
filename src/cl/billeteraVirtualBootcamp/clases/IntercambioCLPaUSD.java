package cl.billeteraVirtualBootcamp.clases;

import java.util.Scanner;

public class IntercambioCLPaUSD implements TasaInterface {
    public double tasaCLPaUSD;

    public double getTasaCLPaUSD() {
        return tasaCLPaUSD;
    }

    public IntercambioCLPaUSD(double tasaCLPaUSD){
        this.tasaCLPaUSD = tasaCLPaUSD;
    }
    /**
     * Método para ajustar el valor de la tasa CLP/USD
     */
    public void ajustarTasaCLPaUSD(){
        Scanner scannerDatos = new Scanner(System.in);
        double nuevaTasaCLPaUSD;
        System.out.println("Tasa de cambio actual CLP/USD = " + this.tasaCLPaUSD);
        System.out.print("Por favor introduzca la nueva tasa CLP/USD: ");
        nuevaTasaCLPaUSD = scannerDatos.nextDouble();
        this.tasaCLPaUSD = nuevaTasaCLPaUSD;
    }
    /**
     * Método para ajustar el valor de la tasa CLP/USD. Para los Tests
     */
    public void ajustarTasaCLPaUSD(int nuevaTasaCLPaUSD){
        this.tasaCLPaUSD = nuevaTasaCLPaUSD;
    }

    /** Metodo que convierte la cantidad de CLPs recibidas a USD según la tasa
     * @param cantidadCLPaUSD
     * @return
     */
    @Override
    public double convertir(double cantidadCLPaUSD) {
        return cantidadCLPaUSD / this.tasaCLPaUSD;
    }
}
