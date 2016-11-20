package sorting;

public class InsertionSort implements Sorting {
	
	public void sort(int[] elements) {
		
		for(int i = 1; i < elements.length; i++ ){
			int key = elements[i];
			int j = i; 
			
			while(j > 0 && (elements[j - 1] > key)){
				elements[j] = elements[j - 1];
				j--;
			}
			elements[j] = key;
		}	
	}
}
