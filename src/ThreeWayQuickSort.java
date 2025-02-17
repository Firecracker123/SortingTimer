public class ThreeWayQuickSort extends SortingAlgorithm {
    public void sort(Integer[] array) {
        quickSort3Way(array, 0, array.length-1);
    }

    private static void quickSort3Way(Integer[] array, int l, int r) {
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
}
