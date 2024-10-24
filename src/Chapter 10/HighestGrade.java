import java.util.ArrayList;
import java.util.Scanner;

public class HighestGrade {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> grades = new ArrayList<Integer>();
        int bestGrade = 0;
        int grade;

        for (int i = 1; i <= 5; i++) {
            System.out.println("Enter a grade: ");
            grade = input.nextInt();
            grades.add(grade);
            if(grade > bestGrade) bestGrade = grade;
        }

        System.out.println(bestGrade + " is the best grade.");
        input.close();
    }
}
