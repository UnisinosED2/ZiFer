import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Grafo {

	private LinkedList<Vertice> vertice;
	private LinkedList<Aresta> aresta;
	
	public Grafo() {
		this.vertice = new LinkedList<>();
		this.aresta = new LinkedList<>();
	}
	
	public List<Vertice> endVertices(Grafo f, Aresta aresta){
		for(Aresta arestaCorreta : f.getaresta()){
			if(arestaCorreta.getPosterior().equals(aresta.getPosterior()) &&
					arestaCorreta.getAnterior().equals(aresta.getAnterior())){
				List<Vertice> retorno = new ArrayList<Vertice>();
				retorno.add(arestaCorreta.getAnterior());
				retorno.add(arestaCorreta.getPosterior());
				return retorno;
			}
		}
		return null;
	}
	
	public Vertice opposite(Grafo f, Vertice vertice ,Aresta aresta){
		for(Aresta ArestaFor : f.aresta){
			if(ArestaFor.getPosterior().getId() == vertice.getId()){
				return ArestaFor.getAnterior();
			}else if(ArestaFor.getAnterior().getId() == vertice.getId()){
				return ArestaFor.getPosterior();
			}
		}
		return null;
	}
	
	public boolean areAdjacent(Grafo f, Vertice verticeum ,Vertice verticedois){
		for(Vertice verticeFor : f.vertice){
			if(verticeFor.getId() == verticeum.getId()){
				for(Aresta arestaFor : verticeum.getListaAdjacencia()){
					if(arestaFor.getAnterior().getId() == verticedois.getId()){
						return true;
					}else if(arestaFor.getPosterior().getId() == verticedois.getId()){
						return true;
					}
				}
				return false;
			}else if(verticeFor.getId() == verticedois.getId()){
				for(Aresta arestaFor : verticedois.getListaAdjacencia()){
					if(arestaFor.getAnterior().getId() == verticeum.getId()){
						return true;
					}else if(arestaFor.getPosterior().getId() == verticeum.getId()){
						return true;
					}
				}
				return false;
			}
		}
		return false;
	}
	
	public void replaceEdge(Grafo f, Aresta substituida ,Aresta nova){
		for(Aresta arestaFor : f.aresta){
			if((arestaFor.getAnterior().getId() == substituida.getAnterior().getId()
					&& arestaFor.getPosterior().getId() == substituida.getPosterior().getId())
					|| (arestaFor.getAnterior().getId() == substituida.getPosterior().getId()
							&& arestaFor.getPosterior().getId() == substituida.getAnterior().getId())){
				arestaFor = nova;
			}
		}
	}
	
	public void replaceVertex(Grafo f, Vertice substituida ,Vertice novo){
		for(Vertice verticeFor : f.vertice){
			if(verticeFor.getId() == substituida.getId()){
				verticeFor = novo;
			}
		}
	}
	
	public Vertice insertVertex(Grafo f, Vertice vertice){
		f.vertice.add(vertice);
		return vertice;
	}
	
	public Aresta insertEdge(Grafo f,Vertice v, Vertice w, Aresta o){
		Aresta nova = new Aresta(v, w, o.getDeslocamento());
		f.aresta.add(nova);
		return nova;
	}
	
	public Vertice removeVertex(Grafo f,Vertice v){
		f.vertice.remove(v);
		return v;
	}
	
	public Aresta removeEdge(Grafo f,Aresta v){
		f.aresta.remove(v);
		return v;
	}
	
	public Aresta edgeValue(Grafo f, Aresta aresta) {
		 for(Aresta arestaFor : f.aresta){
			 if(arestaFor.getAnterior().getId() == aresta.getAnterior().getId() &&
					 arestaFor.getPosterior().getId() == aresta.getPosterior().getId()){
				 return arestaFor;
			 }
		 }
		 return null;
    }
	

	public Vertice vertexValue(Grafo f,int valorId){
		for(Vertice verticeFor : f.vertice){
			if(verticeFor.getId() == valorId){
				return verticeFor;
			}
		}
		return null;
	}
	
	/*public Vertice opposite(Grafo f, Vertice vertice ,Aresta aresta){
		Aresta menor = null;
		
		for(Vertice verticeFor : f.vertice){
			if(verticeFor.getId() == vertice.getId()){
				for(Aresta arestaFor : verticeFor.getListaAdjacencia()){
					
					if(arestaFor.getAnterior().getId() == aresta.getAnterior().getId()
							&& arestaFor.getPosterior().getId() == aresta.getPosterior().getId()){
						if(arestaFor.getPosterior().getId() == vertice.getId()){
							return arestaFor.getPosterior();
						}else if(arestaFor.getAnterior().getId() == vertice.getId()){
							return arestaFor.getAnterior();
						}
					}
					if(menor == null || arestaFor.getDistancia() < menor.getDistancia()
							&& !arestaFor.isVisitado()){
						menor = arestaFor;
						menor.setVisitado(true);
					}
				}
			}
			
			if(menor.getPosterior().getId() == vertice.getId()){
				opposite(f, menor.getPosterior(), menor);
			}else if(menor.getAnterior().getId() == vertice.getId()){
				opposite(f, menor.getAnterior(), menor);
			}
			opposite(f, menor.get, menor);
		}
		
		return null;
	}*/

	public int insereVertice(Vertice v) {
		if (vertice.contains(v)) {
			return this.vertice.indexOf(v);
		} else {
			this.vertice.add(v);
			return vertice.indexOf(v);
		}
	}

	public int insereAresta(Vertice v, Vertice w, String deslocamento, double distancia) {
		Aresta e = new Aresta(distancia, v, w, deslocamento);
		for (int i = 0; i < aresta.size(); i++) {
			if (aresta.get(i).getPosterior() == v && aresta.get(i).getAnterior() == w) {
				return i;
			}
		}
		this.aresta.add(e);
		this.vertice.get(this.vertice.indexOf(v)).getListaAdjacencia().add(e);
		this.vertice.get(this.vertice.indexOf(w)).getListaAdjacencia().add(e);
		return aresta.indexOf(e);
	}

	public Vertice getVerticeByCoordinates(double lat, double longi) {
		for (Vertice Vertice1 : vertice) {
			if (Vertice1.getLatitude() == lat && Vertice1.getLatitude() == longi) {
				return Vertice1;
			}
		}
		return null;
	}

	public Aresta arestaValue(int index) {
		return this.aresta.get(index);
	}

	public Vertice verticeValue(int index) {
		for (Vertice v : vertice) {
			if (v.getId() == index) {
				return v;
			}
		}
		return null;
	}

	/* fim do bloco das dúvidas */
	public LinkedList<Vertice> getVertice() {
		return vertice;
	}

	public void setVertice(LinkedList<Vertice> vertice) {
		this.vertice = vertice;
	}

	public LinkedList<Aresta> getaresta() {
		return aresta;
	}

	public void setaresta(LinkedList<Aresta> aresta) {
		this.aresta = aresta;
	}

}
