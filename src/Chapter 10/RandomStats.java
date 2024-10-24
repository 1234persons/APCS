public class RandomStats {
    public static void main(String[] args) {
        
        int[] digits = new int[10];
        int randomNum;


        for (int i = 0; i < 500; i++) {
            randomNum = (int)((10-1)*Math.random() + 1);
            digits[randomNum] += 1;
        }

        for (int i = 1; i < digits.length; i++) {
            System.out.println(i + ": " + digits[i]);
        }

    }
}
