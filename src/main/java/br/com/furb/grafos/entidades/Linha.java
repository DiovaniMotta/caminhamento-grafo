package br.com.furb.grafos.entidades;

import java.io.Serializable;

public class Linha implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7582262338045706026L;
	private Ponto v1;
	private Ponto v2;
	private double distancia;
	
	public Linha() {
		super();
	}

	public Linha(Ponto v1, Ponto v2) {
		super();
		this.v1 = v1;
		this.v2 = v2;
	}

	public Ponto getV1() {
		return v1;
	}

	public void setV1(Ponto v1) {
		this.v1 = v1;
	}

	public Ponto getV2() {
		return v2;
	}

	public void setV2(Ponto v2) {
		this.v2 = v2;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((v1 == null) ? 0 : v1.hashCode());
		result = prime * result + ((v2 == null) ? 0 : v2.hashCode());
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
		Linha other = (Linha) obj;
		if (v1 == null) {
			if (other.v1 != null)
				return false;
		} else if (!v1.equals(other.v1))
			return false;
		if (v2 == null) {
			if (other.v2 != null)
				return false;
		} else if (!v2.equals(other.v2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aresta [v1=" + v1 + ", v2=" + v2 + ", distancia=" + distancia + "]";
	}
}
