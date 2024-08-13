package com.ian.vehiclerentalsystem;




import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;








interface Vehicle
{
    void transactVehicle();
    void returnVehicle();
}





//class for encapsulating the data for data hiding
class VehicleData
{
    //private attributes
    private String type;
    private int hour;
    private String date;

        
    //constructor for data initialization 
    public VehicleData(String type, int hour, String date)
    {
        this.type = type;
        this.hour = hour;
        this.date = date;             
    }                  
        
}






//class for transaction functionality
class Transact implements Vehicle
{
    private static Scanner scanner = new Scanner(System.in);
    private static List<VehicleData> vehicleStorage = new ArrayList<>();
    
    static int bike = 5;
    static int car = 5;
    static int vehicleCount = bike + car;
    
    
    
    //methods for transaction
    @Override
    public void transactVehicle()
    {
        //check if there is available vehicle
        if(vehicleCount == 0)
        {
            System.out.println("There is no available vehicle for today.");
          
            return;          
        }
        
        
        //if there is available
        System.out.println("What type of vehicle do you want? [Bike] || [Car]");
        String vehicleChoice = scanner.nextLine();
        
        
        if(vehicleChoice.equalsIgnoreCase("bike"))
        {
            bike--;
        } 
        else if(vehicleChoice.equalsIgnoreCase("car"))
        {
            car--;
        }
        
        
        System.out.println("How much time do you want to spend? [Hours]");
        int vehicleHours = scanner.nextInt();
        scanner.nextLine();  //consume newline
        
        System.out.println("When would you like to start?");
        String vehicleDate = scanner.nextLine();
        
        
        VehicleData vehicleAdd = new VehicleData(vehicleChoice, vehicleHours, vehicleDate);
        vehicleStorage.add(vehicleAdd);
        
        vehicleCount--;  //decrease the vehicle count
        
        
        int product = vehicleHours * 10;
        
        System.out.println("Your payment is " + product + "$");
        System.out.println("Thank you for renting!");
        
    }
  
    
    
    //method for returning the vehicle
    @Override
    public void returnVehicle()
    {
        System.out.println("What type of vehicle would you like to return?");
        String returnChoice = scanner.nextLine();
        
        if(returnChoice.equalsIgnoreCase("bike"))
        {
            bike++;
            System.out.println("Thank you for returning!");
            return;
        }
        else if(returnChoice.equalsIgnoreCase("car"))
        {
            car++;
            System.out.println("Thank you for returning!");
            return;
        }
        
        
        
    }
}








public class VehicleRentalSystem 
{
    public static void main(String[] args)  
    {     
        Scanner scanner = new Scanner(System.in);
        boolean isProgramRunning = true;
        
        Transact transact = new Transact();
        
        
        
        System.out.println("Welcome to my Vehicle Rental System!");
        
        while(isProgramRunning)
        {
            System.out.println("");
            System.out.println("[1] Transact a vehicle");
            System.out.println("[2] Return a vehicle");
            System.out.println("[3] Exit");
            
            System.out.println("");
            System.out.println("Please enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch(choice)
            {
                case 1:
                    transact.transactVehicle();
                    break;
                    
                case 2:
                    transact.returnVehicle();
                    break;
                    
                case 3:
                    isProgramRunning = false;
                    break;
                    
                default:
                    System.out.println("Invalid choices! Try again.");
                    break;
            }
            
        }
            
        scanner.close();
        

    }
}
