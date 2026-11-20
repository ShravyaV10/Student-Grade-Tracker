
public class GradeCalculator {

    // Calculate grade based on marks
    public String getGrade(double marks) {

        if (marks >= 90) {
            return "O";
        } else if (marks >= 80) {
            return "A+";
        } else if (marks >= 70) {
            return "A";
        } else if (marks >= 60) {
            return "B+";
        } else if (marks >= 50) {
            return "B";
        } else if (marks >= 40) {
            return "C";
        } else {
            return "F";
        }
    }

    // Calculate grade points
    public int getGradePoint(double marks) {

        if (marks >= 90) {
            return 10;
        } else if (marks >= 80) {
            return 9;
        } else if (marks >= 70) {
            return 8;
        } else if (marks >= 60) {
            return 7;
        } else if (marks >= 50) {
            return 6;
        } else if (marks >= 40) {
            return 5;
        } else {
            return 0;
        }
    }

    // Calculate overall grade from percentage
    public String getOverallGrade(double percentage) {
        return getGrade(percentage);
    }


    // Calculate SGPA for one semester
    public double calculateSGPA(SemesterRecord record) {

        if (record == null || record.getSubjects().isEmpty()) {
            return 0;
        }

        double totalGradePoints = 0;
        int totalCredits = 0;

        for (Subject subject : record.getSubjects().values()) {

            int gradePoint = getGradePoint(subject.getMarks());

            totalGradePoints += subject.getCredits() * gradePoint;

            totalCredits += subject.getCredits();
        }

        if (totalCredits == 0) {
            return 0;
        }

        return totalGradePoints / totalCredits;
    }


    // Calculate CGPA across all semesters
    public double calculateCGPA(Student student) {

        if (student == null) {
            return 0;
        }

        double totalGradePoints = 0;
        int totalCredits = 0;

        for (SemesterRecord record :
                student.getSemesterRecords().values()) {

            for (Subject subject : record.getSubjects().values()) {

                int gradePoint = getGradePoint(subject.getMarks());

                totalGradePoints += subject.getCredits() * gradePoint;

                totalCredits += subject.getCredits();
            }
        }

        if (totalCredits == 0) {
            return 0;
        }

        return totalGradePoints / totalCredits;
    }

}
