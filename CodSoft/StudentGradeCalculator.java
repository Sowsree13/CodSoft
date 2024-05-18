import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==============================================");
        System.out.println("          STUDENT GRADE CALCULATOR ");
        System.out.println("==============================================");

        System.out.print("\nEnter the total number of subjects: ");
        int totalSubjects = scanner.nextInt();

        if (totalSubjects <= 0) {
            System.out.println("Invalid number of subjects. Please enter a positive integer.");
            return;
        }

        float totalMarks = 0;
        System.out.println("Enter marks obtained out of 100 in ");
        for (int i = 1; i <= totalSubjects; i++) {
            System.out.print("Subject " + i + " : ");
            float marks = scanner.nextFloat();

            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks. Marks should be between 0 and 100.");
                return;
            }

            totalMarks += marks;
        }

        float averagePercentage = totalMarks / totalSubjects;
        System.out.println("\n==============================================");
        System.out.println("Total marks obtained: "+ totalMarks);
        System.out.println("Average percentage: "+ averagePercentage);

        String grade;
        if (averagePercentage < 40) grade = "F";
        else if (averagePercentage < 50) grade = "E";
        else if (averagePercentage < 60) grade = "D";
        else if (averagePercentage < 70) grade = "C";
        else if (averagePercentage < 80) grade = "B";
        else if (averagePercentage < 90) grade = "A";
        else grade = "O";

        System.out.println("Grade: " + grade);
        System.out.println("==============================================\n");
    }
}
