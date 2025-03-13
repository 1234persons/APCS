package Chapter13;

public class Searches {
    public static int binarySearch(int[] items, int start, int end, int goal) {
        if (start > end) {
            return -1;
        } else {
            int mid = (start + end) / 2;
            if (mid == goal) {
                return mid;
            } else if (mid < goal) {
                return binarySearch(items, start, mid - 1, goal);
            } else {
                return binarySearch(items, mid + 1, end, goal);
            }

        }

    }

}
