package sorting;

public class SelectionSort<T extends Comparable<T>> implements Sorting<T> {

	public void sort(T[] elements) {
		
		for (int j = 0; j < elements.length; j++) {
			int menor = j;
			for (int i = j; i < elements.length; i++) {
				if (elements[i].compareTo(elements[menor]) < 0) {
					menor = i;
				}
			}
			swap(elements, menor, j);
		}
	}

	private void swap(T[] elements, int i, int j) {
		T aux = elements[i];
		elements[i] = elements[j];
		elements[j] = aux;
	}
}
