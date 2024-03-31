import cl.billeteraVirtualBootcamp.clases.Cliente;
import cl.billeteraVirtualBootcamp.clases.Cuenta;
import cl.billeteraVirtualBootcamp.clases.IntercambioCLPaUSD;
import cl.billeteraVirtualBootcamp.clases.IntercambioUSDaBTC;
import cl.utilitarios.LimpiaConsola;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Menu principal de AlkeWallet 1.0
 * Actualmente es personalizada (sólo soporta 1 Cliente)
 * El cliente en su cuenta maneja 3 balances en las 3 monedas disponibles:
 * CLP, USD y BTC.
 */
public class Menu {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String seleccion;
        /** Variables globales que definirán las tasas de cambio a USD y a BTC
        */
        IntercambioCLPaUSD tasaDeCambioCLPaUSD = new IntercambioCLPaUSD(964.95);
        IntercambioUSDaBTC tasaDeCambioUSDaBTC = new IntercambioUSDaBTC(73000);

        DecimalFormat dfUSD = new DecimalFormat("#.##");
        System.out.println("**************** Alke Wallet 1.0 *************");
        /** Instancia de Cliente
        */
        Cliente cliente = new Cliente();
        /** Instancia de Cuenta
        */
        Cuenta cuenta1 = new Cuenta(cliente);
        do {
            System.out.println("************* Alke Wallet *************");
            System.out.println("* Cliente: " + cliente.getNombreCliente());
            System.out.println("*********** Tasas de Cambio ***********");
            System.out.println("* CLP/USD: " + dfUSD.format(tasaDeCambioCLPaUSD.tasaCLPaUSD) +
                    " | USD/BTC: " + dfUSD.format(tasaDeCambioUSDaBTC.tasaUSDaBTC) +" *");
            System.out.println("**************** MENU *****************");
            System.out.println("* 1 -> Consultar Datos de Cuenta      *");
            System.out.println("* 2 -> Realizar Deposito CLP          *");
            System.out.println("* 3 -> Realizar Retiro CLP            *");
            System.out.println("* 4 -> Ajustar tasa CLP/USD           *");
            System.out.println("* 5 -> Ajustar tasa USD/BTC           *");
            System.out.println("* 6 -> Convertir CLP a USD            *");
            System.out.println("* 7 -> Convertir USD a BTC            *");
            System.out.println("*                                     *");
            System.out.println("* 0 -> Salir del Sistema              *");
            System.out.println("***************************************");
            System.out.print("Ingrese su selección: ");
            seleccion = scanner.nextLine();
            if (!(seleccion.isEmpty())){
                switch (seleccion.charAt(0)) {
                    case '1' -> cuenta1.consultaCuenta();
                    case '2' -> cuenta1.agregarSaldoCLP();
                    case '3' -> cuenta1.retirarSaldoCLP();
                    case '4' -> tasaDeCambioCLPaUSD.ajustarTasaCLPaUSD();
                    case '5' -> tasaDeCambioUSDaBTC.ajustarTasaUSDaBTC();
                    case '6' -> cuenta1.convierteCLPaUSD(tasaDeCambioCLPaUSD);
                    case '7' -> cuenta1.convierteUSDaBTC(tasaDeCambioUSDaBTC);
                    case '0' -> System.out.println("Gracias por utilizar nuestro servicio!");
                    default -> {System.out.println("LA OPCION INGRESADA ES INVALIDA!");}
                }
            }else{seleccion = "x";
            }
        }while (!(seleccion.charAt(0) == '0'));
        scanner.close();
    }
}