
import java.util.ArrayList;
import java.util.List;

public class QueueManager {

    private static final QueueManager instance = new QueueManager();

    private int currentNumber = 0;
    private List<QueueObserver> observers = new ArrayList<>();

    private QueueManager() {
    }

    public static QueueManager getInstance() {
        return instance;
    }

    public synchronized int getCurrentNumber() {
        return currentNumber;
    }

    public synchronized int issueNextNumber() {
        currentNumber++;
        notifyObservers("New queue number issued");
        return currentNumber;
    }

    public synchronized void resetNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(
                "Queue number cannot be negative."
            );
        }

        currentNumber = number;
        notifyObservers("Queue number reset");
    }

    public synchronized void addObserver(QueueObserver observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public synchronized void removeObserver(QueueObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(String action) {
        List<QueueObserver> copy = new ArrayList<>(observers);

        for (QueueObserver observer : copy) {
            observer.onQueueNumberChanged(currentNumber, action);
        }
    }
}
