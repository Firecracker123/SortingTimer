import java.io.IOException;

import javax.naming.directory.InvalidAttributeIdentifierException;

public class ShellSort extends SortingAlgorithm {
    public void sort(Integer[] array) {
        int h = 1;
        
        while (h < array.length/3) {
            h = 3*h +1;
        }

        while (h >= 1) {
            for (int i = h; i < array.length; i++) {
                for (int j = i; j >= h && array[j] < array[j-h]; j = j-h) {
                    swap(array, j, j-h);
                }
            }

            h /= 3;
        }
    }

    public static void main(String[] args) throws IOException{
        ShellSort shellSort = new ShellSort();
        TestSortingAlgorithm.testSort(shellSort);
    }
}
