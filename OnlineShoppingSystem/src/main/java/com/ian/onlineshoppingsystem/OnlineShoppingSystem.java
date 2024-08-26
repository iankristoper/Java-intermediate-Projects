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
class BuyerSignUp
{
    private String name;
    private String password;
    private int id;
    
    
    //constructor for initialization
    public BuyerSignUp(String name, String password, int id)
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



class SellerSignUp
{
    private String name;
    private String password;
    private int id;
    private float income;
    
    
    //constructor for initialization when the class is declared 
    public SellerSignUp(String name, String password, int id, float income)
    {
        this.name = name;
        this.password = password;
        this.id = id;
        this.income = income;
    }
    
    
    //getters
    public String getName() {
        return name;
    }
    
    public String getPassword() {
        return password;
    }
    
    public int getID() {
        return id;
    }
    
    public float getIncome() {
        return income;
    }          
}



//encapsulate the data for the seller 
class Product
{
    private String name;
    private String type;
    private float price;
    private int id;
    
    public Product(String name, String type, float price, int id)
    {
        this.name = name;
        this.price = price;
        this.type = type;
        this.id = id;
    }
    
    
    public String getName() {
        return name;
    }
    
    public String getType() {
        return type;
    }   
    
    public float getPrice() {
        return price;
    }
    
    public int getID() {
        return id;
    }
    
    
    @Override
    public String toString()
    {
        return "Hello";
    }

    
}




//this class is for the cart of the buyer 
class Cart
{
    private int productID;
    private String productName;
    
    public Cart(int productID, String productName)
    {
        this.productID = productID;
        this.productName = productName;
    }
    
    
    //getters 
    public int getProductID() {
        return productID;
    }
    
    public String getProductName() {
        return productName;
    }
               
}


class Income
{
    private int id;
    private float income;
    
    public Income(int id, float income)
    {
        this.id = id;
        this.income = income;
    }
    
    
    //getters 
    public int getID() {
        return id;
    }
    
    public float getIncome() {
        return income;
    }   
    
}
    


//class for creating account
class BuyerAccount 
{
    private static final Scanner scanner = new Scanner(System.in);
    public static List<BuyerSignUp> buyerAccountStorage = new ArrayList<>();
    static int buyerID = 1000;
    
    
    //methods to create account
    public static void createBuyerAccount()
    {
        String buyerPassword;
        
        System.out.print("Enter your name: ");
        String buyerName = scanner.nextLine();
        
        do
        {
            System.out.print("Enter your password: ");
            buyerPassword = scanner.nextLine();
        } while(buyerPassword.length() < 8);
        
        buyerID++;
        
        System.out.println("Your buyer ID is " + buyerID);
        
        BuyerSignUp storeData = new BuyerSignUp(buyerName, buyerPassword, buyerID);
        buyerAccountStorage.add(storeData);
        
        System.out.println("Your account was created successfully!");
    }
}



class SellerAccount
{
    private static Scanner scanner = new Scanner(System.in);
    public static List<SellerSignUp> sellerAccountStorage = new ArrayList<>();
    static int sellerID = 2000;
    
    
    //methods to create the seller account
    public static void createSellerAccount()
    {
        String sellerPassword = null;
        boolean isPasswordLengthOkay = true;
        
        
        System.out.print("Enter your name: ");
        String sellerName = scanner.nextLine();
        
        do 
        {
            boolean isPasswordMatch = true;
            
            
            
            while(isPasswordMatch)
            {
                System.out.print("Enter your password: ");
                sellerPassword = scanner.nextLine();

                System.out.print("Confirm your password: ");
                String confirmPassword = scanner.nextLine();

                if(confirmPassword.matches(sellerPassword))
                {
                    System.out.println("Password Confirmed!");
                    isPasswordMatch = false;
                    break;
                    
                }
                else
                {
                    System.out.println("Mismatch password, try again!");
                }
            }
            
            
           
            if(sellerPassword.length() >= 8)
            {
                System.out.println("Password length is valid");
                isPasswordLengthOkay = false;
                break;
                
            }
            else
            {
                System.out.println("Invalid password length make it 8 characters above");
                isPasswordMatch = true;
            }
                   
                       
        } while(isPasswordLengthOkay);
        
        
        
        sellerID++;
        System.out.println("Your seller id is: " + sellerID);
        
        SellerSignUp sellerData = new SellerSignUp(sellerName, sellerPassword, sellerID, )
        
        
    }
    
    
    
    
    
    
}



//class for user functions
class BuyerClass
{
    private static final Scanner scanner = new Scanner(System.in);
    public static List<Product> productStorage = new ArrayList<>();
    public static List<Cart> cartStorage = new ArrayList<>();
    
    
    //inner class for shopping methods of the buyer
    class ShopProduct
    {
        
        //this methods is to show products from the seller 
        public static void showSellerProducts()
        {
            if(productStorage.isEmpty())
            {
                System.out.println("There is no available product on the market");
            }
            
            //display the productStorage content
            for(Product copy : productStorage)
            {
                System.out.println(copy);
            }
        }
        
        
        //methods for adding to cart 
        public static void addToCart()
        {
            System.out.print("Enter product ID: ");
            int productID = scanner.nextInt();
            
            System.out.print("Enter product name: ");
            String productName = scanner.nextLine();
            
            Cart cart = new Cart(productID, productName);
            cartStorage.add(cart);
            
            System.out.println("Product added to cart successfully");

        }
        
        
        //methods for buying the seller products 
        public static void buyProduct()
        {
            boolean isIdValid = true;          
            
            while(isIdValid)
            {
                System.out.print("Enter product ID: ");
                int productID = scanner.nextInt();              

                System.out.print("Enter product name: ");
                String productName = scanner.nextLine();

                System.out.print("Enter price: ");
                int productPrice = scanner.nextInt();


                for(Product copy : productStorage)
                {
                    if(productID == copy.getID())
                    {
                        productStorage.remove(copy);
                        System.out.println("Product purchased successfully!");
                        return;
                    }
                }

                System.out.println("Invalid ID, nowhere to find");
            }
                  
        }
        
        
        
        
    }
}



//class for seller functions
class SellerClass
{
    private static final Scanner scanner = new Scanner(System.in);
    public static List<Product> productStorage = new ArrayList<>();
    public static List<Income> incomeStorage = new ArrayList<>();
    public static int productID = 9000;
    public static float sellerIncome = 0;
    
    
    
    //method to add product
    public static void addProduct()
    {
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();
        
        System.out.print("Enter product type: ");
        String productType = scanner.nextLine();
        
        System.out.print("Enter product price: ");
        float productPrice = scanner.nextFloat();
        
        System.out.println("Product ID: " + productID++);
        
        Product addProduct = new Product(productName, productType, productPrice, productID);
        productStorage.add(addProduct);
        
        System.out.println("Product added to the market successfully!");
               
    }
      
    
    
    //method to view product status of the seller 
    public static void viewProduct()
    {
        if(productStorage.isEmpty())
        {
            System.out.println("No products available");
        }
        
        
        for(Product copy : productStorage)
        {
            System.out.println(copy);
        }            
        
    }
    
    
        
    //methods to remove product of hhe seller
    public static void removeProduct()
    {
        //check if the product is not empty
        if(productStorage.isEmpty())
        {
            System.out.println("No products available");
        }
        
        System.out.print("Enter product ID to remove: ");
        int removeID = scanner.nextInt();
        
        for(Product copy : productStorage)
        {
            if(removeID == copy.getID())
            {
                productStorage.remove(copy);
            }
        }
        
        
        System.out.println("Products removed successfully");
    }
    
    
     
    //this method is for viewing the income of the seller
    public static void incomeProduct()
    {
        
    }
    
}


//MAIN CLASS HERE


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
                    while(isLogInRunning)
                    {
                        System.out.println("Hi! Welcome to IShop!");
                        System.out.println("");
                        System.out.println("[1] Buyer");
                        System.out.println("[2] Seller");
                        System.out.println("[3] Back");

                        System.out.println("");
                        System.out.print("Enter your choice: ");
                        int choice = scanner.nextInt();
                        scanner.nextLine();  //consume newline

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
                                
                                for(SignUp copy : CreateAccount.accountStorage)
                                {
                                    if(userID == copy.getId() && userPassword == copy.getPassword())
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
                                                    BuyerClass.ShopProduct.buyProduct();
                                                    break;                                                                             

                                                case 2:
                                                    BuyerClass.ShopProduct.addToCart();
                                                    break;

                                                case 3:
                                                    BuyerClass.ShopProduct.
                                                    break;

                                                case 4:
                                                    //log out
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
                                }
                            
                                break;

                            case 2:
                                //view product status
                                //add product
                                    //name
                                    //type 
                                    //price
                                //remove product
                                //view net income
                                //logout
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
                    //create account
                    CreateAccount.createAccount();
                    break;

                case 3:
                    //exit the program
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
