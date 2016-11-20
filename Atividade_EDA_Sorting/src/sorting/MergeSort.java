package sorting;

public class MergeSort implements Sorting {

	public void sort(int[] elements) {
		mergeSort(elements, 0, elements.length - 1);
	}

	private void mergeSort(int[] elements, int ini, int fim) {
		
		if(ini < fim) {
			int med = (ini + fim) / 2;
			mergeSort(elements, ini, med);
			mergeSort(elements, med+1, fim);
			merge(elements, ini, med, fim);
		}
	}

	private void merge(int[] elements, int ini, int med, int fim) {
		int helper[] = new int[elements.length];
		
		for(int i = 0; i < elements.length; i++) {
			helper[i] = elements[i];
		}
		
		int i = ini;
		int j = med + 1;
		int k = ini;
		
		while(i <= med && j <= fim) {
			if(helper[i] < helper[j]) {
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

}
