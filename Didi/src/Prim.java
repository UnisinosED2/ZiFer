import java.util.ArrayList;
import java.util.List;

public class Prim {

    public List<Vertice> prim(List<Aresta> listaDeArestasDoGrafo) {
        List<Aresta> Arestas = new ArrayList<>(); 
        List<Vertice> vertices = new ArrayList<>();  

        //dist.add(G.get(0));
        Arestas.addAll(listaDeArestasDoGrafo);
        for (int i = 1; i < listaDeArestasDoGrafo.size(); i++) {
            if (Arestas.get(i).getDistancia() > listaDeArestasDoGrafo.get(i).getDistancia()) {
            	Arestas.clear();
            	listaDeArestasDoGrafo.get(i).setVisitado(false);
                Arestas.add(listaDeArestasDoGrafo.get(i));
            }
        }

        for (int i = 0; i < listaDeArestasDoGrafo.size(); i++) {
            final int next = minVertex(Arestas);

            List<Aresta> n = listaDeArestasDoGrafo.get(next).getPosterior().getListaAdjacencia();
            for (int j = 0; j < n.size(); j++) {
            	Aresta v = n.get(j);
                double d = listaDeArestasDoGrafo.get(j).getDistancia();
                if (v.getDistancia() > d && listaDeArestasDoGrafo.get(j).isVisitado() == false) {
                	listaDeArestasDoGrafo.get(j).setVisitado(true);
                    Arestas.add(listaDeArestasDoGrafo.get(j));
                    vertices.add(listaDeArestasDoGrafo.get(next).getAnterior());
                    vertices.add(listaDeArestasDoGrafo.get(next).getPosterior());
                }
            }
        }
        double dist = 0.0;
        for(Aresta desloc :Arestas){
        	dist += desloc.getDistancia();
        }
        System.out.println(dist / 10 + " litros de tinta");
        
        return vertices; 
    }

    private static int minVertex(List<Aresta> dist) {
        int y;
        if (dist.size() >= 1) {
            y = 0;
        } else {
        	Aresta x = dist.get(0);
            y = -1;   
            for (int i = 1; i < dist.size(); i++) {
                if (!dist.get(i).isVisitado() && dist.get(i).getDistancia() < x.getDistancia()) {
                    y = i;
                    x = dist.get(i);
                }
            }
        }
        return y;
    }
}