import exceptions.InvalidMarksException;

public class MarksService {

    public void addSubjectMarks(Student student, int semesterNumber,
                                String subjectName, double marks, int credits) throws InvalidMarksException{

                                    
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }


        SemesterRecord record = student.getSemesterRecord(semesterNumber);
        
        // Create a new semester record if it does not exist
        if (record == null) {
            record = new SemesterRecord(semesterNumber);
            student.addSemesterRecord(record);
        }
        if (!record.getRegisteredSubjects()
        .contains(subjectName.toLowerCase())) {
    System.out.println("Subject is not registered!");
    return;
}
        // Create and add the subject
        try {
            Subject subject = new Subject(subjectName, marks, credits);
            record.addSubject(subject);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Update marks of an existing subject
    public void updateMarks(Student student, int semesterNumber,
                            String subjectName, double newMarks) throws InvalidMarksException {

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        SemesterRecord record = student.getSemesterRecord(semesterNumber);

        if (record == null) {
            System.out.println("Semester record not found!");
            return;
        }

        Subject subject = record.getSubjects().get(subjectName.toLowerCase());

        if (subject == null) {
            System.out.println("Subject not found!");
            return;
        }

        try {
            subject.setMarks(newMarks);
            System.out.println("Marks updated successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Display marks for a particular semester
    public void displaySemesterMarks(Student student, int semesterNumber) {

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        SemesterRecord record = student.getSemesterRecord(semesterNumber);

        if (record == null) {
            System.out.println("Semester record not found!");
            return;
        }

        record.displayDetails();
    }
    public void registerSubject(Student student, int semesterNumber,
                            String subjectName) {

    if (student == null) {
        System.out.println("Student not found!");
        return;
    }

    SemesterRecord record = student.getSemesterRecord(semesterNumber);

    if (record == null) {
        record = new SemesterRecord(semesterNumber);
        student.addSemesterRecord(record);
    }

    record.registerSubject(subjectName);

}
}
