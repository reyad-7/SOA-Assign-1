# **SOA Assignment 1: Student Management Web Application**

## **Description**
This web application is developed in Java to manage student information and store it in an XML format. The application allows users to add student records, search for students by GPA or first name, and delete student records from the XML file. The XML file structure follows a standard format, with each student’s details organized under a root element for easy access and modification.

## **Features**
- **XML Document Generation**: Automatically creates an XML document to store student information.
- **Add Student**: Allows users to enter and store multiple student records with details such as ID, first name, last name, gender, GPA, level, and address.
- **Search by GPA**: Enables users to search for students based on their GPA.
- **Search by First Name**: Enables users to search for students based on their first name.
- **Delete Student by ID**: Allows users to delete a student’s record by providing their ID.
- **XML Persistence**: All student data is stored in an XML file, which is created and updated as records are added, modified, or deleted.

## **Requirements**
- **Java 8 or higher**
- **Basic knowledge of XML and Java DOM**

## **Usage**

### **Running the Application**

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/student-management-app.git
   cd student-management-app
2.  **Compile the Java files**:
    
    ```bash
    javac Main.java StudentXMLApp.java Student.java
    ```
    
3.  **Run the application**:
    
    ```bash
    java Main
    ```

**Menu Options**
----------------

1.  **Add Student**: Enter and save a new student record.
2.  **Search Student by GPA**: Look up students by their GPA value.
3.  **Search Student by First Name**: Look up students by their first name.
4.  **Delete Student by ID**: Remove a student’s record using their ID.
5.  **Exit**: Close the application.


### Adding a Student

When adding a student, the program prompts the user to input the following details:

*   **Student ID**: Unique identifier for the student.
*   **First Name**
*   **Last Name**
*   **Gender**
*   **GPA**
*   **Level**
*   **Address**


### Searching for a Student

Users can search for a student by:

1.  **GPA**: Type in the GPA, and the program will display the student record if it matches.
2.  **First Name**: Type in the first name, and the program will display the student record if it matches.


### Deleting a Student

To delete a student, input their **Student ID** when prompted. If the student is found, the record will be deleted from the XML file.



### XML Structure

The student data is stored in an XML file with the following structure:

```xml
<University>
    <Student ID="20200134">
        <FirstName>Ahmed</FirstName>
        <LastName>Mohamed</LastName>
        <Gender>Male</Gender>
        <GPA>3.17</GPA>
        <Level>4</Level>
        <Address>Giza</Address>
    </Student>
</University>
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- **Java**: For providing a robust platform for developing applications.
- **XML**: For enabling a structured way to store and manipulate data.
- **DOM API**: For allowing manipulation of XML files in an easy and efficient manner.

## Contact

For any questions or feedback, feel free to reach out to me:

- Email: [moreyad06@gmail.com](mailto:youremail@example.com)
- GitHub: [https://github.com/reyad-7](https://github.com/reyad-7)
