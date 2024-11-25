import org.w3c.dom.*;
import java.util.Scanner;

public class Student {
    private String id;
    private String firstName;
    private String lastName;
    private String gender;
    private double gpa;
    private String level;
    private String address;

    public Student(String id, String firstName, String lastName, String gender, double gpa, String level, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.gpa = gpa;
        this.level = level;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Creates a Student object by prompting user input for each field.
     */
    public static Student CreateStudentFromInput(Scanner scanner,String studentID){
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter GPA: ");
        double gpa;
        while (true) {
            try {
                gpa = Double.parseDouble(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.print("Invalid GPA. Please enter a numeric value: ");
            }
        }
        System.out.print("Enter Level: ");
        String level = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        return new Student(studentID,firstName,lastName,gender,gpa,level,address);
    }

    /**
     * Helper method to create an XML element with specified tag name and text content.
     */
    private static Element createElement(Document doc, String tagName, String textContent) {
        Element element = doc.createElement(tagName);
        element.setTextContent(textContent);
        return element;
    }

    /**
     * Converts this Student object to an XML element.
     */
    /**
     * Converts this Student object to an XML element.
     */
    public Element toXMLElement(Document doc) {
        Element studentElement = doc.createElement("Student");
        studentElement.setAttribute("ID", this.id);

        studentElement.appendChild(createElement(doc, "FirstName", this.firstName));
        studentElement.appendChild(createElement(doc, "LastName", this.lastName));
        studentElement.appendChild(createElement(doc, "Gender", this.gender));
        studentElement.appendChild(createElement(doc, "GPA", String.valueOf(this.gpa)));
        studentElement.appendChild(createElement(doc, "Level", this.level));
        studentElement.appendChild(createElement(doc, "Address", this.address));
        return studentElement;
    }

}