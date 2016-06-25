import java.util.ArrayList;
import java.util.List;

public class Vertice {
	private int id;
    private String tipo;
    private String nome;
    private double latitude;
    private double longitude;
    private List<Aresta> listaAdjacencia;
    private boolean visitado;

    public Vertice(int id, String tipo, String nome, String centro, double latitude, double longitude) {
        this.id = id;
        this.tipo = tipo;
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
        this.listaAdjacencia = new ArrayList<>();
        this.visitado = false;
    }

    public Vertice(int id, String tipo, double latitude, double longitude) {
        this.id = id;
        this.tipo = tipo;
        this.latitude = latitude;
        this.longitude = longitude;
        this.listaAdjacencia = new ArrayList<>();
        this.visitado = false;
    }

    public List<Aresta> getListaAdjacencia() {
        return listaAdjacencia;
    }

    public void setListaAdjacencia(List<Aresta> listaAdjacencia) {
        this.listaAdjacencia = listaAdjacencia;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        //return nome;
    	return this.getId() + " - " +this.getTipo();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
