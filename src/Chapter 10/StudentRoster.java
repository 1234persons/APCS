import java.util.Scanner;

public class StudentRoster {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int studentNum;

        System.out.println("How many students are in your class?");
        studentNum = input.nextInt();

        String[] students = new String[studentNum];


        for (int i = 0; i < students.length; i++) {
            System.out.println("Enter the student's name: ");
            students[i] = input.next();
        }

        System.out.println("The list of students is: ");
        for (String student : students) {
            System.out.println(student);
        }

        input.close();
    }

}
