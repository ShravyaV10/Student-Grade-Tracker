
public class HallTicketService {

    private StudentService studentService;

    public HallTicketService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void generateHallTicket(int studentId, int semesterNumber) {

        // Find the student
        Student student = studentService.searchStudent(studentId);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        // Find the semester record
        SemesterRecord record = student.getSemesterRecord(semesterNumber);

        if (record == null) {
            System.out.println("No academic record found for this semester!");
            return;
        }

        // Check whether subjects are registered
        if (record.getSubjects().isEmpty()) {
            System.out.println("No subjects registered for this semester!");
            return;
        }

        // Check examination eligibility
        if (!record.isPass()) {
            System.out.println("Hall ticket cannot be generated!");
            System.out.println("Reason: Student has failed in one or more subjects.");
            return;
        }

        // Generate hall ticket number
        String ticketNumber = "HT" + semesterNumber + "-" + studentId;

        HallTicket hallTicket = new HallTicket(
                ticketNumber, student, record
        );

        System.out.println("\nHall ticket generated successfully!");
        hallTicket.displayHallTicket();
    }
}
