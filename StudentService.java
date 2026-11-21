import java.util.HashSet;
import exceptions.DuplicateStudentException;
import exceptions.InvalidStudentException;

public class StudentService {
    // Replaced ArrayList<Student> with custom StudentLinkedList
    private StudentLinkedList students;
    private HashSet<Integer> SIds;

    public StudentService() {
        students = new StudentLinkedList();
        SIds = new HashSet<>();
    }

    public void registerStudent(Student student)
            throws DuplicateStudentException, InvalidStudentException {

        if (student == null) {
            throw new InvalidStudentException("Student cannot be null.");
        }

        if (SIds.contains(student.getStudentId())) {
            throw new DuplicateStudentException("Student ID already exists.");
        }

        students.add(student);
        SIds.add(student.getStudentId());

        System.out.println("Student registered successfully!");
    }

    public void displayAllStudents() {

        if (students.isEmpty()) {
            System.out.println("No students registered yet.");
            return;
        }

        System.out.println("===== ALL STUDENTS =====");
        students.displayAll();
    }

    public Student searchStudent(int studentId) {
        return students.searchById(studentId);
    }

    public void updateStudent(int studentId, String name, String department, int year, int semester) {
        Student student = searchStudent(studentId);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        student.setName(name);
        student.setDept(department);
        student.setYear(year);
        student.setCurSem(semester);

        System.out.println("Student details updated successfully!");
    }
}
