import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;

public class StudentXMLApp {
    private static final String XML_FILE_PATH = "students.xml";

    public static Document getDocument() {
        try {
            File file = new File(XML_FILE_PATH);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            if (file.exists()) {
                return builder.parse(file);
            } else {
                Document doc = builder.newDocument();
                Element rootElement = doc.createElement("University");
                doc.appendChild(rootElement);
                return doc;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void saveDocument(Document doc) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(XML_FILE_PATH));
            transformer.transform(source, result);
            System.out.println("Changes saved to XML file.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addStudent(Document doc, Student student) {
        Element studentElement = student.toXMLElement(doc);
        doc.getDocumentElement().appendChild(studentElement);
        System.out.println("Student added successfully.");
    }

    public static void searchStudentByTag(Scanner scanner, Document doc, String tagName) {
        System.out.print("Enter " + tagName + " to search: ");
        String searchValue = scanner.nextLine();
        NodeList students = doc.getElementsByTagName("Student");
        boolean found = false;
        for (int i = 0; i < students.getLength(); i++) {
            Element student = (Element) students.item(i);
            String value = student.getElementsByTagName(tagName).item(0).getTextContent();
            if (value.equals(searchValue)) {
                displayStudent(student);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No students found with" + tagName + " = " + searchValue);
        }
    }

    public static boolean searchStudentByID(Document doc, String id) {
        NodeList students = doc.getElementsByTagName("Student");
        for (int i = 0; i < students.getLength(); i++) {
            Element student = (Element) students.item(i);
            String value = student.getAttributes().getNamedItem("ID").getTextContent();
            if (value.equals(id)) {
                return true;
            }
        }
        return false;
    }
    public static void deleteStudentByID(Scanner scanner, Document doc) {
        System.out.print("Enter Student ID to delete: ");
        String deleteID = scanner.nextLine();

        NodeList students = doc.getElementsByTagName("Student");
        boolean found = false;

        for (int i = 0; i < students.getLength(); i++) {
            Element student = (Element) students.item(i);

            if (student.getAttribute("ID").equals(deleteID)) {
                doc.getDocumentElement().removeChild(student);
                System.out.println("Student with ID " + deleteID + " deleted successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + deleteID + " not found.");
        }
    }
    public static void displayStudent(Element student) {
        System.out.println("ID: " + student.getAttribute("ID"));
        System.out.println("First Name: " + student.getElementsByTagName("FirstName").item(0).getTextContent());
        System.out.println("Last Name: " + student.getElementsByTagName("LastName").item(0).getTextContent());
        System.out.println("Gender: " + student.getElementsByTagName("Gender").item(0).getTextContent());
        System.out.println("GPA: " + student.getElementsByTagName("GPA").item(0).getTextContent());
        System.out.println("Level: " + student.getElementsByTagName("Level").item(0).getTextContent());
        System.out.println("Address: " + student.getElementsByTagName("Address").item(0).getTextContent());
        System.out.println("------");
    }

}
