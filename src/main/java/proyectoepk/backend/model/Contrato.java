package proyectoepk.backend.model;

public class Contrato {

    private int id;
    private String nombreCliente;
    private String telefono;
    private String evento;
    private String fechaEvento;
    private double valorTotal;

    public Contrato() {
    }

    public Contrato(String nombreCliente, String telefono, String evento, String fechaEvento, double valorTotal) {
        this.nombreCliente = nombreCliente;
        this.telefono = telefono;
        this.evento = evento;
        this.fechaEvento = fechaEvento;
        this.valorTotal = valorTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(String fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
