package br.com.furb.grafos.dijkstra;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Grafo {

	private List<Vertice> grafo = new ArrayList<Vertice>();

	public void setVertices(List<Vertice> vertices) {
		this.grafo.addAll(vertices);
	}

	public void adicionarVertice(Vertice novoVertice) {
		this.grafo.add(novoVertice);
	}

	public List<Vertice> getVertices() {
		return this.grafo;
	}
	
	public Vertice encontrarVertice(String nome) {
		Optional<Vertice> optional = grafo.stream().filter(v -> v.getDescricao().equalsIgnoreCase(nome)).findFirst();
		return optional.get();
	}
}
