package br.com.furb.grafos.criacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.furb.grafos.dijkstra.Aresta;
import br.com.furb.grafos.dijkstra.Grafo;
import br.com.furb.grafos.dijkstra.Vertice;
import br.com.furb.grafos.entidades.Linha;
import br.com.furb.grafos.entidades.Ponto;

public class CriacaoGrafo {

	protected Grafo grafo = new Grafo();
	protected List<Vertice> vertices = new ArrayList<>();
	protected List<Aresta> arestas = new ArrayList<>();

	protected void getVertices(List<Linha> linhas) {
		Set<Ponto> pontos = new HashSet<>();
		linhas.forEach(l -> {
			pontos.add(l.getV1());
			pontos.add(l.getV2());
		});
		List<Ponto> aux = new ArrayList<>(pontos);
		Collections.sort(aux, new OrdenarVertices());
		int index = 1;
		for (Ponto ponto : aux) {
			Vertice vertice = new Vertice();
			vertice.posicao(ponto);
			vertice.setDescricao("v" + index);
			vertices.add(vertice);
			index++;
		}
	}

	protected void getArestas(List<Linha> linhas, List<Vertice> vertices) {
		linhas.forEach(l -> {
			Aresta aresta = new Aresta();
			aresta.setDistancia(l.getDistancia());
			aresta.setOrigem(vertices.stream().filter(v -> v.getPonto().equals(l.getV1())).findFirst().get());
			aresta.setDestino(vertices.stream().filter(v -> v.getPonto().equals(l.getV2())).findFirst().get());
			arestas.add(aresta);
		});
	}

	protected List<Vertice> configurar(List<Vertice> vertices, List<Aresta> arestas) {
		vertices.forEach(v -> {
			v.setArestas(arestas.stream().filter(a -> a.getDestino().equals(v) || a.getOrigem().equals(v))
					.collect(Collectors.toList()));
			v.getArestas().forEach(a -> {
				if (!a.getDestino().equals(v))
					v.getVizinhos().add(a.getDestino());
				if (!a.getOrigem().equals(v))
					v.getVizinhos().add(a.getOrigem());
			});
		});
		return vertices;
	}

	public Grafo getGrafo(List<Linha> linhas) {
		getVertices(linhas);
		getArestas(linhas, vertices);
		List<Vertice> verticesGrafo = configurar(vertices, arestas);
		grafo.setVertices(verticesGrafo);
		return grafo;
	}
	
	public Vertice buscar(String descricao){
		return vertices.stream().filter(v -> v.getDescricao().equalsIgnoreCase(descricao)).findFirst().get();
	}
}
