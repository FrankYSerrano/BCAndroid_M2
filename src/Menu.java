import cl.billeteraVirtualBootcamp.clases.Cuenta;
import cl.utilitarios.LimpiaConsola;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String seleccion;
        double tasaCLPaUSD = 964.95;
        double tasaUSDaBTC = 71500.00;
        DecimalFormat dfUSD = new DecimalFormat("#.##");

        Cuenta cuenta1 = new Cuenta();

        do {
            System.out.println("************* Alke Wallet *************");
            System.out.println("*********** Tasas de Cambio ***********");
            System.out.println("* CLP/USD: " + dfUSD.format(tasaCLPaUSD) + " | USD/BTC: " + dfUSD.format(tasaUSDaBTC) +" *");
            System.out.println("**************** MENU *****************");
            System.out.println("* 1 -> Crear Cuenta                   *");
            System.out.println("* 2 -> Consultar Datos de Cuenta      *");
            System.out.println("* 3 -> Realizar Deposito CLP          *");
            System.out.println("* 4 -> Realizar Retiro CLP            *");
            System.out.println("* 5 -> Ajustar tasas de cambio        *");
            System.out.println("* 6 -> Convertir CLP a USD            *");
            System.out.println("* 7 -> Convertir USD a BTC            *");
            System.out.println("*                                     *");
            System.out.println("* 0 -> Salir del Sistema              *");
            System.out.println("***************************************");
            System.out.print("Ingrese su selección: ");
            seleccion = scanner.nextLine();
            if (!(seleccion.isEmpty())){
                switch (seleccion.charAt(0)) {
                    case '1' -> creaCuenta(cuenta1);
                    case '2' -> despliegaDatosDeCuenta(cuenta1);
                    case '3' -> realizarDeposito(cuenta1);
                    case '4' -> realizarRetiro(cuenta1);
                    case '5' -> {
                        tasaCLPaUSD = ajustarTasaCLPaUSD(tasaCLPaUSD);
                        tasaUSDaBTC = ajustarTasaUSDaBTC(tasaUSDaBTC);
                    }
                    case '6' -> convertirCLPaUSD(cuenta1, tasaCLPaUSD);
                    case '7' -> convertirUSDaBTC(cuenta1, tasaUSDaBTC);
                    case '0' -> System.out.println("Gracias por utilizar nuestro servicio!");
                    default -> {
                        System.out.println("LA OPCION INGRESADA ES INVALIDA!");
                        System.out.println("limpiar pantalla!");
// quiero limpiar la consola luego de 1 segundo
                    }
                }
            }else{
                seleccion = "x";
            }
        }while (!(seleccion.charAt(0) == '0'));
        scanner.close();
    }
    public static void creaCuenta(Cuenta cuentaX){
        Scanner scannerDatos = new Scanner(System.in);
        String titular;
        String identificadorDeCuenta;
        double saldoCLP;
        double saldoUSD;
        double saldoBTC;

        System.out.println("Por favor introduzca los siguientes datos!");
        System.out.print("Nombre del Titular: ");
        titular = scannerDatos.nextLine();
        System.out.print("Identificador de Cuenta (RUT): ");
        identificadorDeCuenta = scannerDatos.nextLine();
        System.out.print("Saldo CLP: ");
        saldoCLP = scannerDatos.nextDouble();
        System.out.print("Saldo USD: ");
        saldoUSD = scannerDatos.nextDouble();
        System.out.print("Saldo BTC: ");
        saldoBTC = scannerDatos.nextDouble();

        cuentaX.setTitular(titular);
        cuentaX.setNumeroDeCuenta(identificadorDeCuenta);
        cuentaX.setSaldoCLP(saldoCLP);
        cuentaX.setSaldoUSD(saldoUSD);
        cuentaX.setSaldoBTC(saldoBTC);

//        scannerDatos.close();
    }
    public static void despliegaDatosDeCuenta(Cuenta cuentaX){
        DecimalFormat df8D = new DecimalFormat("#.########");
        DecimalFormat df2D = new DecimalFormat("#.##");

        System.out.print("Nombre: " + cuentaX.getTitular());
        System.out.println("  ||  Cuenta: " + cuentaX.getNumeroDeCuenta());
        System.out.println("Saldo CLP: " + cuentaX.getSaldoCLP());
        System.out.println("Saldo USD: " + df2D.format(cuentaX.getSaldoUSD()));
        System.out.println("Saldo BTC: " + df8D.format(cuentaX.getSaldoBTC()));
    }
    public static void realizarDeposito(Cuenta cuentaX){
        Scanner scannerDatos = new Scanner(System.in);
        double saldoCLP;

        System.out.print("Por favor introduzca el monto en CLP a depositar: ");
        saldoCLP = scannerDatos.nextDouble();
        cuentaX.agregarSaldo(saldoCLP);
        System.out.println("Su nuevo saldo de CLP es: " + cuentaX.getSaldoCLP());
    }
    public static void realizarRetiro(Cuenta cuentaX){
        Scanner scannerDatos = new Scanner(System.in);
        double saldoARetirarCLP;
        System.out.print("Por favor introduzca el monto en CLP a retirar: ");
        saldoARetirarCLP = scannerDatos.nextDouble();
        if (cuentaX.retirarSaldo(saldoARetirarCLP)){
            System.out.println("Su nuevo saldo de CLP es: " + cuentaX.getSaldoCLP());
        } else{
            System.out.println("El monto supera su saldo en cuenta!");
        }
    }

    public static double ajustarTasaCLPaUSD(double tasaCLPaUSD){
        Scanner scannerDatos = new Scanner(System.in);
        double nuevaTasaCLPaUSD;
        System.out.println("Tasa de cambio actual CLP/USD = " + tasaCLPaUSD);
        System.out.print("Por favor introduzca la nueva tasa CLP/USD: ");
        nuevaTasaCLPaUSD = scannerDatos.nextDouble();
        return nuevaTasaCLPaUSD;
    }
    public static double ajustarTasaUSDaBTC(double tasaUSDaBTC){
        Scanner scannerDatos = new Scanner(System.in);
        double nuevaTasaUSDaBTC;
        System.out.println("Tasa de cambio actual CLP/USD = " + tasaUSDaBTC);
        System.out.print("Por favor introduzca la nueva tasa CLP/USD: ");
        nuevaTasaUSDaBTC = scannerDatos.nextDouble();
        return nuevaTasaUSDaBTC;
    }
    public static void convertirCLPaUSD(Cuenta cuentaX,
                                        double tasaCLPaUSD){
        Scanner scannerDatos = new Scanner(System.in);
        double cantidadCLPaUSD;
        DecimalFormat df2D = new DecimalFormat("#.##");

        System.out.println("Su saldo de CLP es: " + cuentaX.getSaldoCLP());
        System.out.println("Tasa de cambio actual: " + tasaCLPaUSD);
        System.out.print("Indique cuantos CLP desea convertir a USD: ");
        cantidadCLPaUSD = scannerDatos.nextDouble();
        if (cantidadCLPaUSD <= cuentaX.getSaldoCLP()){
            cuentaX.convierteCLPaUSD(cantidadCLPaUSD, tasaCLPaUSD);
            System.out.println("Su nuevo saldo en CLP es: " + cuentaX.getSaldoCLP());
            System.out.println("Su nuevo saldo en USD es: " + df2D.format(cuentaX.getSaldoUSD()));
        }else{
            System.out.println("El monto ingresado excede su saldo en CLP!");
        }
    }
    public static void convertirUSDaBTC(Cuenta cuentaX,
                                        double tasaUSDaBTC){
        Scanner scannerDatos = new Scanner(System.in);
        double cantidadUSDaBTC;
        DecimalFormat df8D = new DecimalFormat("#.########");
        DecimalFormat df2D = new DecimalFormat("#.##");

        System.out.println("Su saldo de USD es: " + cuentaX.getSaldoUSD());
        System.out.println("Tasa de cambio actual: " + tasaUSDaBTC);
        System.out.print("Indique cuantos USD desea convertir a BTC: ");
        cantidadUSDaBTC = scannerDatos.nextDouble();
        if (cantidadUSDaBTC <= cuentaX.getSaldoUSD()){
            cuentaX.convierteUSDaBTC(cantidadUSDaBTC, tasaUSDaBTC);
            System.out.println("Su nuevo saldo en USD es: " + df2D.format(cuentaX.getSaldoUSD()));
            System.out.println("Su nuevo saldo en BTC es: " + df8D.format(cuentaX.getSaldoBTC()));
        }else{
            System.out.println("El monto ingresado excede su saldo en USD!");
        }
    }
}
