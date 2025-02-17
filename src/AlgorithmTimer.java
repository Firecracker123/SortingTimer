import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AlgorithmTimer {
    static List<File> fileList = new LinkedList<File>(Arrays.asList(new File("Test_Data").listFiles()));
    
        public static void timeAlgorithm(SortingAlgorithm sortingAlgorithm) throws IOException {

            String[] averageTimes = new String[7];
            for (int i = 0; i < 7; i++) {
                System.out.println("Performing test " + (i + 1) + " for algorithm " + sortingAlgorithm.getName() + " with file " + fileList.get(0).getName());
                averageTimes[i] =  String.valueOf(getAverageRunningTime(getNextArray(), sortingAlgorithm));
            }

            writeAverageTimesToFile(averageTimes, sortingAlgorithm);
        }
    
        private static Integer[] getNextArray() {
            List<Integer> arrayList = new ArrayList<>();

            try {
                File arrayFile = fileList.remove(0);
                System.out.println(arrayFile.getName());
                Scanner reader = new Scanner(arrayFile);

                while (reader.hasNextLine()) {
                    arrayList.add(Integer.parseInt(reader.nextLine()));
                }
                
                reader.close();
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
                System.exit(1);
            }

            return arrayList.toArray(new Integer[arrayList.size()]);
    }

    private static void writeAverageTimesToFile(String[] averageTimes, SortingAlgorithm sortingAlgorithm) {
        try{
            BufferedWriter resultsFile = new BufferedWriter(new FileWriter("results.csv", true));
            resultsFile.write(sortingAlgorithm.getName() + "," + String.join(",", averageTimes));
            resultsFile.newLine();
            resultsFile.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static long getAverageRunningTime(Integer[] array, SortingAlgorithm sortingAlgorithm) {
        long timeTakenTotal = 0;
        long startTime;
        long endTime;
        for (int i = 0; i < 10; i++) {
            Integer[] arrayClone = array.clone();
            startTime = System.nanoTime();
            sortingAlgorithm.sort(arrayClone);
            endTime = System.nanoTime();
            timeTakenTotal += endTime - startTime;
            
            System.out.println("Pass " + i + " done");
        }

        return timeTakenTotal / 10;
    }

    public static void main(String[] args) throws IOException {
        BottomUpMergeSort bottomUpMergeSort = new BottomUpMergeSort();
        InsertionSort insertionSort = new InsertionSort();
        MergeSort mergeSort = new MergeSort();
        QuickSort quickSort = new QuickSort();
        RandQuickSort randQuickSort = new RandQuickSort();
        SelectionSort selectionSort = new SelectionSort();
        ShellSort shellSort = new ShellSort();
        ThreeWayQuickSort threeWayQuickSort = new ThreeWayQuickSort();

        timeAlgorithm(bottomUpMergeSort);
        timeAlgorithm(insertionSort);
        timeAlgorithm(mergeSort);
        timeAlgorithm(quickSort);
        timeAlgorithm(randQuickSort);
        timeAlgorithm(selectionSort);
        timeAlgorithm(shellSort);
        timeAlgorithm(threeWayQuickSort);
    }
}
