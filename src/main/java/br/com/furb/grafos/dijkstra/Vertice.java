package br.com.furb.grafos.dijkstra;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.furb.grafos.entidades.Ponto;

public class Vertice implements Comparable<Vertice> {

	private String descricao;
	private double distancia;
	private boolean visitado = false;
	private Ponto ponto;
	private Vertice pai;
	private List<Aresta> arestas = new ArrayList<Aresta>();
	private List<Vertice> vizinhos = new ArrayList<Vertice>();

	public void posicao(Ponto ponto){
		this.ponto = ponto;
	}
	
	public Ponto getPonto(){
		return ponto;
	}
	
	public void setDescricao(String nome) {
		this.descricao = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void visitar() {
		this.visitado = true;
	}

	public boolean verificarVisita() {
		return visitado;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public double getDistancia() {
		return this.distancia;
	}

	public double formatDistancia() {
		return new BigDecimal(this.distancia).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
	}
	public void setPai(Vertice pai) {
		this.pai = pai;
	}

	public Vertice getPai() {
		return this.pai;
	}

	public void setVizinhos(List<Vertice> vizinhos) {
		this.vizinhos.addAll(vizinhos);
	}

	public List<Vertice> getVizinhos() {
		return this.vizinhos;
	}

	public void setArestas(List<Aresta> arestas) {
		this.arestas.addAll(arestas);
	}

	public List<Aresta> getArestas() {
		return arestas;
	}

	public int compareTo(Vertice vertice) {
		if (this.getDistancia() < vertice.getDistancia())
			return -1;
		else if (this.getDistancia() == vertice.getDistancia())
			return 0;
		return 1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((ponto == null) ? 0 : ponto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertice other = (Vertice) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (ponto == null) {
			if (other.ponto != null)
				return false;
		} else if (!ponto.equals(other.ponto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String s = " ";
		s += this.getDescricao();
		return s;
	}
}
