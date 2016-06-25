import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {

	public void getMst(Grafo g) {
		List<Aresta> naoVisitadas = new ArrayList<>();
		naoVisitadas.addAll(g.getaresta());
		
		List<Aresta> mst = new ArrayList<>();
		List<Vertice> verticesVisitados = new ArrayList<>();

		Collections.sort(naoVisitadas);

		while (!naoVisitadas.isEmpty()) {
			Aresta remove = naoVisitadas.remove(0);

			Vertice v1 = remove.getAnterior();
			Vertice v2 = remove.getPosterior();

			if (!verticesVisitados.contains(v1) || !verticesVisitados.contains(v2)) {
				verticesVisitados.add(v1);
				verticesVisitados.add(v2);
				mst.add(remove);
			}
		}

		double dist = 0.0;
		for (Aresta aresta : mst) {
			dist += aresta.getDistancia();
		}
		System.out.println(dist / 10 + " litros de tinta");

	}

}