package sorting;

public class QuickSort<T extends Comparable<T>> implements Sorting<T> {

	
	public void sort(T[] elements) {
		quickSort(elements, 0, elements.length - 1);
	}

	private void quickSort(T[] elements, int ini, int fim) {
		if(ini < fim) {
			int indPivot = partciciona(elements, ini, fim);
			quickSort(elements, ini, indPivot - 1);
			quickSort(elements, indPivot + 1, fim);
		}
	}

	private int partciciona(T[] elements, int ini, int fim) {
		T pivot = elements[ini];
		int i = ini;
		int j = i + 1;
		while(j < elements.length) {
			if(elements[j].compareTo(pivot) < 0){
				i++;
				swap(elements, i, j);
			}
			j++;
		}
		
		swap(elements, ini, i);
		return i;
	}

	private void swap(T[] elements, int i, int j) {
		T aux = elements[i];
		elements[i] = elements[j];
		elements[j] = aux;
	}
}
