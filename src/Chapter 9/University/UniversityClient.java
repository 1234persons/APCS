package University;
import java.util.Scanner;

public class UniversityClient {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        
        UEmployee employee1;
        UEmployee employee2;
        UEmployee employee3;
        UEmployee employee4;

        employee1 = assignJob();
        employee2 = assignJob();
        employee3 = assignJob();
        employee4 = assignJob();

        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(employee3);
        System.out.println(employee4);
        input.close();
    }

    public static UEmployee assignJob() {
        
        String employeeType, name, employeeTrait;
        double salary;

        System.out.println("Enter if the employee is faculty(F) or staff(s)");
        employeeType = input.next();

        System.out.println("Enter the employees salery: ");
        salary = input.nextDouble();

        System.out.println("Enter the employees name: ");
        name = input.next();

        if(employeeType.equalsIgnoreCase("F")) {
            System.out.println("Enter the faculty's department: ");
            employeeTrait = input.next();

            return(new Faculty(name, salary, employeeTrait));
        } else {
            System.out.println("Enter the staff's title: ");
            employeeTrait = input.next();

            return(new Staff(name, salary, employeeTrait));
        }

    }

}
