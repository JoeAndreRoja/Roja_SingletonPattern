public class HelpDeskStation{
    private int stationNumber;
    private QueueManager queueManager;

    public HelpDeskStation(int stationNumber) {
        if (stationNumber < 1 || stationNumber > 3) {
            throw new IllegalArgumentException("Station number must be between 1 and 3.");
        }
        this.stationNumber = stationNumber;
        this.queueManager = QueueManager.getInstance();
    }
    public int callNextCustomer() {
        int number = queueManager.issueNextNumber();
        System.out.println("Help Desk " + stationNumber + " issued queue number: " + number);
        return number;
    }
 public void resetQueue(int number) {

        queueManager.resetNumber(number);

        System.out.println(
            "Help Desk " + stationNumber +
            " reset the queue number to: " + number
        );
    }

    public int getStationNumber() {
        return stationNumber;
    }
}