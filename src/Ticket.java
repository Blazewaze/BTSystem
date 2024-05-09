import java.util.Scanner;

public class Ticket {
    static Scanner sc = new Scanner(System.in);
    private String name;
    private String TravellingTo;
    private String TravellingFrom;
    private int Cost;



    public void ticketgenerator(){
        System.out.println("What is your Name");
        this.name = sc.nextLine();
        System.out.println("Travelling to ");
        this.TravellingTo = sc.nextLine();
        System.out.println("Travelling from");
        this.TravellingTo = sc.nextLine();

    }
    private int costCal(){
        if(this.TravellingFrom.equalsIgnoreCase("Rawalpindi") && this.TravellingTo.equalsIgnoreCase("Karachi")){
            return  8000;
        }
        else if(this.TravellingFrom.equalsIgnoreCase("Rawalpindi") && this.TravellingTo.equalsIgnoreCase("Islamabad")){
            return  500;
        }
        else if(this.TravellingFrom.equalsIgnoreCase("Rawalpindi") && this.TravellingTo.equalsIgnoreCase("Lahore")){
            return 6000;
        }
        return 9000;
    }


}
