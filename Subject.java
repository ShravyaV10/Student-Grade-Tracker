
public class Subject {

    private String subjectName;
    private double marks;
    private int credits;

    public Subject(String subjectName, double marks, int credits) {
        setSubjectName(subjectName);
        setMarks(marks);
        setCredits(credits);
    }

    public String getSubjectName() {
        return subjectName;
    }

    public double getMarks() {
        return marks;
    }

    public int getCredits() {
        return credits;
    }

    public void setSubjectName(String subjectName) {
        if (subjectName == null || subjectName.trim().isEmpty()) {
            throw new IllegalArgumentException("Subject name cannot be empty.");
        }
        this.subjectName = subjectName;
    }

    public void setMarks(double marks) {
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100.");
        }
        this.marks = marks;
    }

    public void setCredits(int credits) {
        if (credits <= 0) {
            throw new IllegalArgumentException("Credits must be positive.");
        }
        this.credits = credits;
    }

    public void displayDetails() {
        System.out.println("Subject: " + subjectName);
        System.out.println("Marks: " + marks);
        System.out.println("Credits: " + credits);
    }
}
