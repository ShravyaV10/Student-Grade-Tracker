
import java.util.Scanner;

import exceptions.GradeTrackerException;
import exceptions.InvalidMarksException;

public class Main {

    static Scanner input = new Scanner(System.in);

    static StudentService studentService = new StudentService();
    static MarksService marksService = new MarksService();
    static GradeCalculator calculator = new GradeCalculator();
    static ReportCard reportCard = new ReportCard();
    static HallTicketService hallTicketService = new HallTicketService(studentService);
    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== STUDENT INFORMATION AND GRADE TRACKER =====");
            System.out.println("1. Register Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student Details");
            System.out.println("5. Add Subject Marks");
            System.out.println("6. Update Subject Marks");
            System.out.println("7. View Semester Marks");
            System.out.println("8. Calculate SGPA");
            System.out.println("9. Calculate CGPA");
            System.out.println("10. Generate Report Card");
            System.out.println("11. Generate Hall Ticket");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = readInt();

            switch (choice) {

                case 1:
                    registerStudent();
                    break;

                case 2:
                    studentService.displayAllStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    addSubjectMarks();
                    break;

                case 6:
                    updateSubjectMarks();
                    break;

                case 7:
                    viewSemesterMarks();
                    break;

                case 8:
                    calculateSGPA();
                    break;

                case 9:
                    calculateCGPA();
                    break;

                case 10:
                    generateReport();
                    break;

                case 11:
    System.out.print("Enter Student ID: ");
    int ticketStudentId = input.nextInt();

    System.out.print("Enter Semester Number: ");
    int ticketSemester = input.nextInt();

    hallTicketService.generateHallTicket(
            ticketStudentId, ticketSemester
    );
    break;
                case 0:
                    System.out.println("Thank you for using the application!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        input.close();
    }

    // Read an integer safely
    public static int readInt() {

        while (true) {
            try {
                return Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid whole number: ");
            }
        }
    }

    // Read a decimal number safely
    public static double readDouble() {

        while (true) {
            try {
                return Double.parseDouble(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }

    // Find a student using ID
    public static Student getStudent() {

        System.out.print("Enter Student ID: ");
        int id = readInt();

        Student student = studentService.searchStudent(id);

        if (student == null) {
            System.out.println("Student not found!");
        }

        return student;
    }

    // Register student
    public static void registerStudent() {

        try {
            System.out.print("Student ID: ");
            int id = readInt();

            System.out.print("Name: ");
            String name = input.nextLine();

            System.out.print("Department: ");
            String department = input.nextLine();

            System.out.print("Year: ");
            int year = readInt();

            System.out.print("Current Semester: ");
            int semester = readInt();

            Student student =
                    new Student(id, name, department, year, semester);

            studentService.registerStudent(student);

        } catch (GradeTrackerException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Search student
    public static void searchStudent() {

        Student student = getStudent();

        if (student != null) {
            student.DisplayDetails();
        }
    }

    // Update student details
    public static void updateStudent() {

        Student student = getStudent();

        if (student == null) return;

        System.out.print("New Name: ");
        String name = input.nextLine();

        System.out.print("New Department: ");
        String department = input.nextLine();

        System.out.print("New Year: ");
        int year = readInt();

        System.out.print("New Current Semester: ");
        int semester = readInt();

        studentService.updateStudent(
                student.getStudentId(),
                name,
                department,
                year,
                semester
        );
    }

    // Add subject marks
    public static void addSubjectMarks() {

        Student student = getStudent();

        if (student == null) return;

        System.out.print("Semester Number: ");
        int semester = readInt();

        System.out.print("Subject Name: ");
        String subject = input.nextLine();

        System.out.print("Marks: ");
        double marks = readDouble();

        System.out.print("Credits: ");
        int credits = readInt();

        try {
            marksService.addSubjectMarks(
                    student, semester, subject, marks, credits
            );

        } catch (InvalidMarksException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Update subject marks
    public static void updateSubjectMarks() {

        Student student = getStudent();

        if (student == null) return;

        System.out.print("Semester Number: ");
        int semester = readInt();

        System.out.print("Subject Name: ");
        String subject = input.nextLine();

        System.out.print("New Marks: ");
        double marks = readDouble();

        try {
            marksService.updateMarks(
                    student, semester, subject, marks
            );

        } catch (InvalidMarksException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // View semester marks
    public static void viewSemesterMarks() {

        Student student = getStudent();

        if (student == null) return;

        System.out.print("Semester Number: ");
        int semester = readInt();

        marksService.displaySemesterMarks(student, semester);
    }


    // Calculate SGPA
    public static void calculateSGPA() {

        Student student = getStudent();

        if (student == null) return;

        System.out.print("Semester Number: ");
        int semester = readInt();

        SemesterRecord record =
                student.getSemesterRecord(semester);

        if (record == null || record.getSubjects().isEmpty()) {
            System.out.println("No marks available for this semester.");
            return;
        }

        double sgpa = calculator.calculateSGPA(record);

        System.out.printf("SGPA: %.2f%n", sgpa);
    }

    // Calculate CGPA
    public static void calculateCGPA() {

        Student student = getStudent();

        if (student == null) return;

        double cgpa = calculator.calculateCGPA(student);

        System.out.printf("CGPA: %.2f%n", cgpa);
    }

    // Generate report card
    public static void generateReport() {

        Student student = getStudent();

        if (student != null) {
            reportCard.generate(student);
        }
    }
}
