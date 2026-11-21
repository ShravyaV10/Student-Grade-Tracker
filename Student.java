import java.util.HashMap;
import exceptions.InvalidStudentException;

public class Student{
    private int SId;
    private String name;
    private String dept;
    private int year;
    private int curSem;
    private HashMap<Integer, SemesterRecord> semesterRecords;

    public Student(int sid,String name,String dept,int year,int curSem )
        throws InvalidStudentException {    
        if (sid <= 0) {
        throw new InvalidStudentException("Student ID must be positive.");
    }

    

    this.SId = sid;
    
    this.semesterRecords = new HashMap<>();

    setName(name);
    setDept(dept);
    setYear(year);
    setCurSem(curSem);
    }

    //Get Student Details
    public int getStudentId() {
        return SId;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public int getYear() {
        return year;
    }

    public int getCurSem(){
        return curSem;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setDept(String dept){
        this.dept=dept;
    }

    public void setYear(int year){
        this.year=year;
    }

    public void setCurSem(int curSem){
        this.curSem=curSem;
    }

    public void DisplayDetails(){
        System.out.println("Student ID: " + SId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + dept);
        System.out.println("Year: " + year);
        System.out.println("Semester: " + curSem);
    }


    public void addSemesterRecord(SemesterRecord record) {

        if (record == null) {
            throw new IllegalArgumentException(
                "Semester record cannot be null."
            );
        }

        semesterRecords.put(record.getSemesterNumber(), record);
    }

    public SemesterRecord getSemesterRecord(int semesterNumber) {

        return semesterRecords.get(semesterNumber);
    }

    public HashMap<Integer, SemesterRecord> getSemesterRecords() {

        return semesterRecords;
    }

}
