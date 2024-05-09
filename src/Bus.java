import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.ArrayList;
public class Bus {
    static Scanner sc = new Scanner(System.in);

    private String NoPlate;
    private String TravellingFrom;
    private String TravellingTo;
    public static int NoPlateAssigner = 101;




    Bus(String TravellingFrom, String TravellingTo){
        this.TravellingFrom = TravellingFrom;
        this.TravellingTo = TravellingTo;
        this.NoPlate = "AB"+NoPlateAssigner;

        NoPlateAssigner++;
    }

    Bus(){
        this("RWP","NULL");
    }

    public void printBuses(ArrayList<Bus> buses,ArrayList<Driver> drivers){
       try {
           for (Bus i : buses) {
                   System.out.println("-------------------------------------------");
                   System.out.println("Bus Number Plate: " + i.NoPlate);
                   System.out.println("Bus Travelling From: " + i.TravellingFrom);
                   System.out.println("Bus Travelling To: " + i.TravellingTo);
                   System.out.println("-------------------------------------------");

           }
       }catch(Exception exp){
           System.out.println("No Buses Exsits");
       }


    }

    public void addBus(){

        if(Driver.busesAssigned.size() > 0) {
            System.out.println("Where will bus Travel to");
            this.TravellingTo = sc.nextLine();
            System.out.println("Where will bus Travel From");
            this.TravellingFrom = sc.nextLine();

            System.out.println("What City bus is this Type in 3 letters");
            String city;

            do {
                city = sc.nextLine();

            } while (city.length() != 3);

            System.out.println("What will be the Number of Number Plate");
            String noplate = sc.nextLine();

            this.NoPlate = city + noplate;

        }
        else{
            System.out.println("Atleast One Driver Should Exsits");
        }

    }
    public static void assignDriverToBus(ArrayList<Bus> buses , ArrayList<Driver> drivers){
        if (!( buses.isEmpty() ) && !( drivers.isEmpty())) {
            try {

                for (Bus i : buses) {

                    System.out.println("Please Select From following Buses");
                    System.out.println("No Plate: " + i.NoPlate);

                }
                System.out.println("Write your selection for Number Plate");
                String user_choice_NoPlate = sc.nextLine();

                for (Driver i : drivers) {

                    System.out.println("Please Select From following Drivers");
                    System.out.println("Driver Name: " + i.getName());

                }
                System.out.println("Write your selection for Driver");
                String user_choice_DriverName = sc.nextLine();

                boolean nameExsits = false;
                boolean noExists = false;
                for (Bus i : buses) {

                    if (user_choice_NoPlate.equalsIgnoreCase(i.NoPlate)) ;
                    noExists = true;
                    break;
                }
                for (Driver i : drivers) {

                    if (user_choice_DriverName.equalsIgnoreCase(i.getName())) ;
                    nameExsits = true;
                    break;
                }

                if (noExists && nameExsits) {
                    for (Driver i : drivers) {
                        for (Bus j : buses) {
                            if (user_choice_DriverName.equalsIgnoreCase(i.getName()) && user_choice_NoPlate.equalsIgnoreCase(j.NoPlate))
                                i.busesAssigned.add(j);
                            break;
                        }
                    }
                }

            }catch(Exception exp){
                System.out.println("Driver or Bus dont exsits");
            }
        }else{
            System.out.println("No Buses Or Drivers Avaliable");
        }



    }



}
