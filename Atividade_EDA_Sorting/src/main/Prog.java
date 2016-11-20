package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import sorting.*;

public class Prog<T> {

	private static Sorting sorting;
	
	public static <E extends Sorting> long executeSorting(E sorting, int[] elements) {
		long tempoInicial = System.currentTimeMillis();
		sorting.sort(elements);
		long tempofinal = System.currentTimeMillis();
		long saida = tempofinal - tempoInicial;
		return saida;
	}
	
	public static long insertion(int[] v) {
		sorting = new InsertionSort();
		return executeSorting(sorting, v);
	}

	public static long selection(int[] v) {
		sorting = new SelectionSort();
		return executeSorting(sorting, v);
	}

	public static long merge(int[] v) {
		sorting = new MergeSort();
		return executeSorting(sorting, v);
	}

	public static long quick(int[] v) {
		sorting = new QuickSort();
		return executeSorting(sorting, v);
	}

	public static void criaArquivo() throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter("sort.data.csv"));
		String ini = "algorithm" + "," + "time" + "," + "sample";
		out.write(ini);
		out.newLine();
		
		for (int i = 20000; i <= 40000; i += 1000) {
			int[] v = randomArray(i);
			
			String selection = "Selection" + "," + selection(v) + "," + i;
			out.write(selection);
			out.newLine();
			
			String insertion = "Insertion" + "," + insertion(v) + "," + i;
			out.write(insertion);
			out.newLine();
			
			String merge = "Merge" + "," + merge(v) + "," + i;
			out.write(merge);
			out.newLine();
			
			String quick = "Quick" + "," + quick(v) + "," + i;
			out.write(quick);
			out.newLine();
		}
		out.close();
	}
	
	public static int[] randomArray(int tam) {
		int[] v = new int[tam];
		Random random = new Random();
		for (int i = 0; i < tam; i++) {
			v[i] = random.nextInt(tam);
		}
		return v;
	}

	public static void main(String[] args) throws IOException {
		criaArquivo();
	}
}
