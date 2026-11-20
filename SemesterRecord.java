
import java.util.HashMap;

public class SemesterRecord extends AcademicRecord {

    private int semesterNumber;

    private HashMap<String, Subject> subjects;

    public SemesterRecord(int semesterNumber) {

        if (semesterNumber <= 0) {
            throw new IllegalArgumentException("Invalid semester number.");
        }

        this.semesterNumber = semesterNumber;
        subjects = new HashMap<>();
    }

    public int getSemesterNumber() {
        return semesterNumber;
    }

    public HashMap<String, Subject> getSubjects() {
        return subjects;
    }

    public void addOrUpdateSubject(String name, double marks, int credits) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Subject name cannot be empty.");
        }

        String key = name.trim();

        if (subjects.containsKey(key)) {

            Subject existingSubject = subjects.get(key);
            existingSubject.setMarks(marks);
            existingSubject.setCredits(credits);

            System.out.println("Subject details updated successfully!");

        } else {

            Subject newSubject = new Subject(key, marks, credits);
            subjects.put(key, newSubject);

            System.out.println("Subject added successfully!");
        }
    }

    @Override
    public double getTotalMarks() {

        double total = 0;

        for (Subject subject : subjects.values()) {
            total += subject.getMarks();
        }

        return total;
    }

    public double getMaximumMarks() {
        return subjects.size() * 100.0;
    }

    public int getTotalCredits() {

        int totalCredits = 0;

        for (Subject subject : subjects.values()) {
            totalCredits += subject.getCredits();
        }

        return totalCredits;
    }

    @Override
    public void displayDetails() {

        System.out.println("\n===== SEMESTER " + semesterNumber + " RECORD =====");

        if (subjects.isEmpty()) {
            System.out.println("No subjects added yet.");
            return;
        }

        for (Subject subject : subjects.values()) {
            System.out.println("--------------------");
            subject.displayDetails();
        }

        System.out.println("--------------------");
        System.out.println("Total Marks: " + getTotalMarks());
        System.out.println("Maximum Marks: " + getMaximumMarks());
        System.out.println("Total Credits: " + getTotalCredits());
    }
}
