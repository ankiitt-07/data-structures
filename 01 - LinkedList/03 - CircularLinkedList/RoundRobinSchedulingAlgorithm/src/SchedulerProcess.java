public class SchedulerProcess {
    private Process head;
    private Process current;
    private int quantumTime;

    public SchedulerProcess(int quantumTime) {
        this.quantumTime = quantumTime;
    }

    public void addProcess(int processID, int burstTime, int priority) {
        Process newProcess = new Process(processID, burstTime, priority);
        if (head == null) {
            head = newProcess;
            newProcess.setNext(head);
            current = head;
        } else {
            Process temp = head;
            while (temp.getNext() != head) {
                temp = temp.getNext();
            }
            temp.setNext(newProcess);
            newProcess.setNext(head);
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("No processes in the queue!");
            return;
        }
        Process temp = head;
        do {
            System.out.println("Process ID: " + temp.getProcessID() + " | Burst Time: " + temp.getBurstTime() + " | Priority: " + temp.getPriority());
            temp = temp.getNext();
        } while (temp != head);
    }

    public void execute() {
        if (head == null) {
            System.out.println("No processes to execute.");
            return;
        }

        System.out.println("\nExecuting Processes with Time Quantum: " + quantumTime);

        int totalWaitingTime = 0, totalTurnaroundTime = 0, processCount = 0;

        while (head != null) {
            if (current.getBurstTime() > quantumTime) {
                System.out.println("Process ID: " + current.getProcessID() + " executed for " + quantumTime + " units.");
                current.setBurstTime(current.getBurstTime() - quantumTime);
                current = current.getNext();
            } else {
                System.out.println("Process ID: " + current.getProcessID() + " completed execution.");

                totalTurnaroundTime += current.getBurstTime();
                totalWaitingTime += totalTurnaroundTime - current.getBurstTime();
                processCount++;

                removeProcess(current.getProcessID());

                if (head == null) break;
                current = current.getNext();
            }
        }

        if (processCount > 0) {
            System.out.println("\nAverage Waiting Time: " + (double) totalWaitingTime / processCount);
            System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / processCount);
        }
    }

    public void removeProcess(int processID) {
        if (head == null) return;

        Process temp = head, prev = null;

        if (head.getProcessID() == processID) {
            while (temp.getNext() != head) {
                temp = temp.getNext();
            }
            if (head == head.getNext()) {
                head = null;
            } else {
                temp.setNext(head.getNext());
                head = head.getNext();
            }
            return;
        }

        do {
            prev = temp;
            temp = temp.getNext();

            if (temp.getProcessID() == processID) {
                prev.setNext(temp.getNext());
                return;
            }
        } while (temp != head);
    }
}
