
import java.util.HashMap;

public class SemesterRecord extends AcademicRecord {

    private int semesterNumber;

    private HashMap<String, Subject> subjects;
    private HashMap<Integer, SemesterRecord> semesterRecords;

    public SemesterRecord(int semesterNumber) {
        if (semesterNumber <= 0) {
            throw new IllegalArgumentException("Semester number must be positive.");
        }

        this.semesterNumber = semesterNumber;
        subjects = new HashMap<>();
        semesterRecords = new HashMap<>();
    }

    public int getSemesterNumber() {
        return semesterNumber;
    }

    public HashMap<String, Subject> getSubjects() {
        return subjects;
    }

    public void addSubject(Subject subject) {
        if (subject == null) {
            throw new IllegalArgumentException("Subject cannot be null.");
        }

        subjects.put(subject.getSubjectName().toLowerCase(), subject);
        System.out.println("Subject added successfully!");
    }


    public void addSemesterRecord(SemesterRecord record) {
        if (record == null) {
            throw new IllegalArgumentException("Semester record cannot be null.");
        }

        semesterRecords.put(record.getSemesterNumber(), record);
    }

    public SemesterRecord getSemesterRecord(int semesterNumber) {
        return semesterRecords.get(semesterNumber);
    }

    public HashMap<Integer, SemesterRecord> getSemesterRecords() {
        return semesterRecords;
    }

    @Override
    public double getTotalMarks() {
        double total = 0;

        for (Subject subject : subjects.values()) {
            total += subject.getMarks();
        }

        return total;
    }

    public double getPercentage() {
        if (subjects.isEmpty()) {
            return 0;
        }

        double maximumMarks = subjects.size() * 100.0;
        return (getTotalMarks() / maximumMarks) * 100;
    }

    @Override
    public void displayDetails() {
        System.out.println("\nSemester: " + semesterNumber);

        if (subjects.isEmpty()) {
            System.out.println("No subjects added.");
            return;
        }

        for (Subject subject : subjects.values()) {
            subject.displayDetails();
            System.out.println("-------------------");
        }

        System.out.println("Total Marks: " + getTotalMarks());
        System.out.printf("Percentage: %.2f%%%n", getPercentage());
    }


    // Check whether the student passed all subjects
    public boolean isPass() {

        if (subjects.isEmpty()) {
            return false;
        }

        for (Subject subject : subjects.values()) {

            if (subject.getMarks() < 40) {
                return false;
            }
        }

        return true;
    }

}
