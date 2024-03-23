package cl.billeteraVirtualBootcamp.clases;

public class Cliente {
    private long idCliente;
    private String nombreCliente;
    private Cuenta cuentaCliente;
    public Cliente(long idCliente, String nombreCliente, Cuenta cuentaCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.cuentaCliente = cuentaCliente;
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
    public Cuenta getCuentaCliente() {
        return cuentaCliente;
    }
    public void setCuentaCliente(Cuenta cuentaCliente) {
        this.cuentaCliente = cuentaCliente;
    }
}
