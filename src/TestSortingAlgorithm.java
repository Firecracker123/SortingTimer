import java.io.IOException;
import java.util.Arrays;

public class TestSortingAlgorithm {
    public static void testSort(SortingAlgorithm sortingAlg) throws IOException {
        Integer[] testDataArray = new Integer[] {900, 45, 26, 2, Integer.MAX_VALUE, Integer.MIN_VALUE};
        Integer[] testDataArraySorted = testDataArray.clone();
        sortingAlg.sort(testDataArray);
        Arrays.sort(testDataArraySorted);

        for (int i = 0; i < testDataArray.length; i++) {
            if (!testDataArray[i].equals(testDataArraySorted[i])) {
                System.out.println(sortingAlg.getClass().getSimpleName());
                return;
            }

        }
    }
}
