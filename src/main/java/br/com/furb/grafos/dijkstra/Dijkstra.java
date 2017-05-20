package br.com.furb.grafos.dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dijkstra {

	/* Lista que guarda os vertices pertencentes ao menor caminho encontrado */
	List<Vertice> menorCaminho = new ArrayList<Vertice>();
	/* Variavel que recebe os vertices pertencentes ao menor caminho */
	Vertice verticeCaminho = new Vertice();
	/* Variavel que guarda o vertice que esta sendo visitado */
	Vertice atual = new Vertice();
	/* Variavel que marca o vizinho do vertice atualmente visitado */
	Vertice vizinho = new Vertice();
	/* Lista dos vertices que ainda nao foram visitados */
	List<Vertice> naoVisitados = new ArrayList<Vertice>();

	/**
	 * 
	 * @param grafo
	 * @param v1
	 * @param v2
	 * @return
	 */
	public List<Vertice> encontrarMenorCaminhoDijkstra(Grafo grafo, Vertice v1, Vertice v2) {
		// Adiciona a origem na lista do menor caminho
		menorCaminho.add(v1);
		for (Vertice v : grafo.getVertices()) {
			if (v.getDescricao().equals(v1.getDescricao()))
				v.setDistancia(0);// verificar
			else
				v.setDistancia(9999);// verificar
			naoVisitados.add(v);
		}
		Collections.sort(naoVisitados);
		// O algoritmo continua ate que todos os vertices sejam visitados
		while (!naoVisitados.isEmpty()) {
			atual = naoVisitados.get(0);
			/*
			 * Para cada vizinho (cada aresta), calcula-se a sua possivel
			 * distancia, somando a distancia do vertice atual com a da aresta
			 * correspondente. Se essa distancia for menor que a distancia do
			 * vizinho, esta eh atualizada.
			 */
			for (Aresta a : atual.getArestas()) {
				Vertice aux = a.getDestino();
				vizinho = !aux.equals(atual) ? a.getDestino() : a.getOrigem();
				if (!vizinho.verificarVisita()) {
					/*
					 * Comparando a distância do vizinho com a possível
					 * distância
					 */
					if (vizinho.getDistancia() > (atual.getDistancia() + a.getDistancia())) {
						vizinho.setDistancia(atual.getDistancia() + a.getDistancia());
						vizinho.setPai(atual);
						/*
						 * Se o vizinho eh o vertice procurado, e foi feita uma
						 * mudanca na distancia, a lista com o menor caminho
						 * anterior eh apagada, pois existe um caminho menor
						 * vertices pais, ateh o vertice origem.
						 */
						if (vizinho.equals(v2)) {
							menorCaminho.clear();
							verticeCaminho = vizinho;
							menorCaminho.add(vizinho);
							while (verticeCaminho.getPai() != null) {
								menorCaminho.add(verticeCaminho.getPai());
								verticeCaminho = verticeCaminho.getPai();
							}
							// Ordena a lista do menor caminho, para que ele
							// seja exibido da origem ao destino.
							Collections.sort(menorCaminho);
						}
					}
				}
			}
			/*
			 * Marca o vertice atual como visitado e o retira da lista de nao
			 * visitados
			 */
			atual.visitar();
			naoVisitados.remove(atual);
			/*
			 * Ordena a lista, para que o vertice com menor distancia fique na
			 * primeira posicao
			 */
			Collections.sort(naoVisitados);
		}
		return menorCaminho;
	}
}
