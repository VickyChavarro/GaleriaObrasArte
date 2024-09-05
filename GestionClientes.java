import java.util.ArrayList;

public class GestionClientes {
    public static void llenarListaClientes(ArrayList<Cliente> listaClientes){

        Cliente cliente1 = new Cliente(1, 1010014984, "Federico", "Garcia", "Calle 160", 311568010);
        Cliente cliente2 = new Cliente(2, 1057978129, "Luis", "Lozano", "Calle 38", 305746935);
        Cliente cliente3 = new Cliente(3, 140533923, "Victoria", "Chavarro", "Calle 146", 300244377);
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);
    }
}
