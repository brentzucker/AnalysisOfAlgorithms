public class SelectionSort {
	public static void main(String[] args) {
		String filename = args[0];

		int[] arr = Utility.getArrayFromFile(filename);

		sort(arr);
	}

	public static int[] sort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[index]) {
					index = j;
				}
				int smallerNumber = arr[index];
				arr[index] = arr[i];
				arr[i] = smallerNumber;
			}
		}
		return arr;
	}
}