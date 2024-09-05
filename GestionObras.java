import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class GestionObras {
    public static void llenarListaObras(ArrayList<Obra> listaObras){

        Calendar fecha1 = new GregorianCalendar(1987, Calendar.MARCH, 21);

        Calendar fecha2 = Calendar.getInstance();
        fecha2.set(Calendar.YEAR, 2003);
        fecha2.set(Calendar.MONTH, Calendar.OCTOBER);
        fecha2.set(Calendar.DAY_OF_MONTH, 14);

        Calendar fecha3 = Calendar.getInstance();
        fecha3.set(Calendar.YEAR, 1950);
        fecha3.set(Calendar.MONTH, Calendar.MARCH);
        fecha3.set(Calendar.DAY_OF_MONTH, 9);

        Obra obra1 = new Obra(1111111, "El Grito", 200000000,  "50x100");
        Obra obra2 = new Obra(1111112, "Mona Lisa", 500000000,  "80x80");
        Obra obra3 = new Obra(1111113, "El beso", 300000000,  "100x100");
        listaObras.add(obra1);
        listaObras.add(obra2);
        listaObras.add(obra3);

        obra1.setFecha(fecha1);
        obra2.setFecha(fecha2);
        obra3.setFecha(fecha3);
    }

    public static void llenarListaArtistas(ArrayList<Artista> listaArtistas){
        Artista artista1 = new Artista(19420911, "Pablo", "Picasso", 305247313);
        Artista artista2 = new Artista(46370476, "Leonardo", "DaVinci", 302491939);
        Artista artista3 = new Artista(1057978129, "Vicente", "VanGogh", 340563453);
        listaArtistas.add(artista1);
        listaArtistas.add(artista2);
        listaArtistas.add(artista3);
    }


}
