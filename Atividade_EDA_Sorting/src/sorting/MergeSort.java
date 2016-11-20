package sorting;

public class MergeSort<T extends Comparable<T>> implements Sorting<T> {

	public void sort(T[] elements) {
		mergeSort(elements, 0, elements.length - 1);
	}

	private void mergeSort(T[] elements, int ini, int fim) {
		
		if(ini < fim) {
			int med = (ini + fim) / 2;
			mergeSort(elements, ini, med);
			mergeSort(elements, med+1, fim);
			merge(elements, ini, med, fim);
		}
	}

	private void merge(T[] elements, int ini, int med, int fim) {
		T helper[] = (T[]) new Comparable[elements.length];
		
		for(int i = ini; i < fim + 1; i++) {
			helper[i] = elements[i];
		}
		
		int i = ini;
		int j = med + 1;
		int k = ini;
		
		while(i <= med && j <= fim) {
			if(helper[i].compareTo(helper[j]) < 0) {
				elements[k] = helper[i];
				i++;
			}else {
				elements[k] = helper[j];
				j++;
			}
			k++;
		}
		
		while(i <= med) {
			elements[k++] = helper[i++];
		}
		
		while(j <= fim) {
			elements[k++] = helper[j++];
		}
	}
	
	public String toString() {
		return "Merge";
	}
}
