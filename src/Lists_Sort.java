import java.util.Arrays;

public class Lists_Sort {
    public static void main(String[] args) {
int[]nums = {1,2,3,4,5,6};
Arrays.sort(nums);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] bubleSort(int[] arr) {
        for (int i = 0, n = arr.length; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) swap(arr, j, j + 1);
            }
        }
        return arr;
    }


    public static int[] selectionSort(int[] arr) {
        for (int i = 0, n = arr.length; i < n - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_index]) min_index = j;
            }
            swap(arr, min_index, i);
        }
        return arr;
    }

    public static int[] insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(arr, start, middle);
            mergeSort(arr, middle, end);
            merge(arr, start, middle, end);
        }
    }

    private static void merge(int[] arr, int start, int middle, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = middle + 1;
        int k = 0;
        while (i <= middle && j <= end) {
            if (arr[i] < arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }
        while (i <= middle) temp[k++] = arr[i++];
        while (j <= end) temp[k++] = arr[j++];
        i = start;
        k = 0;
        while (k < temp.length && i <= end) arr[i++] = temp[k++];
    }

    public static int binarySearch(int[] arr, int l, int r, int x) {
        if (r >= 1) {
            int mid = 1 + (r - 1) / 2;
            if (arr[mid] == x) return mid;
            if (arr[mid] > x) return binarySearch(arr, l, mid - 1, x);
            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }

    public static int ternarySearch(int[] arr, int l, int r, int x) {
        if (r >= 1) {
            int mid1 = 1 + (r - 1) / 3;
            int mid2 = mid1 + (r - 1) / 3;
            if (arr[mid1] == x) return mid1;
            if (arr[mid2] == x) return mid2;
            if (arr[mid1] > x) return ternarySearch(arr, l, mid1 - 1, x);
            if (arr[mid2] < x) return ternarySearch(arr, mid2 + 1, r, x);
            return ternarySearch(arr, mid1 + 1, mid2 - 1, x);
        }
        return -1;
    }

private static int partition(int[] arr ,int low , int high){    //O(n)
        int pivot = low;
        low++;
        while (low<= high){
            if (arr[low]<arr[pivot]) low++;
            else if (arr[high] >=arr[pivot]) high--;
            else swap(arr,low,high);
        }
swap(arr,pivot,high);
    return high;
    }

}
