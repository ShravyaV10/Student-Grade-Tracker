
import java.util.HashMap;
import java.util.HashSet;
public class SemesterRecord extends AcademicRecord {

    private int semesterNumber;
    private HashMap<String, Subject> subjects;
    private HashSet<String> registeredSubjects;


    // Constructor
    public SemesterRecord(int semesterNumber) {

        if (semesterNumber <= 0) {
            throw new IllegalArgumentException(
                "Semester number must be positive."
            );
        }

        this.semesterNumber = semesterNumber;
        subjects = new HashMap<>();
        registeredSubjects=new HashSet<>();
    }

    // Get semester number
    public int getSemesterNumber() {
        return semesterNumber;
    }

    // Get all subjects
    public HashMap<String, Subject> getSubjects() {
        return subjects;
    }

    // Add a subject
    public void addSubject(Subject subject) {

        if (subject == null) {
            throw new IllegalArgumentException(
                "Subject cannot be null."
            );
        }

        subjects.put(
            subject.getSubjectName().toLowerCase(),
            subject
        );

        System.out.println("Subject added successfully!");
    }

    // Calculate total marks
    @Override
    public double getTotalMarks() {

        double total = 0;

        for (Subject subject : subjects.values()) {
            total += subject.getMarks();
        }

        return total;
    }

    // Calculate percentage
    public double getPercentage() {

        if (subjects.isEmpty()) {
            return 0;
        }

        double maximumMarks = subjects.size() * 100.0;

        return (getTotalMarks() / maximumMarks) * 100;
    }

    // Display semester details
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

        System.out.printf(
            "Percentage: %.2f%%%n",
            getPercentage()
        );
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
    public void registerSubject(String subjectName) {
    if (subjectName == null || subjectName.trim().isEmpty()) {
        throw new IllegalArgumentException("Invalid subject name.");
    }

    registeredSubjects.add(subjectName.toLowerCase());
}
public HashSet<String> getRegisteredSubjects() {
    return registeredSubjects;
}
}
