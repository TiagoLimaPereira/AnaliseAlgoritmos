package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import sorting.*;

public class Prog {

	private static Sorting<Integer> sorting;
	
	public static long executeSorting(Integer[] v) {
		long tempoInicial = System.currentTimeMillis();
		sorting.sort(v);
		long tempofinal = System.currentTimeMillis();
		long saida = tempofinal - tempoInicial;
		return saida;
	}
	
	public static long insertion(Integer[] v) {
		sorting = new InsertionSort<Integer>();
		return executeSorting(v);
	}

	public static long selection(Integer[] v) {
		sorting = new SelectionSort<Integer>();
		return executeSorting(v);
	}

	public static long merge(Integer[] v) {
		sorting = new MergeSort<Integer>();
		return executeSorting(v);
	}

	public static long quick(Integer[] v) {
		sorting = new QuickSort<Integer>();
		return executeSorting(v);
	}

	public static void criaArquivo() throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter("sort.data.csv"));
		String ini = "algorithm" + "," + "time" + "," + "sample";
		out.write(ini);
		out.newLine();
		System.out.println("go!");
		
		for (int i = 20000; i <= 40000; i += 1000) {
			Integer[] v = randomArray(i);
			
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
		System.out.println("STOP!");
	}
	
	public static Integer[] randomArray(int tam) {
		Integer[] v = new Integer[tam];
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
