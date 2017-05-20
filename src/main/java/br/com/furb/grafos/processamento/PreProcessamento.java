package br.com.furb.grafos.processamento;

import java.util.ArrayList;
import java.util.List;

import br.com.furb.grafos.entidades.Linha;
import br.com.furb.grafos.entidades.Ponto;

public class PreProcessamento {

	public static List<Linha> substituir(List<Linha> graph) {
		List<Ponto> vertices = extrair(graph);
		List<Ponto> grauUm = grauUm(vertices);
//		grauUm.forEach(item -> System.out.println(item));
		List<Substituicao> substituicoes = proximo(vertices, grauUm);
//		substituicoes.forEach(i -> System.out.println(i));
		return trocar(substituicoes, graph);
	}

	private static List<Ponto> extrair(List<Linha> graph) {
		List<Ponto> vertices = new ArrayList<Ponto>();
		for (Linha aresta : graph) {
			vertices.add(aresta.getV1());
			vertices.add(aresta.getV2());
		}
		return vertices;
	}

	private static List<Ponto> grauUm(List<Ponto> vertices) {
		List<Ponto> grauUm = new ArrayList<Ponto>();
		vertices.forEach(k -> {
			long count = vertices.stream().filter(p -> p.equals(k)).count();
			if (count == 1)
				grauUm.add(k);
		});
		return grauUm;
	}

	private static List<Substituicao> proximo(List<Ponto> vertices, List<Ponto> grauUm) {
		List<Substituicao> retorno = new ArrayList<>();
		grauUm.forEach(k -> {
			Substituicao aux = new Substituicao(9999, 9999);
			aux.setOriginal(k);
			vertices.forEach(p -> {
				if (aux.proximo(p))
					aux.setSubstituido(p);
			});
			if (!aux.mesmoPonto())
				retorno.add(aux);
		});
		return retorno;
	}
	
	private static List<Linha> trocar(List<Substituicao> substituicaos, List<Linha> arestas){
		substituicaos.forEach(substituicao -> {
			Ponto origem = substituicao.getOriginal();
			Ponto substituir = substituicao.getSubstituido();
			arestas.forEach(aresta->{
				if(aresta.getV1().equals(origem))
					aresta.setV1(substituir);
				if(aresta.getV2().equals(origem))
					aresta.setV2(substituir);
			});
		});
		return arestas;
	}
}
