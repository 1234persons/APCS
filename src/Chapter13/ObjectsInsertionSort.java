package Chapter13;

public class ObjectsInsertionSort {
    public static void main(String[] args) {
        String items[] = { "A", "B", "C", "D", "A", "B" };
        Sorts.insertionSort(items);

        for (int i = 0; i < items.length; i++) {
            System.out.print(items[i] + " ");
        }
    }
}