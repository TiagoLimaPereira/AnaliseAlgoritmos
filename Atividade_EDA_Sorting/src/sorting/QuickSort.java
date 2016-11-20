package sorting;

public class QuickSort implements Sorting {

	
	public void sort(int[] elements) {
		quickSort(elements, 0, elements.length - 1);
	}

	private void quickSort(int[] elements, int ini, int fim) {
		if(ini < fim) {
			int indPivot = partciciona(elements, ini, fim);
			quickSort(elements, ini, indPivot - 1);
			quickSort(elements, indPivot + 1, fim);
		}
	}

	private int partciciona(int[] elements, int ini, int fim) {
		int pivot = elements[(ini + fim) /2];
		int i = ini;
		int k = ini + 1;
		while(k <= fim) {
			if(elements[k] < pivot){
				i++;
				swap(elements, i, k);
			}
			k++;
		}
		
		swap(elements, ini, i);
		return i;
	}

	private void swap(int[] elements, int i, int j) {
		int aux = elements[i];
		elements[i] = elements[j];
		elements[j] = aux;
	}
}
