package sorting;

public class InsertionSort<T extends Comparable<T>> implements Sorting<T> {
	
	public void sort(T[] elements) {
		
		for(int i = 1; i < elements.length; i++ ){
			T key = elements[i];
			int j = i; 
			
			while(j > 0 && (elements[j - 1].compareTo(key) > 0)){
				elements[j] = elements[j - 1];
				j--;
			}
			elements[j] = key;
		}	
	}
}
