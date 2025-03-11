public class Main {
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

        list.delete(1);

        list.search(4);

        list.updateGrade(4, 'A');

        StudentLinkedList.traverse(list);
    }
}