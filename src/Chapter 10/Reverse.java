public class Reverse {
    public static void main(String[] args) {
        
        int[] numList = new int[11];

        for (int i = 0; i < numList.length; i++) {
            numList[i] = i;
        }

        System.out.println("Countdown");
        for (int i = numList.length - 1; i >= 0; i--) {
            System.out.println(numList[i]);
        }

    }
}
