package br.com.furb.grafos.processamento;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import br.com.furb.grafos.dijkstra.Vertice;
import br.com.furb.grafos.entidades.Linha;
import br.com.furb.grafos.entidades.Ponto;

public class Arquivo {

	private static String INPUT_FILE = "C:/temp/input.txt";
	private static String OUTPUT_FILE = "C:/temp/output.txt";
	private static double distancia;

	public static List<Linha> carregar() {
		List<Linha> arestasGrafo = new ArrayList<>();
		try {
			File file = new File(INPUT_FILE);
			FileInputStream fis = new FileInputStream(file);
			BufferedReader stream = new BufferedReader(new InputStreamReader(fis));
			String line = stream.readLine();
			while (line != null) {
				String[] numbers = line.replace("(", "").replace(")", ",").split(",");
				Linha linha = new Linha();
				linha.setV1(new Ponto(Integer.valueOf(numbers[0]), Integer.valueOf(numbers[1])));
				linha.setV2(new Ponto(Integer.valueOf(numbers[2]), Integer.valueOf(numbers[3])));
				arestasGrafo.add(linha);
				line = stream.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arestasGrafo;
	}

	public static void imprimir(List<Vertice> menorCaminho, Vertice orign, Vertice dest) {
		System.out.println("Origem:" + orign.getDescricao());
		System.out.println("Destino:" + dest.getDescricao());
		System.out.println(" _____________________________________");
		System.out.println("|  X  |  Y  |  Vertice  |  Distância  |");
		System.out.println("|_____|_____|___________|_____________|");
		menorCaminho.forEach(v -> {
			System.out.println("______________________________________");
			System.out.println("|  " + v.getPonto().getEixoX() + " |  " + v.getPonto().getEixoY() + "  |    "
					+ v.getDescricao() + "     |     " + v.formatDistancia() + "    |");
			System.out.println("|_____|_____|___________|_____________|");
			distancia += v.formatDistancia();
		});
		System.out.println(" _____________________________________");
		System.out.println("|     |     |   Total   |    " + distancia + "    |");
		System.out.println("|_____|_____|___________|_____________|");
		distancia = 0;

	}

	public static void gravar(List<Vertice> menorCaminho, Vertice orign, Vertice dest) {
		try {
			File file = new File(OUTPUT_FILE);
			FileWriter fileW = new FileWriter(file);// arquivo para escrita
			BufferedWriter buffW = new BufferedWriter(fileW);
			buffW.write("Origem:" + orign.getDescricao());
			buffW.newLine();
			buffW.write("Destino:" + dest.getDescricao());
			buffW.newLine();
			buffW.write(" _____________________________________");
			buffW.newLine();
			buffW.write("|  X  |  Y  |  Vertice  |  Distância  |");
			buffW.newLine();
			buffW.write("|_____|_____|___________|_____________|");
			buffW.newLine();
			menorCaminho.forEach(v -> {
				try {
					buffW.write("______________________________________");
					buffW.newLine();
					buffW.write("|  " + v.getPonto().getEixoX() + " |  " + v.getPonto().getEixoY() + "  |    "
							+ v.getDescricao() + "     |     " + v.formatDistancia() + "    |");
					buffW.newLine();
					buffW.write("|_____|_____|___________|_____________|");
					buffW.newLine();
					distancia += v.formatDistancia();
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			buffW.write(" _____________________________________");
			buffW.newLine();
			buffW.write("|     |     |   Total   |    " + distancia + "    |");
			buffW.newLine();
			buffW.write("|_____|_____|___________|_____________|");
			buffW.newLine();
			distancia = 0;

			buffW.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
