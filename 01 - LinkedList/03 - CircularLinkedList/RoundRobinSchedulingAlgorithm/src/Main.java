public class Main {
    public static void main(String[] args) {
        SchedulerProcess scheduler = new SchedulerProcess(4);

        scheduler.addProcess(1, 10, 2);
        scheduler.addProcess(2, 4, 1);
        scheduler.addProcess(3, 7, 3);
        scheduler.addProcess(4, 2, 1);

        System.out.println("Initial Process Queue:");
        scheduler.display();

        scheduler.execute();
    }
}