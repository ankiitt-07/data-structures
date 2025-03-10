// class Student{
//     private int rollNumber;
//     private String name;
//     private int age;
//     private char grade;

//     public int getRollNumber() {
//         return rollNumber;
//     }
//     public void setRollNumber(int rollNumber) {
//         this.rollNumber = rollNumber;
//     }

//     public String getName() {
//         return name;
//     }
//     public void setName(String name) {
//         this.name = name;
//     }

//     public int getAge() {
//         return age;
//     }
//     public void setAge(int age) {
//         this.age = age;
//     }

//     public char getGrade() {
//         return grade;
//     }
//     public void setGrade(char grade) {
//         this.grade = grade;
//     }


//     public Student(int rollNumber, String name, int age, char grade) {
//         this.rollNumber = rollNumber;
//         this.name = name;
//         this.age = age;
//         this.grade = grade;
//     }
// }

// class StudentListNode{
//     private Student student;
//     private StudentListNode next;

//     public StudentListNode(Student student){
//         this.student = student;
//         this.next = null;
//     }

//     public Student getStudent() {
//         return student;
//     }
//     public void setStudent(Student student) {
//         this.student = student;
//     }

//     public StudentListNode getNext() {
//         return next;
//     }
//     public void setNext(StudentListNode next) {
//         this.next = next;
//     }

// }

// class StudentLinkedList{

//     private StudentListNode head;

//     public StudentLinkedList(){
//         this.head = null;
//     }

//     //Insert At End

//     void insertAtEnd(Student student){
//         StudentListNode node = new StudentListNode(student);

//         if(head == null){
//             head = node;
//             return;
//         }
//         else{
//             StudentListNode temp = head;
//             while (temp.getNext() != null) {
//                 temp = temp.getNext();
//             }
//             temp.setNext(node);
//          }
//     }
    
//     // Insert At Begining
//     void insertAtHead(Student student){
//         StudentListNode node = new StudentListNode(student);

//         if(head == null){
//             head = node;
//         }
//         else{
//             StudentListNode temp = head;
//             head = temp;
//             temp.setNext(temp);
//         }
//     }

//     // Insert At Specific Position

//     // public void insertAtPosition(Student student, int index) {
//     //     StudentListNode newNode = new StudentListNode(student);
        
//     //     if (index <= 0 || head == null) {
//     //         newNode.setNext(head);
//     //         head = newNode;
//     //         return;
//     //     }
        
//     //     StudentListNode current = head;
//     //     int currentIndex = 0;
        
//     //     while (currentIndex < index - 1 && current.getNext() != null) {
//     //         current = current.getNext();
//     //         currentIndex++;
//     //     }
        
//     //     newNode.setNext(current.getNext());
//     //     current.setNext(newNode);
//     // }

//     public void insertAtPosition(Student student, int index) {
//         StudentListNode t = new StudentListNode(student);
//         StudentListNode temp = head;

//         if (head == null) {
//             insertAtHead(student);
//             return;
//         }
//         else if(index==size()){
//             insertAtEnd(student);
//             return;
//         }
//         else if(index < 0 || index>size()){
//             System.out.println("Wrong Index");
//             return;
//         } 
//         for(int i=0;i<index-1;i++){
//             temp = temp.getNext();
//         }

//         t.setNext(temp.getNext());
//         temp.setNext(t);
       
//     }

//     public void delete(int rollNumber) {
//         if (head == null) {
//             return;
//         }
        
//         // If the head is the node to be deleted, update head.
//         if (head.getStudent().getRollNumber() == rollNumber) {
//             head = head.getNext();
//             return;
//         }
        
//         StudentListNode current = head;
        
//         // Check the next node for deletion.
//         while (current.getNext() != null) {
//             if (current.getNext().getStudent().getRollNumber() == rollNumber) {
//                 // Bypass the node to delete it.
//                 current.setNext(current.getNext().getNext());
//                 return;
//             }
//             current = current.getNext();
//         }
//     }
    

//     public void search(int rollNumber) {
//         StudentListNode current = head;
//         while (current != null) {
//             if (current.getStudent().getRollNumber() == rollNumber) {
//                 displayDetails(current.getStudent());
//                 return;
//             }
//             current = current.getNext();
//         }
//     }

//     public void updateGrade(int rollNumber, char newGrade) {
//         StudentListNode current = head;
//         while (current != null) {
//             if (current.getStudent().getRollNumber() == rollNumber) {
//                 current.getStudent().setGrade(newGrade);
//                 return;
//             }
//             current = current.getNext();
//         }
//     }
    
    

//     public int size() {
//         int count = 0;
//         StudentListNode temp = head;
//         while (temp != null) {
//             count++;
//             temp = temp.getNext();
//         }
//         return count;
//     }

//     public static void displayDetails(Student student) {
//         System.out.println("Student Name: " + student.getName());
//         System.out.println("Student Roll No: " + student.getRollNumber());
//         System.out.println("Student Grade: " + student.getGrade());
//     }

//     public static void traverse(StudentLinkedList list){
//         StudentListNode temp = list.head;
//         while(temp != null){
//             displayDetails(temp.getStudent());
//             temp = temp.getNext();
//         }
//     }

// }
// public class StudentRecordManagement {
//     public static void main(String[] args) {
//         Student s1 = new Student(1, "Jerry", 19, 'A');
//         Student s2 = new Student(2, "Shadow", 20, 'B');
//         Student s3 = new Student(3, "Sakura", 21, 'C');
//         Student s4 = new Student(4, "Ankit", 22, 'D');

//         StudentLinkedList list = new StudentLinkedList();
//         list.insertAtHead(s1);
//         list.insertAtHead(s2);
//         list.insertAtHead(s3);
//         list.insertAtPosition(s4, 1);
//         System.out.println("Delete");
//         list.delete(1);

//         System.out.println("Search");
//         list.search(4);

//         System.out.println("Grade Update");
//         list.updateGrade(4, 'A');

//         StudentLinkedList.traverse(list);
//     }
// }



class Student {
    private int rollNumber;
    private String name;
    private int age;
    private char grade;

    public int getRollNumber() {
        return rollNumber;
    }
    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public char getGrade() {
        return grade;
    }
    public void setGrade(char grade) {
        this.grade = grade;
    }

    public Student(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}

class StudentListNode {
    private Student student;
    private StudentListNode next;

    public StudentListNode(Student student) {
        this.student = student;
        this.next = null;
    }

    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentListNode getNext() {
        return next;
    }
    public void setNext(StudentListNode next) {
        this.next = next;
    }
}

class StudentLinkedList {
    private StudentListNode head;

    public StudentLinkedList() {
        this.head = null;
    }

    // Insert at End
    void insertAtEnd(Student student) {
        StudentListNode node = new StudentListNode(student);
        if (head == null) {
            head = node;
            return;
        } else {
            StudentListNode temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(node);
        }
    }
    
    // Insert at Beginning
    void insertAtHead(Student student) {
        StudentListNode node = new StudentListNode(student);
        node.setNext(head);
        head = node;
    }

    // Insert at Specific Position (0-indexed)
    public void insertAtPosition(Student student, int index) {
        if (index <= 0) {
            insertAtHead(student);
            return;
        }
        if (index == size()) {
            insertAtEnd(student);
            return;
        }
        if (index > size()) {
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
    }

    public void delete(int rollNumber) {
        if (head == null) {
            return;
        }
        // If head is the node to be deleted.
        if (head.getStudent().getRollNumber() == rollNumber) {
            head = head.getNext();
            return;
        }
        StudentListNode current = head;
        // Traverse and check the next node.
        while (current.getNext() != null) {
            if (current.getNext().getStudent().getRollNumber() == rollNumber) {
                current.setNext(current.getNext().getNext());
                return;
            }
            current = current.getNext();
        }
    }
    
    public void search(int rollNumber) {
        StudentListNode current = head;
        while (current != null) {
            if (current.getStudent().getRollNumber() == rollNumber) {
                displayDetails(current.getStudent());
                return;
            }
            current = current.getNext();
        }
    }

    public void updateGrade(int rollNumber, char newGrade) {
        StudentListNode current = head;
        while (current != null) {
            if (current.getStudent().getRollNumber() == rollNumber) {
                current.getStudent().setGrade(newGrade);
                return;
            }
            current = current.getNext();
        }
    }
    
    public int size() {
        int count = 0;
        StudentListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
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
}

public class StudentRecordManagement {
    public static void main(String[] args) {
        Student s1 = new Student(1, "Jerry", 19, 'A');
        Student s2 = new Student(2, "Shadow", 20, 'B');
        Student s3 = new Student(3, "Sakura", 21, 'C');
        Student s4 = new Student(4, "Ankit", 22, 'D');

        StudentLinkedList list = new StudentLinkedList();
        list.insertAtHead(s1);
        list.insertAtHead(s2);
        list.insertAtHead(s3);
        list.insertAtPosition(s4, 1); // Inserts s4 at index 1
        
        System.out.println("Delete");
        list.delete(1);

        System.out.println("Search");
        list.search(4);

        System.out.println("Grade Update");
        list.updateGrade(4, 'A');

        StudentLinkedList.traverse(list);
    }
}
