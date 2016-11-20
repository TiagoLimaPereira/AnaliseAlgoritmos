package sorting;

public class SelectionSort implements Sorting {

	public void sort(int[] elements) {
		
		for (int j = 0; j < elements.length; j++) {
			int menor = j;
			for (int i = j; i < elements.length; i++) {
				if (elements[i] < elements[menor]) {
					menor = i;
				}
			}
			swap(elements, menor, j);
		}
	}

	private void swap(int[] elements, int i, int j) {
		int aux = elements[i];
		elements[i] = elements[j];
		elements[j] = aux;
	}
}
