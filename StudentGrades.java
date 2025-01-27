import java.util.ArrayList;
import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        ArrayList<Integer> studentGrades = new ArrayList<>();

        System.out.println("Enter grades of students (enter -1 to stop):");

        // Input grades
        while (true) {
            int currentGrade = inputScanner.nextInt();
            if (currentGrade == -1) { // Stop when -1 is entered
                break;
            }
            studentGrades.add(currentGrade);
        }

        if (studentGrades.isEmpty()) {
            System.out.println("No grades entered!");
            return;
        }

        // Calculate average, highest, and lowest grades
        int totalGrades = 0;
        int highestGrade = studentGrades.get(0);
        int lowestGrade = studentGrades.get(0);

        for (int grade : studentGrades) {
            totalGrades += grade;
            if (grade > highestGrade) {
                highestGrade = grade;
            }
            if (grade < lowestGrade) {
                lowestGrade = grade;
            }
        }

        double averageGrade = (double) totalGrades / studentGrades.size();

        // Display results
        System.out.println("Number of students: " + studentGrades.size());
        System.out.println("Average grade: " + averageGrade);
        System.out.println("Highest grade: " + highestGrade);
        System.out.println("Lowest grade: " + lowestGrade);
    }
}