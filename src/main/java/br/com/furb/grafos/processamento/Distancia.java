package br.com.furb.grafos.processamento;

import java.util.List;

import br.com.furb.grafos.entidades.Linha;

public class Distancia {

	private static double euclediana(Linha aresta){
		double v1 = Math.pow((aresta.getV2().getEixoX() - aresta.getV1().getEixoX()),2);
		double v2 = Math.pow((aresta.getV2().getEixoY() - aresta.getV1().getEixoY()),2);
		double value = v1 + v2; 
		return Math.sqrt(value);
	}
	
	public static List<Linha> calcular(List<Linha> arestas){
		arestas.forEach(a -> a.setDistancia(euclediana(a)));
		return arestas;
	}
}
