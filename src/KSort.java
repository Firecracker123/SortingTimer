import java.io.IOException;

public class KSort extends SortingAlgorithm {
    
    
    public void sort(Integer[] array) {
        kSort(array, 0, array.length - 1, 20);
    }

    

    public static void sortCutOff(Integer[] array, int p, int r, int k) {
        kSort(array, p, r, k);
        insertionSort(array);
    }

    private static void kSort(Integer[] array, int p, int r, int k) {
        if (r-p <= k) return;
        int q = partition(array, p, r);
        kSort(array, p, q-1, k);
        kSort(array, q+1, r, k);
    }

    private static int partition(Integer[] array, int p, int r) {
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

    public static void insertionSort(Integer[] array) {
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
    }

    public static void main(String[] args) throws IOException {
        KSort kSort = new KSort();

        TestSortingAlgorithm.testSort(kSort);
    }
}
