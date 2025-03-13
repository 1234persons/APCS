package Chapter13;

public class ObjectMergeSort {
    public static void main(String[] args) {
        String items[] = { "A", "B", "D", "T", "G", "I"};
        Sorts.mergesort(items, 0, items.length - 1);

        for (int i = 0; i < items.length; i++) {
            System.out.print(items[i] + " ");
        }   
    }
}