import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithms {

    public static int[] swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return array;
    }

    public static int[] insertionSort(int[] array) {
        int index;
        int temp;
        for (int i = 1; i < array.length; i++) {
            index = i-1;
            temp = array[i];

            while (index >= 0 && array[index] > temp) {
                array[index+1] = array[index];
                index -= 1;
            }
            array[index+1] = temp;
        }
        return array;
    }

    //O(n^2)
    public static int[] insertionSortDecending(int[] array) {
        int index;
        int temp;

        for (int i = 1; i < array.length; i++) {
            index = i-1;
            temp = array[i];

            while (index >= 0 && array[index] < temp) {
                array[index+1] = array[index];
                index -= 1;
            }
            array[index+1] = temp;
        }
        return array;
    }

    public static int[] selectionSort(int[] array) {

        int temp;
        int minIndex;
        for (int i = 0; i < array.length; i++) {
            minIndex = i;

            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }

        return array;
    }

    public static int[] shellSort(int[] array) {
        int h = 1;
        
        while (h < array.length/3) {
            h = 3*h +1;
        }

        while (h >= 1) {
            for (int i = h; i < array.length; i++) {
                for (int j = i; j >= h && array[j] < array[j-h]; j = j-h) {
                    array = swap(array, j, j-h);
                }
            }

            h = 3/h;
        }

        return array;
    }

    private static void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];


        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    static void mergeSort(int arr[], int l, int r)
    {
        if (l < r) {

            int m = l + (r - l) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    public static void bottomUpMergeSort(int[] array) {
        int n = array.length;

        for (int size = 1; size < n; size *= 2) {
            for (int left = 0; left < n - size; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, n - 1);
                merge(array, left, mid, right);
            }
        }
    }

    private static int partition(int[] array, int p, int r) {
        int x = array[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (array[j] <= x) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i+1, r);
        return i + 1;
    }

    public static void quickSort(int[] array, int p, int r) {
        if (r <= p) return;
        int q = partition(array, p, r);
        quickSort(array, p, q-1);
        quickSort(array, q+1, r);
    }

    public static void randQuickSort(int[] array, int p, int r) {
        if (r <= p) return;
        Random random = new Random();
        swap(array, random.nextInt(r-p) + p, r);
        int q = partition(array, p, r);
        randQuickSort(array, p, q-1);
        randQuickSort(array, q+1, r);
    }

    private static void kSort(int[] array, int p, int r, int k) {
        if (r-p <= k) return;
        int q = partition(array, p, r);
        kSort(array, p, q-1, k);
        kSort(array, q+1, r, k);
    }

    public static void sortCutOff(int[] array, int p, int r, int k) {
        kSort(array, p, r, k);
        insertionSort(array);
    }

    public static void quickSort3Way(int[] array, int l, int r) {
        if (r <= l) return;
        int v = array[r];
        int i = l-1, j=r, p=l-1,q=r,k;

        for(;;) {
            while (array[++i]<v);
            while (v < array[--j]) if (j==l) break;
            if (i >= j) break;
            swap(array, i, j);
            if (array[i] == v) {p++; swap(array, p, i);}
            if (v==array[j]) {q--; swap(array, q, j);}
        }
        swap(array, i, r);
        j = i - 1;
        i = i + 1;
        for (k = l; k <= p; k++, j--) swap(array, k, j);
        for (k = r-1; k>=q; k--, i++) swap(array, k, i);
        quickSort3Way(array, l, j);
        quickSort3Way(array, i, r);
    }



    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " ");
        }
    }
    public static void main(String[] args) {
        int[] array = new int[] {2,10,3,49,26,30,-1};
        bottomUpMergeSort(array);
        printArray(array);
    }
}
