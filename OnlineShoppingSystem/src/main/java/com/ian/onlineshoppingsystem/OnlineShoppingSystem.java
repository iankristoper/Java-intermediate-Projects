package com.ian.onlineshoppingsystem;



import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;





interface Register
{
    
}



interface User 
{
    void shoppingMethod();
    void showCart();
    void removeCart();
    void logOut();
}


interface Seller
{
    void viewProduct();
    void addProduct();
    void removeProduct();
    void viewNetIncome();
    void logOut();
}

        

//encapsulate the data of the user and seller for signing up
class SignUp
{
    private String name;
    private String password;
    private int id;
    
    
    //constructor for initialization
    public SignUp(String name, String password, int id)
    {
        this.name = name;
        this.password = password;
        this.id = id;
    }
    
    
    //getters
    public String getName() {
        return name;
    }
    
    public String getPassword() {
        return password;
    }
    
    public int getId() {
        return id;
    }
}



//class for creating account
class CreateAccount
{
    
}












public class OnlineShoppingSystem 
{

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        boolean isMainProgramRunning = true;
        boolean isUserProgramRunning = true;
        boolean isSellerProgramRunning = true;
        boolean isSubProgramRunning = true;
        boolean isLogInRunning = true;
        
        
        System.out.println("Welcome to IShop, where you can buy and sell online");
        
        
        while(isMainProgramRunning)
        {
            System.out.println("Sign up");
            System.out.println("");
            System.out.println("[1] Log in");
            System.out.println("[2] Create Account");
            System.out.println("[3] Exit");
            
            System.out.println("");
            System.out.print("Enter your choice: ");
            int signing = scanner.nextInt();
            scanner.nextLine();  //consume newline
            
            
            switch(signing)
            {
                case 1:
                    System.out.println("Hi! Welcome to IShop!");
                    System.out.println("");
                    System.out.println("[1] User as buyer");
                    System.out.println("[2] User as seller");
                    System.out.println("[3] Back");

                    System.out.println("");
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();  //consume newline

                    while(isLogInRunning)
                    {
                        switch(choice)
                        {
                            case 1:
                                System.out.print("Enter your ID: ");
                                int userID = scanner.nextInt();
                                scanner.nextLine();  //consumes newline

                                System.out.print("Enter name: ");
                                String userName = scanner.nextLine();

                                System.out.print("Enter password: ");
                                String userPassword = scanner.nextLine();

                                if(userPassword == PASSWORD && userID == ID)
                                {
                                    while(isUserProgramRunning)
                                    {
                                        System.out.println("Welcome to IShop, Enjoy your shopping!");
                                        System.out.println("[1] Shop");
                                        System.out.println("[2] Show the cart");
                                        System.out.println("[3] Remove to cart");
                                        System.out.println("[4] Log out");

                                        System.out.println("");
                                        System.out.print("Enter your choices: ");
                                        int userChoice = scanner.nextInt();

                                        switch(userChoice)
                                        {
                                            case 1:
                                                break;

                                            case 2:
                                                break;

                                            case 3:
                                                break;

                                            case 4:
                                                isUserProgramRunning = false;
                                                break;

                                            default:
                                                System.out.println("Invalid choice, try again.");
                                                break;
                                        }
                                    }
                                }
                                else 
                                {
                                    System.out.println("Incorrect credentials, try again");
                                }

                                break;

                            case 2:
                                break;

                            case 3:
                                break;

                            default:
                                System.out.println("Invalid choice, try again.");
                                break;
                        }
                    }

                    break;


                case 2:
                    break;

                case 3:
                    isSubProgramRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
                    break;
            }
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            if(signing == 1)
            {
                System.out.println("Hi! Welcome to IShop!");
                System.out.println("");
                System.out.println("[1] User as buyer");
                System.out.println("[2] User as seller");
                System.out.println("[3] Back");
                
                System.out.println("");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  //consume newline
                
                if(choice == 1)
                {
                    System.out.print("Enter your ID: ");
                    int userID = scanner.nextInt();
                    scanner.nextLine();  //consumes newline
                    
                    System.out.print("Enter name: ");
                    String userName = scanner.nextLine();
                    
                    System.out.print("Enter password: ");
                    String userPassword = scanner.nextLine();
                    
                    if(userPassword == PASSWORD && userID == ID)
                    {
                        while(isUserProgramRunning)
                        {
                            System.out.println("Welcome to IShop, Enjoy your shopping!");
                            System.out.println("[1] Shop");
                            System.out.println("[2] Show the cart");
                            System.out.println("[3] Remove to cart");
                            System.out.println("[4] Log out");

                            System.out.println("");
                            System.out.print("Enter your choices: ");
                            int userChoice = scanner.nextInt();

                            switch(userChoice)
                            {
                                case 1:
                                    break;

                                case 2:
                                    break;

                                case 3:
                                    break;

                                case 4:
                                    isUserProgramRunning = false;
                                    break;

                                default:
                                    System.out.println("Invalid Choice, try again");
                                    break;
                            }
                        }
                    }
                }
                else if(choice == 2)
                {
                    while(isSellerProgramRunning)
                    {
                        System.out.println("Welcome to IShop, Enjoy your selling!");
                        System.out.println("[1] View product status");
                        System.out.println("[2] Add product");
                        System.out.println("[3] Remove product");
                        System.out.println("[4] View net income");
                        System.out.println("[5] Log out");
                        
                        System.out.println("");
                        System.out.print("Enter your choice: ");
                        int sellerChoice = scanner.nextInt();
                        scanner.nextLine();  //consumer newline
                        
                        switch(sellerChoice)
                        {
                            case 1:
                                break;
                                
                            case 2:
                                break;
                                
                            case 3:
                                break;
                                
                            case 4:
                                break;
                                
                            case 5:
                                isSellerProgramRunning = false;                               
                                break;
                                
                            default:
                                System.out.println("Invalid choice, try again");
                                break;
                        }
                    }
                }
                else if(choice == 3)
                {
                    
                }                     
            } 
            else if(signing == 2)
            {
                
               
            }
            else if(signing == 3)
            {
                System.out.println("Thank you for using IShop!");
                isMainProgramRunning = false;               
            }
        }
    }
}
