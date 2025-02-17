public class SelectionSort extends SortingAlgorithm {
    public void sort(Integer[] array) {
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
    }
}
