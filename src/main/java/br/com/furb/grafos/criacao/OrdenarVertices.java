package br.com.furb.grafos.criacao;

import java.util.Comparator;

import br.com.furb.grafos.entidades.Ponto;

public class OrdenarVertices implements Comparator<Ponto> {

	@Override
	public int compare(Ponto o1, Ponto o2) {
		if(o1.getEixoX() > o2.getEixoX())
			return -1;
		else if(o1.getEixoX() < o2.getEixoX())
			return 1;
		return comparar(o1, o2);
	}

	private int comparar(Ponto o1, Ponto o2){
		if(o1.getEixoY() > o2.getEixoY())
			return -1;
		else if(o1.getEixoY() < o2.getEixoY())
			return 1;
		else
			return 0;
	}
}
