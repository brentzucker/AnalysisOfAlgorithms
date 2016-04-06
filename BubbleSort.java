public class BubbleSort {
	public static void main(String[] args) {
		String filename = args[0];
		int[] arr = Utility.getArrayFromFile(filename);
		sort(arr);
	}

	public static void sort(int[] arr) {
		int n = arr.length;
		int k;
		for (int m = n; m >= 0; m--) {
			for (int i = 0; i < n - 1; i++) {
				k = i + 1;
				if (arr[i] > arr[k]) {
					swap(i, k , arr);
				}
			}
		}
	}

	public static void swap(int i, int j, int[] arr) {
		int temp;
		temp = arr[j];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}