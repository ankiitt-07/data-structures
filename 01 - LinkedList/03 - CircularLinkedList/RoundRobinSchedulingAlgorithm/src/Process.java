public class Process {
    private int processID;
    private int burstTime;
    private int priority;
    private Process next;

    public Process(int processID, int burstTime, int priority) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }

    public int getProcessID() {
        return processID;
    }
    public void setProcessId(int processID) {
        this.processID = processID;
    }

    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getBurstTime() {
        return burstTime;
    }
    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public Process getNext() {
        return next;
    }
    public void setNext(Process next) {
        this.next = next;
    }
}
