
public class Aresta implements Comparable{

    private double distancia;
    private Vertice anterior;
    private Vertice posterior;
    private String deslocamento;
    private boolean visitado;

    public Aresta(double distancia, Vertice anterior, Vertice posterior, String deslocamento) {
        this.distancia = distancia;
        this.anterior = anterior;
        this.posterior = posterior;
        this.deslocamento = deslocamento;
        this.visitado = false;
    }
    
    public Aresta(Vertice anterior, Vertice posterior, String deslocamento) {
        this.anterior = anterior;
        this.posterior = posterior;
        this.deslocamento = deslocamento;
        this.visitado = false;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public Vertice getAnterior() {
        return anterior;
    }

    public void setAnterior(Vertice anterior) {
        this.anterior = anterior;
    }

    public Vertice getPosterior() {
        return posterior;
    }

    public void setPosterior(Vertice posterior) {
        this.posterior = posterior;
    }

    public String getDeslocamento() {
        return deslocamento;
    }

    public void setDeslocamento(String deslocamento) {
        this.deslocamento = deslocamento;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    @Override
    public int compareTo(Object o) {
        Aresta e = (Aresta) o;
        if(this.distancia > e.getDistancia()){
            return 1;
        }else if(this.distancia == e.getDistancia()){
            return 0;
        }else{
            return -1;
        }
    }

}
