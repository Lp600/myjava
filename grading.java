import java.util.Scanner;

public class GradeCalculator {
    public static double calculateAverage(int cit104, int cis221, int cit421, int cit117) {
        return (cit104 + cis221 + cit421 + cit117) / 4.0; 
    }
    public static char determineGrade(double average) {
        char grade;
        if (average >= 70 && average <= 100) {
            grade = 'A';
        } else if (average >= 60) {
            grade = 'B';
        } else if (average >= 50) {
            grade = 'C';
        } else if (average >= 40) {
            grade = 'D';
        } else if (average >= 0) {
            grade = 'F';
        } else {
            grade = 'X';
        }

        return grade;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter grade for CIT 104: ");
        int cit104 = scanner.nextInt();
        System.out.print("Enter grade for CIS 221: ");
        int cis221 = scanner.nextInt();
        System.out.print("Enter grade for CIT 421: ");
        int cit421 = scanner.nextInt();
        System.out.print("Enter grade for CIT 117: ");
        int cit117 = scanner.nextInt();

       
        double average = calculateAverage(cit104, cis221, cit421, cit117);
        char grade = determineGrade(average);

        System.out.printf("Average : %.2f\n", average);
        System.out.println("Grade : " + grade);

        scanner.close();
    }
}