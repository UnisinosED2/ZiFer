import java.util.ArrayList;

public class Dijkstra {
	/*private Grafo grafo;
	private Vertice inicio;
	private ArrayList<Aresta> caminhoFinal;
	private ArrayList<DijkstraAux> caminhoAtual;

	public Dijkstra(Grafo grafo, Vertice inicial){
		this.grafo = grafo;
		this.inicio = inicial;
		caminhoFinal = new ArrayList<Aresta>();
		caminhoAtual = new ArrayList<DijkstraAux>();
	}
	
	public void Executar(){
		Inicializar();
		
		ArrayList<Vertice> listaAuxiliar = new ArrayList<Vertice>();
		
		while(caminhoAtual.size() > 0){
			Vertice verticeAtual = ExtrairVerticeComPesoMinimo();
			listaAuxiliar.add(verticeAtual);
			
			for(Vertice adjacente : verticeAtual.getAdjacentes()){
				
			}
		}
		
	}
	
	private void Inicializar(){
		for(Vertice atual : grafo.getVertices()){
			DijkstraAux novoItem = new DijkstraAux(atual, null, Double.POSITIVE_INFINITY);			
			caminhoAtual.add(novoItem);
		}
		
		caminhoAtual.set(caminhoAtual.indexOf(inicio), new DijkstraAux(inicio, null, 0.0) );
	}
	
	private Vertice ExtrairVerticeComPesoMinimo(){
		
		return null;
	}*/
}