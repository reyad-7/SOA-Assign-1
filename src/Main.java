import org.w3c.dom.Document;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Document doc = StudentXMLApp.getDocument();
            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Add Student");
                System.out.println("2. Search Student by GPA");
                System.out.println("3. Search Student by First Name");
                System.out.println("4. Delete Student by ID");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int choice;
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine();
                    continue;
                }

                switch (choice) {
                    case 1:
                        addMultipleStudents(scanner,doc);
                        break;
                    case 2:
                        StudentXMLApp.searchStudentByTag(scanner, doc,"GPA");
                        break;
                    case 3:
                        StudentXMLApp.searchStudentByTag(scanner, doc,"FirstName");
                        break;
                    case 4:
                        StudentXMLApp.deleteStudentByID(scanner, doc);
                        StudentXMLApp.saveDocument(doc);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            }
    }
    private static void addMultipleStudents(Scanner scanner, Document doc) {
        System.out.print("Enter number of students to add: ");
        int numOfStudents;
        try {
            numOfStudents = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.nextLine();
            return;
        }
        while (numOfStudents > 0) {
            System.out.println("\nAdding a new student (" + numOfStudents + " remaining):");
            String studentID;
            while (true) {
                System.out.print("Enter Student ID: ");
                studentID = scanner.nextLine();

                if (!StudentXMLApp.searchStudentByID(doc, studentID)) {
                    break; // not repeated ID ,then add it to list

                } else {
                    System.out.println("Student with ID " + studentID + " already exists. Please enter another ID.");
                }
            }
            Student student = Student.CreateStudentFromInput(scanner, studentID);
            StudentXMLApp.addStudent(doc, student);
            System.out.println("Student added successfully.");
            numOfStudents--;
        }
        StudentXMLApp.saveDocument(doc);
        System.out.println("All students have been added.");
    }

}