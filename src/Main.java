
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Bus> buses = new ArrayList<>();
    static ArrayList<Driver>  drivers = new ArrayList<>();
    static int bus_count;

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
            }

        }while(user_choice_in_menu != 4 );
    }
}