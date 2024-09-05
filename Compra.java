import java.util.Calendar;

public class Compra {
    private long codigoCompra;
    private Calendar fecha;
    private boolean pagado;
    private Cliente cliente;
    private Obra obra;

    public Compra(long codigoCompra, Calendar fecha, boolean pagado) {
        this.codigoCompra = codigoCompra;
        this.fecha = fecha;
        this.pagado = pagado;
    }

    public Compra(long codigoCompra, boolean pagado) {
        this.codigoCompra = codigoCompra;
        this.pagado = pagado;
    }

    public Compra(long codigoCompra) {
        this.codigoCompra = codigoCompra;
        this.pagado = false;
    }

    public Compra(long codigoCompra, Cliente cliente, Obra obra) {
        this.codigoCompra = codigoCompra;
        this.cliente = cliente;
        this.obra = obra;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Obra getObra() {
        return obra;
    }

    public void setObra(Obra obra) {
        this.obra = obra;
    }

    public long getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(long codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    @Override
    public String toString() {
        return "Codigo de compra: " + codigoCompra +
                ", Pagado: " + pagado;
    }
}
