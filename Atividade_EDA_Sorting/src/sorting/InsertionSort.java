package sorting;

public class InsertionSort<T extends Comparable<T>> implements Sorting<T> {
	
	public void sort(T[] arr) {
		for (int i = 1; i < arr.length; i++){
			T key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j].compareTo(key) > 0){
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}	
	}
	
	public String toString() {
		return "Insertion";
	}
}
