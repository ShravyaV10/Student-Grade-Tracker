
public class HallTicket {

    private String hallTicketNumber;
    private Student student;
    private SemesterRecord semesterRecord;

    public HallTicket(String hallTicketNumber, Student student,
                      SemesterRecord semesterRecord) {
        this.hallTicketNumber = hallTicketNumber;
        this.student = student;
        this.semesterRecord = semesterRecord;
    }

    public void displayHallTicket() {

        System.out.println("\n==================================================");
        System.out.println("                  COLLEGE NAME");
        System.out.println("                   HALL TICKET");
        System.out.println("==================================================");

        System.out.println("Hall Ticket Number : " + hallTicketNumber);
        System.out.println("Student ID         : " + student.getStudentId());
        System.out.println("Student Name       : " + student.getName());
        System.out.println("Department         : " + student.getDept());
        System.out.println("Year               : " + student.getYear());
        System.out.println("Semester           : " + semesterRecord.getSemesterNumber());

        System.out.println("--------------------------------------------------");
        System.out.println("               EXAMINATION SUBJECTS");
        System.out.println("--------------------------------------------------");

        System.out.printf("%-26s %-22s%n", "Subject", "Sign of Invigilator");

        for (Subject subject : semesterRecord.getSubjects().values()) {
            System.out.printf("%-26s %-22s%n", subject.getSubjectName(), "___________________");
        }

        System.out.println("--------------------------------------------------");
        System.out.println("Student Signature : ______________");
        System.out.println("Authorized Sign   : ______________");
        System.out.println("==================================================");
    }
}
