import java.lang.Math;

public class Squares {
    public static void main(String[] args) {
        
        int[] squares = new int[5];

        for (int i = 0; i < squares.length; i++) {
            squares[i] = (int)Math.pow(i,2);
            System.out.println(squares[i]);
        }

    }
}
