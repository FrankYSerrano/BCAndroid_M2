package cl.billeteraVirtualBootcamp.clases;

import java.util.ArrayList;
import java.util.Scanner;

/** Clase Cliente
 * Atributos: idCliente (RUT)
 * nombreCliente
 *
 */
public class Cliente {
    private long idCliente;
    private String nombreCliente;

    /** Metodo Constructor de Cliente
     * Solicita los datos por pantalla
     */
    public Cliente() {
        Scanner scannerDato1 = new Scanner(System.in);
        Scanner scannerDato2 = new Scanner(System.in);
        System.out.println("Bienvenido! Vamos a proceder a crear el cliente!");
        System.out.print("Por favor Introduzca su RUT: ");
        this.idCliente = scannerDato1.nextLong();
        System.out.print("Por favor Introduzca su Nombre y Apellido: ");
        this.nombreCliente = scannerDato2.nextLine();
        System.out.println("Cliente creado!");
    }

    /** Metodo para instanciar un cliente con parámetros. Para los Tests.
     * @param idCliente
     * @param nombreCliente
     */
    public Cliente(long idCliente, String nombreCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
    }
    public long getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }
    public String getNombreCliente() {
        return nombreCliente;
    }
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
}
