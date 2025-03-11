public class TaskScheduler {
    private Task head;
    private Task current;

    public void addTask(int taskID, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskID, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.setNext(head);
            current = head;
        } else {
            Task temp = head;
            while (temp.getNext() != head) {
                temp = temp.getNext();
            }
            temp.setNext(newTask);
            newTask.setNext(head);
        }
    }

    public void addTaskAtBeginning(int taskID, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskID, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.setNext(head);
            current = head;
        } else {
            Task temp = head;
            while (temp.getNext() != head) {
                temp = temp.getNext();
            }
            newTask.setNext(head);
            temp.setNext(newTask);
            head = newTask;
        }
    }

    public void addTaskAtPosition(int position, int taskID, String taskName, int priority, String dueDate) {
        if (position == 1) {
            addTaskAtBeginning(taskID, taskName, priority, dueDate);
            return;
        }
        Task newTask = new Task(taskID, taskName, priority, dueDate);
        Task temp = head;
        int count = 1;
        while (temp.getNext() != head && count < position - 1) {
            temp = temp.getNext();
            count++;
        }
        newTask.setNext(temp.getNext());
        temp.setNext(newTask);
    }

    public void removeTask(int taskID) {
        if (head == null) {
            System.out.println("Task list is empty!");
            return;
        }
        if (head.getTaskID() == taskID) {
            Task temp = head;
            while (temp.getNext() != head) {
                temp = temp.getNext();
            }
            if (head == head.getNext()) {
                head = null;
            } else {
                temp.setNext(head.getNext());
                head = head.getNext();
            }
            System.out.println("Task with ID " + taskID + " removed.");
            return;
        }
        Task curr = head, prev = null;
        do {
            prev = curr;
            curr = curr.getNext();
            if (curr.getTaskID() == taskID) {
                prev.setNext(curr.getNext());
                System.out.println("Task with ID " + taskID + " removed.");
                return;
            }
        } while (curr != head);
        System.out.println("Task with ID " + taskID + " not found.");
    }

    public void viewCurrentTask() {
        if (current == null) {
            System.out.println("No tasks available!");
            return;
        }
        System.out.println("Current Task -> ID: " + current.getTaskID() + ", Name: " + current.getTaskName() + ", Priority: " + current.getPriority() + ", Due Date: " + current.getDueDate());
        current = current.getNext();
    }

    public void searchTaskByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks in the list!");
            return;
        }
        Task temp = head;
        boolean found = false;
        do {
            if (temp.getPriority() == priority) {
                System.out.println("Found Task -> ID: " + temp.getTaskID() + ", Name: " + temp.getTaskName() + ", Due Date: " + temp.getDueDate());
                found = true;
            }
            temp = temp.getNext();
        } while (temp != head);
        if (!found) {
            System.out.println("No tasks found with priority " + priority);
        }
    }

    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks in the list!");
            return;
        }
        Task temp = head;
        do {
            System.out.println("Task ID: " + temp.getTaskID() + " Task Name: " + temp.getTaskName() + " Priority: " + temp.getPriority() + " Due Date: " + temp.getDueDate());
            temp = temp.getNext();
        } while (temp != head);
    }
}
