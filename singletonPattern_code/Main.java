import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        QueueManager queueManager = QueueManager.getInstance();

        new OnlineQueueMonitor(queueManager);

        HelpDeskStation station1 = new HelpDeskStation(1);
        HelpDeskStation station2 = new HelpDeskStation(2);
        HelpDeskStation station3 = new HelpDeskStation(3);

        boolean running = true;

        System.out.println("==================================");
        System.out.println(" PAG-IBIG CENTRALIZED QUEUE SYSTEM");
        System.out.println("==================================");

        while (running) {

            System.out.println("\nCurrent Queue Number: "
                + queueManager.getCurrentNumber());

            System.out.println("\n1. Help Desk 1 - Get Next Number");
            System.out.println("2. Help Desk 2 - Get Next Number");
            System.out.println("3. Help Desk 3 - Get Next Number");
            System.out.println("4. Reset Queue Number");
            System.out.println("5. View Current Queue Number");
            System.out.println("0. Exit");

            System.out.print("\nEnter choice: ");

            String choice = scanner.nextLine().trim();

            try {

                switch (choice) {

                    case "1":
                        station1.callNextCustomer();
                        break;

                    case "2":
                        station2.callNextCustomer();
                        break;

                    case "3":
                        station3.callNextCustomer();
                        break;

                    case "4":

                        System.out.print("Enter station number (1-3): ");
                        int station = Integer.parseInt(
                            scanner.nextLine().trim()
                        );

                        if (station < 1 || station > 3) {
                            System.out.println("Invalid station.");
                            break;
                        }

                        System.out.print("Enter new queue number: ");
                        int newNumber = Integer.parseInt(
                            scanner.nextLine().trim()
                        );

                        if (newNumber < 0) {
                            System.out.println(
                                "Queue number cannot be negative."
                            );
                            break;
                        }

                        if (station == 1) {
                            station1.resetQueue(newNumber);
                        } else if (station == 2) {
                            station2.resetQueue(newNumber);
                        } else {
                            station3.resetQueue(newNumber);
                        }

                        break;

                    case "5":
                        System.out.println(
                            "Current Queue Number: "
                            + queueManager.getCurrentNumber()
                        );
                        break;

                    case "0":
                        running = false;
                        System.out.println(
                            "Thank you for using the system!"
                        );
                        break;

                    default:
                        System.out.println(
                            "Invalid choice. Please try again."
                        );
                }

            } catch (NumberFormatException e) {

                System.out.println(
                    "Please enter a valid whole number."
                );

            } catch (IllegalArgumentException e) {

                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
