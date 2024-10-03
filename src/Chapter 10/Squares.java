import java.lang.Math;

public class Squares {
    public static void main(String[] args) {
        
        int[] squares = new int[5];

        for (int i : squares) {
            System.out.println(squares[i]);
            squares[i] = i * i;
            System.out.println(squares[i]);
        }

    }
}
