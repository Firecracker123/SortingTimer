public class InsertionSort extends SortingAlgorithm {
    public void sort(Integer[] array) {
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
}
