package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import sorting.*;

public class Prog {


	private static Sorting<Integer>[] algoritmos;
	private static BufferedWriter out;

	private static void initialize() {
		algoritmos = new Sorting[] { new QuickSort<Integer>(), new MergeSort<Integer>(), new InsertionSort<Integer>(), new SelectionSort<Integer>() };
	}
	
	public static void criaArquivo() throws IOException {
		System.out.println("go");
		
		out = new BufferedWriter(new FileWriter("sort.data.csv"));
		out.write("Algorithm" + "," + "Time" + "," + "Sample");
		out.newLine();
		initialize();
		Sorting<Integer> atual;
		for (int i = 0; i < algoritmos.length; i++) {
			atual = algoritmos[i];
			for (int j = 10000; j <= 20000; j += 1000) {
				Integer[] v = generateArray(j);
				execute(atual, v);
				}
			
		}
		out.close();
		System.out.println("stop");
	}

	public static Integer[] generateArray(int size){
		
		Integer array[] = new Integer[size];
		
		Random randomGenerator = new Random();
		for(int i = 0; i<size; i++){
			array[i] =  randomGenerator.nextInt(size);
			
		}
		return array;
	}
		
		

	private static void execute(Sorting<Integer> algoritmo, Integer[] vetor) throws IOException {
		long initialTime = System.currentTimeMillis();
		algoritmo.sort(vetor);
		long endTime = System.currentTimeMillis() - initialTime;
		out.write(algoritmo + "," + endTime + "," + vetor.length);
		out.newLine();
	}
	
	public static void main(String[] args) throws IOException {
		criaArquivo();
	}
}
