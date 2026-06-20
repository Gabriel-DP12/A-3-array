import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        final int TOTAL_STUDENTS = 3; 
        String[] name = new String[TOTAL_STUDENTS];
        double[] grade = new double[TOTAL_STUDENTS];
        
        System.out.println("=== Data Entry ===");
        for (int i = 0; i < TOTAL_STUDENTS; i++) {
            System.out.print("Enter name of student " + (i + 1) + ": ");
            name[i] = scan.nextLine();
            
            System.out.print("Enter grade for " + name[i] + ": ");
            grade[i] = scan.nextDouble();
            scan.nextLine(); // Clear the buffer dangling newline
        }
        
        double sum = 0;
        for (int i = 0; i < TOTAL_STUDENTS; i++) {
            sum += grade[i];
        }
        double average = sum / TOTAL_STUDENTS;
        
        System.out.println("\n=== Class Average ===");
        System.out.println("The average grade of the class is: " + average);
        
        for (int i = 0; i < TOTAL_STUDENTS - 1; i++) {
            for (int j = 0; j < TOTAL_STUDENTS - 1 - i; j++) {
                if (grade[j] > grade[j + 1]) {

                    double tempGrade = grade[j];
                    grade[j] = grade[j + 1];
                    grade[j + 1] = tempGrade;
                    
                    String tempName = name[j];
                    name[j] = name[j + 1];
                    name[j + 1] = tempName;
                }
            }
        }
        
        System.out.println("\n=== Sorted Records (Ascending) ===");
        for (int i = 0; i < TOTAL_STUDENTS; i++) {
            System.out.println(name[i] + " - " + grade[i]);
        }
        
        System.out.println("\n=== Search Student ===");
        System.out.print("Enter the name of the student to search for: ");
        String searchName = scan.nextLine();
        boolean isFound = false;
        
        for (int i = 0; i < TOTAL_STUDENTS; i++) {
            if (name[i].equalsIgnoreCase(searchName)) {
                System.out.println("Student Found! " + name[i] + "'s grade is: " + grade[i]);
                isFound = true;
                break;
            }
        }
        
        if (!isFound) {
            System.out.println("Student record not found in the system.");
        }
        
        scan.close();
    }
}