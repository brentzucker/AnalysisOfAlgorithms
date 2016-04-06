public class HeapSort {
	public static void main(String[] args) {
		String filename = args[0];
		int[] arr = Utility.getArrayFromFile(filename);
		sort(arr);
	}

	public static void sort(int[] array) {
	    for (int heapsize=0; heapsize<array.length; heapsize++) {
	        int n = heapsize; 
	        while (n > 0) { 
	            int p = (n-1)/2; 
	            if (array[n] > array[p]) {
	                swap(array, n, p); 
	                n = p; 
	            }
	            else 
	                break;
	        }
	    }
	    
	    for (int heapsize=array.length; heapsize>0;) {
	        swap(array, 0, --heapsize);
	        int n = 0; 
	        while (true) {
	            int left = (n*2)+1;
	            if (left >= heapsize) 
	                break; 
	            int right = left+1;
	            if (right >= heapsize) { 
	                if (array[left] > array[n])
	                    swap(array, left, n); 
	                break; 
	            }
	            if (array[left] > array[n]) { 
	                if (array[left] > array[right]) { 
	                    swap(array, left, n);
	                    n = left; continue; 
	                } else { 
	                    swap(array, right, n);
	                    n = right; continue;
	                }
	            } else {
	                if (array[right] > array[n]) {
	                    swap(array, right, n);
	                    n = right; continue;
	                } else {
	                    break; 
	                }
	            }
	        }
	    }
	}

	public static void swap(int[] arr, int i, int j) {
		int temp;
		temp = arr[j];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}