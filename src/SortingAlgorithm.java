public abstract class SortingAlgorithm {
    public abstract void sort(Integer[] array);
    protected String name = this.getClass().getSimpleName();

    public String getName() {
        return name;
    }
    
    public static void swap(Integer[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
