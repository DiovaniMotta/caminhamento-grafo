package br.com.furb.grafos.entidades;

import java.io.Serializable;

public class Ponto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8273841993420804329L;
	private int eixoX;
	private int eixoY;
	
	public Ponto() {
		super();
	}

	public Ponto(int eixoX, int eixoY) {
		super();
		this.eixoX = eixoX;
		this.eixoY = eixoY;
	}

	public int getEixoX() {
		return eixoX;
	}

	public void setEixoX(int eixoX) {
		this.eixoX = eixoX;
	}

	public int getEixoY() {
		return eixoY;
	}

	public void setEixoY(int eixoY) {
		this.eixoY = eixoY;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + eixoX;
		result = prime * result + eixoY;
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
		Ponto other = (Ponto) obj;
		if (eixoX != other.eixoX)
			return false;
		if (eixoY != other.eixoY)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vertice [eixoX=" + eixoX + ", eixoY=" + eixoY + "]";
	}
}
