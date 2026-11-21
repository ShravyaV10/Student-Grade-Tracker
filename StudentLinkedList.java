
public class StudentLinkedList {

    private class Node {
        Student data;
        Node next;

        Node(Student data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public StudentLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(Student student) {
        if (student == null) {
            return;
        }

        Node newNode = new Node(student);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public Student get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node current = head;
        int count = 0;

        while (current != null) {
            if (count == index) {
                return current.data;
            }
            count++;
            current = current.next;
        }

        return null;
    }


    public Student searchById(int studentId) {
        Node current = head;

        while (current != null) {
            if (current.data.getStudentId() == studentId) {
                return current.data;
            }
            current = current.next;
        }

        return null;
    }

    public void displayAll() {
        Node current = head;
        int index = 1;

        while (current != null) {
            System.out.println("\nStudent " + index);
            current.data.DisplayDetails();
            current = current.next;
            index++;
        }
    }
}
