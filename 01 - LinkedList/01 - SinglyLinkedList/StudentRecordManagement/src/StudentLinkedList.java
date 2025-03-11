public class StudentLinkedList {
    private StudentListNode head;
    int size = 0;

    public StudentLinkedList() {
        this.head = null;
    }

    public static void displayDetails(Student student) {
        System.out.println("Student Name: " + student.getName());
        System.out.println("Student Roll No: " + student.getRollNumber());
        System.out.println("Student Grade: " + student.getGrade());
    }

    public static void traverse(StudentLinkedList list) {
        StudentListNode temp = list.head;
        while (temp != null) {
            displayDetails(temp.getStudent());
            temp = temp.getNext();
        }
    }

    public void insertAtEnd(Student student) {
        StudentListNode node = new StudentListNode(student);
        if (head == null) {
            head = node;
            return;
        }
        StudentListNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(node);
        size++;
    }

    public void insertAtPosition(Student student, int index) {
        if (index <= 0) {
            insertAtHead(student);
            return;
        }
        if (index == size) {
            insertAtEnd(student);
            return;
        }
        if (index > size) {
            System.out.println("Wrong Index");
            return;
        }
        StudentListNode newNode = new StudentListNode(student);
        StudentListNode temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.getNext();
        }
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
        size++;
    }

//    public int size() {
//        int count = 0;
//        StudentListNode temp = head;
//        while (temp != null) {
//            count++;
//            temp = temp.getNext();
//        }
//        return count;
//    }

    public void insertAtHead(Student student) {
        StudentListNode node = new StudentListNode(student);
        if (head == null) {
            head = node;
            return;
        }
        StudentListNode temp = head;
        head = node;
        node.setNext(temp);
        size++;
    }

    public void delete(int rollNumber) {
        if (head == null) {
            return;
        }

        if (head.getStudent().getRollNumber() == rollNumber) {
            head = head.getNext();
            return;
        }

        StudentListNode temp = head;
        StudentListNode tempPrev = null;

        while (temp != null && temp.getStudent().getRollNumber() != rollNumber) {
            tempPrev = temp;
            temp = temp.getNext();
        }

        if (temp != null && tempPrev != null) {
            tempPrev.setNext(temp.getNext());
        }
    }

    public void search(int rollNumber) {
        if (head == null) {
            return;
        }

        if (head.getStudent().getRollNumber() == rollNumber) {
            displayDetails(head.getStudent());
            return;
        }

        StudentListNode temp = head;
        while (temp != null && temp.getStudent().getRollNumber() != rollNumber) {
            temp = temp.getNext();
        }
        if (temp != null) {
            displayDetails(temp.getStudent());
        }
    }


    public void updateGrade(int rollNumber, char newGrade) {
        if (head == null) {
            return;
        }

        if (head.getStudent().getRollNumber() == rollNumber) {
            head.getStudent().setGrade(newGrade);
            return;
        }

        StudentListNode temp = head;
        while (temp != null && temp.getStudent().getRollNumber() != rollNumber) {
            temp = temp.getNext();
        }
        if (temp != null) {
            temp.getStudent().setGrade(newGrade);
        }
    }
}
