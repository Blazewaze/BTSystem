import java.util.ArrayList;
import java.util.Scanner;
public class Driver {
    Scanner sc = new Scanner(System.in);
    private String name;
    private double rating;
    private String cnic;
    public  ArrayList<Bus> busesAssigned = new ArrayList<>();
    static int DriverCount = 1;

    Driver(String name, double rating , String cnic){
        this.name = name;
        this.rating = rating;
        this.cnic = cnic;
        DriverCount++;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setRating(double rating){
        this.rating = rating;
    }
    public double getRating(){
        return this.rating;
    }
    public void setCnic(String cnic){
        this.cnic = cnic;
    }
    public String getCnic()
    {
        return this.cnic;
    }


    public void addDriver(){

        System.out.println("What is the Driver Name");
        this.name = sc.nextLine();
        System.out.println("What is the Driver Cnic");
        this.cnic = sc.nextLine();
        System.out.println("What is the Driver Rating");
        this.rating = sc.nextDouble();

    }

    public boolean driverFind(Driver drivers,String name){
        for(int i =0; i<DriverCount;i++){
            if(drivers.name.equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }



}