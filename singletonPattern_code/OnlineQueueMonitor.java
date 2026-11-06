
public class OnlineQueueMonitor implements QueueObserver {

    public OnlineQueueMonitor(QueueManager queueManager) {
        queueManager.addObserver(this);
    }

    @Override
    public void onQueueNumberChanged(
        int currentNumber, String action
    ) {

        System.out.println("\n===== ONLINE QUEUE MONITOR =====");
        System.out.println("Update: " + action);
        System.out.println("Current Queue Number: " + currentNumber);
        System.out.println("================================\n");
    }
}
