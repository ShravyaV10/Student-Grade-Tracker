
import java.util.ArrayList;
import java.util.Collections;

public class ReportCard {

    private GradeCalculator calculator;

    public ReportCard() {
        calculator = new GradeCalculator();
    }

    // Generate complete report card
    public void generate(Student student) {

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.println("\n========================================");
        System.out.println("             STUDENT REPORT CARD");
        System.out.println("========================================");

        student.DisplayDetails();

        ArrayList<Integer> semesters =
                new ArrayList<>(student.getSemesterRecords().keySet());

        Collections.sort(semesters);

        if (semesters.isEmpty()) {
            System.out.println("No academic records available.");
            return;
        }

        for (int semesterNumber : semesters) {

            SemesterRecord record =
                    student.getSemesterRecord(semesterNumber);

            System.out.println("\nSemester: " + semesterNumber);

            System.out.printf("%-20s %-10s %-10s %-10s%n",
                    "Subject", "Marks", "Credits", "Grade");

            for (Subject subject : record.getSubjects().values()) {

                String grade = calculator.getGrade(subject.getMarks());

                System.out.printf("%-20s %-10.2f %-10d %-10s%n",
                        subject.getSubjectName(),
                        subject.getMarks(),
                        subject.getCredits(),
                        grade);
            }

            System.out.printf("Total Marks: %.2f / %.2f%n",
                    record.getTotalMarks(),
                    record.getSubjects().size() * 100.0);

            System.out.printf("Percentage: %.2f%%%n",
                    record.getPercentage());

            System.out.println("Result: " +
                    (record.isPass() ? "PASS" : "FAIL"));

            System.out.printf("SGPA: %.2f%n",
                    calculator.calculateSGPA(record));
        }

        System.out.printf("\nOverall CGPA: %.2f%n",
                calculator.calculateCGPA(student));

        System.out.println("========================================");
    }
}
