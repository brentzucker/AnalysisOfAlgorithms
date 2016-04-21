public class QuickSort {
	public static void main(String[] args) {
		String filename = args[0];
		int[] arr = Utility.getArrayFromFile(filename);
		sort(arr, 0, arr.length - 1);
	}

    public static void swap(int arr[],int i,int j)
    {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
 
    public static int partition (int arr[], int l, int h)
    {
        int x = arr[h];
        int i = (l - 1);
 
        for (int j = l; j <= h- 1; j++)
        {
            if (arr[j] <= x)
            {
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,h);
        return (i + 1);
    }
 
    public static void sort(int arr[], int l, int h)
    {
        int stack[] = new int[h-l+1];
 
        int top = -1;
 
        stack[++top] = l;
        stack[++top] = h;
 
        while (top >= 0)
        {
            h = stack[top--];
            l = stack[top--];
 
            int p = partition(arr, l, h);
 
            if ( p-1 > l )
            {
                stack[ ++top ] = l;
                stack[ ++top ] = p - 1;
            }
 
            if ( p+1 < h )
            {
                stack[ ++top ] = p + 1;
                stack[ ++top ] = h;
            }
       }
    }
}