import java.util.ArrayList;
import java.util.LinkedList;

public class BellmanFord {
	public static double INFINITY = Double.MAX_VALUE;
	public double distance[];
	public Vertice predecessor[];
	public Vertice principal;
	public LinkedList<Vertice> vertices;
		
	public BellmanFord(Grafo grafico, int numeroVertice) {
		
		this.principal =  grafico.getVertice().get(numeroVertice);
		
		this.vertices = grafico.getVertice();
		LinkedList<Aresta> edges = grafico.getaresta();
		this.distance = new double[vertices.size()];
		this.predecessor = new Vertice[vertices.size()];
		
		for (int i = 0; i < this.vertices.size(); i++) {
			this.predecessor[i] = null;
			this.distance[i] = INFINITY;
		}
		
		this.distance[findVertexIndex(this.vertices, this.principal)] = 0;
				
		for (int i = 0; i < this.vertices.size() - 1; i++) {
			for (Aresta edge : edges) {
				double disTo = this.distance[findVertexIndex(vertices, edge.getPosterior())];
				double disFrom = this.distance[findVertexIndex(vertices, edge.getAnterior())];
				if ((disFrom + edge.getDistancia()) < disTo) {
					this.distance[findVertexIndex(vertices, edge.getPosterior())] = disFrom + edge.getDistancia();
					this.predecessor[findVertexIndex(vertices, edge.getPosterior())] = edge.getAnterior();
				} else if ((disTo + edge.getDistancia()) < disFrom) {
					this.distance[findVertexIndex(vertices, edge.getAnterior())] = disTo + edge.getDistancia();
					this.predecessor[findVertexIndex(vertices, edge.getAnterior())] = edge.getPosterior();
				}
			}
		}
	}
	
	public LinkedList<Vertice> shortestPath(int destino) {
		Vertice aux;
		aux = this.vertices.get(destino);
		
		LinkedList<Vertice> listaVertices = new LinkedList<Vertice>();
		
		listaVertices.add(0, aux);
		
		int i = findVertexIndex(this.vertices, aux);
		while(this.predecessor[i].getId() != this.principal.getId()) {
			listaVertices.add(0, this.predecessor[i]);
			i = findVertexIndex(this.vertices, this.predecessor[i]);
		}
		
		listaVertices.add(0, this.principal);
		
		return listaVertices;
	}
	
	public double getDistance(int valor) {
		Vertice destino = this.vertices.get(valor);
		return this.distance[findVertexIndex(vertices, destino)];
	}
	
	private int findVertexIndex(LinkedList<Vertice> vertices, Vertice source) {	
		for (int i = 0; i < vertices.size(); i++) {
			if (vertices.get(i).getId() == source.getId()) {
				return i;
			}
		}
		return -1;
	}

}
