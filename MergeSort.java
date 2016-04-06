public class MergeSort {
	public static void main(String[] args) {
		String filename = args[0];
		int[] arr = Utility.getArrayFromFile(filename);
		sort(arr);
	}

	public static int[] sort(int[] arr) {

	    for (int i = 1; i <= arr.length / 2 + 1; i *= 2) {

	        for (int j = i; j < arr.length; j += 2 * i) {
	            Merge(arr, j - i, j, Math.min(j + i, arr.length));
	        }
	    }
	    return arr;
	}

	private static void Merge(int[] array, int start, int middle, int end) {
	    int[] merge = new int[end-start];
	    int l = 0, r = 0, i = 0;
	    while (l < middle - start && r < end - middle)
	    {
	        merge[i++] = ((Integer)array[start + l]).compareTo((Integer)array[middle + r]) < 0
	            ? array[start + l++]
	            : array[middle + r++];
	    }
	 
	    while (r < end - middle) merge[i++] = array[middle + r++];
	 
	    while (l < middle - start) merge[i++] = array[start + l++];
	 
	    System.arraycopy(merge, 0, array, start, merge.length);
	}
}