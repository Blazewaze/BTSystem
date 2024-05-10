import java.util.ArrayList;
import java.util.Scanner;

class Ticket {
    static Scanner sc = new Scanner(System.in);
    private String name;
    private String travellingTo;
    private String travellingFrom;
    private boolean ticketVip = false;
    private Bus bus;
    private double cost;
    private static int ticket_id = 101;
    private static final double PRICE_PER_KM = 40;





    public void ticketGenerator(ArrayList<Bus> buses) {
        System.out.println("What is your Name");
        this.name = sc.nextLine();
        System.out.println("Travelling to ");
        this.travellingTo = sc.nextLine();
        System.out.println("Travelling from");
        this.travellingFrom = sc.nextLine();

        boolean busAvailable = false;

        for (Bus bus : buses) {
            if (bus.getTravellingFrom().equalsIgnoreCase(this.travellingFrom) && bus.getTravellingTo().equalsIgnoreCase(this.travellingTo)) {
                busAvailable = true;
                this.bus = bus;
                break;
            }
        }

        if (busAvailable) {
            System.out.println("The Bus is Available Right Now");
        } else {
            System.out.println("Bus Not Available Right Now");
        }

        System.out.println("Is this Ticket VIP or Not Y for yes N for no");
        String ch = sc.next();
        if (ch.equalsIgnoreCase("Y")) {
            this.ticketVip = true;
        }

        System.out.println("Estimated Distance in Kilometers");
        double kms;
        while (true) {
            try {
                kms = Double.parseDouble(sc.next());
                if (kms < 0) {
                    throw new IllegalArgumentException("Distance must be positive");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number:");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        this.cost = kms * (PRICE_PER_KM);
        System.out.println("Cost: "+  this.cost);
        ticket_id++;
    }

    public static void printAllTickets(ArrayList<Ticket> tickets){
        for(Ticket i: tickets){

            System.out.println("Person Name: " + i.name);
            System.out.println("Person Travelling From which City: " + i.travellingFrom);
            System.out.println("Person Travelling To which City: " + i.travellingTo);
            System.out.println("Ticket Vip: "+i.ticketVip);
            System.out.println("Total Cost: " + i.cost);


        }
    }



}