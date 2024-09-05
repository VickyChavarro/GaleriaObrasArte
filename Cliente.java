public class Cliente {
    private long codigoCliente;
    private long cedula;
    private String nombre;
    private String apellidos;
    private String direccionEntrega;
    private long telefono;

    public Cliente(long codigoCliente, long cedula, String nombre, String apellidos, String direccionEntrega, long telefono) {
        this.codigoCliente = codigoCliente;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccionEntrega = direccionEntrega;
        this.telefono = telefono;
    }

    public long getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(long codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return '\n' + "Codigo: " + codigoCliente +
                ", Cedula: " + cedula +
                ", Nombre: '" + nombre + '\'' +
                ", Apellidos: '" + apellidos + '\'' +
                ", Direccion de entrega: '" + direccionEntrega + '\'' +
                ", Telefono: " + telefono;
    }
}
