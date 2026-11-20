
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
}
