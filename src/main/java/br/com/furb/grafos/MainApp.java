package br.com.furb.grafos;

import java.util.List;
import java.util.Scanner;

import br.com.furb.grafos.criacao.CriacaoGrafo;
import br.com.furb.grafos.dijkstra.Aresta;
import br.com.furb.grafos.dijkstra.Dijkstra;
import br.com.furb.grafos.dijkstra.Grafo;
import br.com.furb.grafos.dijkstra.Vertice;
import br.com.furb.grafos.entidades.Linha;
import br.com.furb.grafos.processamento.Arquivo;
import br.com.furb.grafos.processamento.Distancia;
import br.com.furb.grafos.processamento.PreProcessamento;

/**
 * 
 * @author Diovani Bernardi da Motta
 *
 */
public class MainApp {

	public static void main(String[] args) {
		List<Linha> linhas = Arquivo.carregar();
		List<Linha> processado = PreProcessamento.substituir(linhas);
		List<Linha> distancia = Distancia.calcular(processado);
		CriacaoGrafo criacaoGrafo = new CriacaoGrafo();
		Grafo grafo = criacaoGrafo.getGrafo(distancia);
		Dijkstra dijkstra = new Dijkstra();
		System.out.println("Origem:");
		Scanner scanner = new Scanner(System.in);
		String origem = scanner.nextLine();
		System.out.println("Destino:");
		String destino = scanner.nextLine();
		Vertice orign = criacaoGrafo.buscar(origem);
		Vertice dest = criacaoGrafo.buscar(destino);
		List<Vertice> menorCaminho = dijkstra.encontrarMenorCaminhoDijkstra(grafo, orign, dest);
		Arquivo.imprimir(menorCaminho, orign, dest);
		Arquivo.gravar(menorCaminho, orign, dest);
		//menorCaminho.forEach(v -> System.out.println(v));
	}
}
