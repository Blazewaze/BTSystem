import java.util.ArrayList;
import java.util.Scanner;

class Bus {
    static Scanner sc = new Scanner(System.in);
    private String noPlate;
    private String travellingFrom;
    private String travellingTo;
    private Driver driver;
    private boolean driverAssign = false;
    private static int noPlateAssigner = 101;

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getTravellingFrom() {
        return this.travellingFrom;
    }

    public String getTravellingTo() {
        return this.travellingTo;
    }

    Bus(String travellingFrom, String travellingTo) {
        this.travellingFrom = travellingFrom;
        this.travellingTo = travellingTo;
        this.noPlate = "AB" + noPlateAssigner;
        noPlateAssigner++;
    }

    Bus() {
        this("RWP", "NULL");
    }

    public void printBuses(ArrayList<Bus> buses, ArrayList<Driver> drivers) {
        try {
            for (Bus bus : buses) {
                System.out.println("-------------------------------------------");
                System.out.println("Bus Number Plate: " + bus.noPlate);
                System.out.println("Bus Travelling From: " + bus.travellingFrom);
                System.out.println("Bus Travelling To: " + bus.travellingTo);
                System.out.println("Bus Assigned A Driver: " + bus.driverAssign);
                if (bus.driverAssign) {
                    System.out.println("Driver's Name: " + bus.driver.getName());
                    System.out.println("Driver's CNIC: " + bus.driver.getCnic());
                    System.out.println("Driver's Rating: " + bus.driver.getRating());
                }
                System.out.println("-------------------------------------------");
            }
        } catch (Exception exp) {
            System.out.println("No Buses Exist");
        }
    }

    public void addBus() {
        if (Driver.driverCount > 0) {
            System.out.println("Where will bus Travel to");
            this.travellingTo = sc.nextLine();
            System.out.println("Where will bus Travel From");
            this.travellingFrom = sc.nextLine();
            System.out.println("What City bus is this Type in 3 letters");
            String city;
            do {
                city = sc.nextLine();
            } while (city.length() != 3);
            System.out.println("What will be the Number of Number Plate");
            String noplate = sc.nextLine();
            this.noPlate = city + noplate;
        } else {
            System.out.println("At least One Driver Should Exist");
        }
    }

    public static void assignDriverToBus(ArrayList<Bus> buses, ArrayList<Driver> drivers) {
        if (!(buses.isEmpty()) && !(drivers.isEmpty())) {
            try {
                for (Bus bus : buses) {
                    System.out.println("Please Select From following Buses");
                    System.out.println("No Plate: " + bus.noPlate);
                }
                System.out.println("Write your selection for Number Plate");
                String userChoiceNoPlate = sc.nextLine();
                for (Driver driver : drivers) {
                    System.out.println("Please Select From following Drivers");
                    System.out.println("Driver Name: " + driver.getName());
                }
                System.out.println("Write your selection for Driver");
                String userChoiceDriverName = sc.nextLine();
                boolean nameExists = false;
                boolean noExists = false;
                for (Bus bus : buses) {
                    if (userChoiceNoPlate.equalsIgnoreCase(bus.noPlate)) ;
                    noExists = true;
                    break;
                }
                for (Driver driver : drivers) {
                    if (userChoiceDriverName.equalsIgnoreCase(driver.getName())) ;
                    nameExists = true;
                    break;
                }
                if (noExists && nameExists) {
                    for (Driver driver : drivers) {
                        for (Bus bus : buses) {
                            if (userChoiceDriverName.equalsIgnoreCase(driver.getName()) && userChoiceNoPlate.equalsIgnoreCase(bus.noPlate)) {
                                bus.setDriver(driver);
                                bus.driverAssign = true;
                                driver.busesAssigned.add(bus);

                                break;
                            }
                        }
                    }
                }
            } catch (Exception exp) {
                System.out.println("Driver or Bus doesn't exist");
            }
        } else {
            System.out.println("No Buses Or Drivers Available");
        }
    }
}