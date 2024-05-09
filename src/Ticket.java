import java.util.ArrayList;
import java.util.Scanner;

public class Ticket {
    static Scanner sc = new Scanner(System.in);
    private String name;
    private String TravellingTo;
    private String TravellingFrom;
    private boolean ticketVip = false;
    private double Cost;
    private static double PRICE_PER_KM = 40;



    public void ticketgenerator(ArrayList<Bus> buses){
        System.out.println("What is your Name");
        this.name = sc.nextLine();
        System.out.println("Travelling to ");
        this.TravellingTo = sc.nextLine();
        System.out.println("Travelling from");
        this.TravellingTo = sc.nextLine();

        boolean bus_avaliable = false;

        for(Bus i: buses){
            if(i.getTravellingFrom().equalsIgnoreCase(this.TravellingFrom) && i.getTravellingTo().equalsIgnoreCase(this.TravellingTo)){
                bus_avaliable = true;
                break;
            }
        }

        if(bus_avaliable) {
            System.out.println("The Bus is Avaliable Right Now");
        }
        else{
                System.out.println("Bus Not avaliable Right Now");
            }


            System.out.println("Is this Ticket VIP or Not Y for yes N for no");
            String ch = sc.next();
            if (ch.equalsIgnoreCase("Y")) {
                this.ticketVip = true;
            }

            System.out.println("Estimated Distance in KiloMeters");
            double kms = sc.nextDouble();

            this.Cost = kms * (PRICE_PER_KM);



    }





}
