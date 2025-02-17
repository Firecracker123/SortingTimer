public class QuickSort extends SortingAlgorithm {
    public void sort(Integer[] array) {
        quickSort(array, 0, array.length-1);
    }

    private static void quickSort(Integer[] array, int p, int r) {
        if (r <= p) return;
        int q = partition(array, p, r);
        quickSort(array, p, q-1);
        quickSort(array, q+1, r);
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
}
