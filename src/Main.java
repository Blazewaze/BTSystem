
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Bus> buses = new ArrayList<>();
    static ArrayList<Driver>  drivers = new ArrayList<>();
    static ArrayList<Ticket> tickets = new ArrayList<>();
    static int bus_count;
    static int ticket_count;
    static int driver_count;


    public static void main(String[] args) {
        int user_choice_in_menu;
        do{
            System.out.println("WELCOME TO BUS TRANSPORTATION SYSTEM");
            System.out.println("1.Ticket");
            System.out.println("2.Buses");
            System.out.println("3.Drivers");
            System.out.println("4.Exit");
            user_choice_in_menu = scanner.nextInt();

            switch(user_choice_in_menu){
                case 1:

                    System.out.println("1.Add Ticket");
                    int user_ch_ticket = scanner.nextInt();
                  if(user_ch_ticket == 1) {
                      tickets.add(new Ticket());
                      tickets.get(ticket_count).ticketgenerator();
                      ticket_count++;
                  }
                 break;
                case 2:
                    System.out.println("1.Add a Bus");
                    System.out.println("2.View The Buses");
                    System.out.println("3.Assign The Bus to A driver");
                    int bus_ch = scanner.nextInt();
                    if (bus_ch == 1){
                        buses.add(new Bus());
                        buses.get(bus_count).addBus();
                        bus_count++;
                    }
                    if(bus_ch == 2){
                        for(Bus i: buses){
                            i.printBuses(buses,drivers);
                        }
                    }
                    if(bus_ch == 3){
                        Bus.assignDriverToBus(buses,drivers);
                    }
                    break;
                case 3:
                    System.out.println("1.Add a Driver");
                    System.out.println("2.Find Driver by Name");
                    int user_choice_driver = scanner.nextInt() ;
                    if(user_choice_driver == 1){
                        drivers.add(new Driver());
                        drivers.get(driver_count).addDriver();
                        driver_count++;

                    }
                    if(user_choice_driver == 2){
                        System.out.println("Name of Driver");
                        String name = scanner.nextLine();
                        if(Driver.driverFind(drivers,name)){
                            System.out.println("Driver Exsits");
                        }
                        else{
                            System.out.println("Doesnt Exsits");
                        }
                    }
            }

        }while(user_choice_in_menu != 4 );
    }
}