import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Bus> buses = new ArrayList<>();
    static ArrayList<Driver> drivers = new ArrayList<>();
    static ArrayList<Ticket> tickets = new ArrayList<>();
    static int busCount;
    static int ticketCount;
    static int driverCount;

    public static void main(String[] args) {
        int userChoiceMenu;
        do {
            System.out.println("WELCOME TO BUS TRANSPORTATION SYSTEM");
            System.out.println("1. Ticket");
            System.out.println("2. Buses");
            System.out.println("3. Drivers");
            System.out.println("4. Exit");
            userChoiceMenu = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (userChoiceMenu) {
                case 1:
                    System.out.println("1. Add Ticket");
                    int userChoiceTicket = scanner.nextInt();
                    if (userChoiceTicket == 1) {
                        tickets.add(new Ticket());
                        tickets.get(ticketCount).ticketGenerator(buses);
                        ticketCount++;
                    }
                    if(userChoiceTicket == 2){
                        Ticket.printAllTickets(tickets);
                    }
                    break;
                case 2:
                    System.out.println("1. Add a Bus");
                    System.out.println("2. View The Buses");
                    System.out.println("3. Assign The Bus to A driver");
                    int busChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    if (busChoice == 1) {
                        buses.add(new Bus());
                        buses.get(busCount).addBus();
                        busCount++;
                    } else if (busChoice == 2) {
                        for (Bus bus : buses) {
                            bus.printBuses(buses, drivers);
                        }
                    } else if (busChoice == 3) {
                        Bus.assignDriverToBus(buses, drivers);
                    }
                    break;
                case 3:
                    System.out.println("1. Add a Driver");
                    System.out.println("2. Find Driver by Name");
                    System.out.println("3. Print All Drivers");
                    int userChoiceDriver = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    if (userChoiceDriver == 1) {
                        drivers.add(new Driver());
                        drivers.get(driverCount).addDriver();
                        driverCount++;
                    } else if (userChoiceDriver == 2) {
                        System.out.println("Name of Driver");
                        String name = scanner.nextLine();
                        if (Driver.driverFind(drivers, name)) {
                            System.out.println("Driver Exists");
                        } else {
                            System.out.println("Doesn't Exist");
                        }
                    } else if (userChoiceDriver == 3) {
                        Driver.printAll(drivers);
                    }
                    break;
            }

        } while (userChoiceMenu != 4);
    }
}
