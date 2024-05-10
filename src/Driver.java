import java.util.ArrayList;
import java.util.Scanner;

class Driver {
    Scanner sc = new Scanner(System.in);
    private String name;
    private double rating;
    private String cnic;
    public static int driverCount = 0;
    public static ArrayList<Bus> busesAssigned = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getRating() {
        return this.rating;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getCnic() {
        return this.cnic;
    }

    public void addDriver() {
        System.out.println("What is the Driver Name");
        this.name = sc.nextLine();
        System.out.println("What is the Driver Cnic");
        this.cnic = sc.nextLine();
        System.out.println("What is the Driver Rating");
        this.rating = sc.nextDouble();
        driverCount++;
    }

    public static void printAll(ArrayList<Driver> drivers) {
        for (Driver driver : drivers) {
            System.out.println("Driver's Name: " + driver.getName());
            System.out.println("Driver's CNIC: " + driver.getCnic());
            System.out.println("Driver's Rating: " + driver.getRating());
            if (!(Driver.busesAssigned.isEmpty())) {
                System.out.println("Bus Assigned To: " + driver.busesAssigned);
            }
        }
    }

    public static boolean driverFind(ArrayList<Driver> drivers, String name) {
        for (Driver driver : drivers) {
            if (driver.name.equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
}