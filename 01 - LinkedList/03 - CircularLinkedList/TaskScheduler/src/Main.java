public class Main {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addTask(1, "Task1", 1, "2025-03-11");
        scheduler.addTask(2, "Task2", 2, "2025-03-12");
        scheduler.addTaskAtBeginning(3, "Urgent Task", 0, "2025-03-10");
        scheduler.addTaskAtPosition(2, 4, "Mid Task", 2, "2025-03-11");
        scheduler.displayTasks();
        scheduler.viewCurrentTask();
        scheduler.removeTask(2);
        scheduler.searchTaskByPriority(2);
        scheduler.displayTasks();
    }
}