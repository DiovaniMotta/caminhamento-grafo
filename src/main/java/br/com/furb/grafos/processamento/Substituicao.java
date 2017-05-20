package br.com.furb.grafos.processamento;

import java.io.Serializable;

import br.com.furb.grafos.entidades.Ponto;

public class Substituicao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8318231235664080011L;
	private int distanciaEixoX;
	private int distanciaEixoY;
	private Ponto original;
	private Ponto substituido;

	public Substituicao() {
		super();
	}

	public Substituicao(int distanciaEixoX, int distanciaEixoY) {
		super();
		this.distanciaEixoX = distanciaEixoX;
		this.distanciaEixoY = distanciaEixoY;
	}

	public Substituicao(int distanciaEixoX, int distanciaEixoY, Ponto original, Ponto substituido) {
		super();
		this.distanciaEixoX = distanciaEixoX;
		this.distanciaEixoY = distanciaEixoY;
		this.original = original;
		this.substituido = substituido;
	}

	public int getDistanciaEixoX() {
		return distanciaEixoX;
	}

	public void setDistanciaEixoX(int distanciaEixoX) {
		this.distanciaEixoX = distanciaEixoX;
	}

	public int getDistanciaEixoY() {
		return distanciaEixoY;
	}

	public void setDistanciaEixoY(int distanciaEixoY) {
		this.distanciaEixoY = distanciaEixoY;
	}

	public Ponto getOriginal() {
		return original;
	}

	public void setOriginal(Ponto original) {
		this.original = original;
	}

	public Ponto getSubstituido() {
		return substituido;
	}

	public void setSubstituido(Ponto substituido) {
		this.substituido = substituido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + distanciaEixoX;
		result = prime * result + distanciaEixoY;
		result = prime * result + ((original == null) ? 0 : original.hashCode());
		result = prime * result + ((substituido == null) ? 0 : substituido.hashCode());
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
		Substituicao other = (Substituicao) obj;
		if (distanciaEixoX != other.distanciaEixoX)
			return false;
		if (distanciaEixoY != other.distanciaEixoY)
			return false;
		if (original == null) {
			if (other.original != null)
				return false;
		} else if (!original.equals(other.original))
			return false;
		if (substituido == null) {
			if (other.substituido != null)
				return false;
		} else if (!substituido.equals(other.substituido))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Substituicao [distanciaEixoX=" + distanciaEixoX + ", distanciaEixoY=" + distanciaEixoY + ", original="
				+ original + ", substituido=" + substituido + "]";
	}

	public boolean proximo(Ponto vertice) {
		if (substituido == null)
			return true;
		int eixoX = vertice.getEixoX() - original.getEixoX();
		int eixoY = vertice.getEixoY() - original.getEixoY();
		/*
		 * quando o vertice estiver em uma posicao latitudinal inferior a
		 * origem, efetuamos a operação de multiplicação por menos um para
		 * tornar a distancia positiva
		 */
		if (eixoX <= 0)
			eixoX *= -1;
		/*
		 * quando o vertice estiver em uma posicao longitudinal inferior a
		 * origem, efetuamos a operação de multiplicação por menos um para
		 * tornar a distancia positiva
		 */
		if (eixoY <= 0)
			eixoY *= -1;
		if ((distanciaEixoX >= eixoX) && (distanciaEixoY >= eixoY)) {
			distanciaEixoX = eixoX;
			distanciaEixoY = eixoY;
			return true;
		}
		return false;
	}
	
	public boolean mesmoPonto(){
		return original.equals(substituido);
	}
}