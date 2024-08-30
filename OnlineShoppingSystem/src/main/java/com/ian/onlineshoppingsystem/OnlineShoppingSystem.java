package com.ian.onlineshoppingsystem;





import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;




















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
    public SellerSignUp(String name, String password, int id)
    {
        this.name = name;
        this.password = password;
        this.id = id;
    }
    
    
    //setter for seller income
    public void setIncome(float income) {
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
        boolean isPasswordValid = true;
        String sellerPassword = null;
        
        
        System.out.print("Enter your name: ");
        String sellerName = scanner.nextLine();
        
        
        while(isPasswordValid)
        {
            System.out.print("Enter your password: ");
            sellerPassword = scanner.nextLine();
            
            if(sellerPassword.length() >= 8)
            {
                System.out.print("Confirm your password: ");
                String confirmPassword = scanner.nextLine();
                
                if(sellerPassword.equals(confirmPassword)) 
                {
                    System.out.println("Your password is valid!");
                    isPasswordValid = false;
                    
                } 
                
                System.out.println("Password dont match!");
                continue;
                
            } 
            
            
            System.out.println("Your password must be at least 8 characters");
        }
       
        sellerID++;
        
        SellerSignUp seller = new SellerSignUp(sellerName, sellerPassword, sellerID);
        sellerAccountStorage.add(seller);
        
        System.out.println("Account registered successfully!");
        
    } 
    
}



//class for user functions
class BuyerClass
{
    private static final Scanner scanner = new Scanner(System.in);
    public static List<Product> productStorage = new ArrayList<>();
    public static List<Cart> cartStorage = new ArrayList<>();
    public static List<SellerSignUp> sellerAccountStorage = new ArrayList<>();
    
    
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

                System.out.println("");
                System.out.println("Payment Process");
                System.out.print("Enter payment price: ");
                float productPrice = scanner.nextInt();
                
                System.out.println("Enter seller ID: ");
                int sellerID = scanner.nextInt();
                
                
                for(SellerSignUp copy : sellerAccountStorage)
                {
                    if(sellerID == copy.getID())
                    {
                        copy.setIncome(productPrice);
                        System.out.println("Payment added successfully");
                        break;
                    }
                }
                
                
                 
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
    public static List<SellerSignUp> sellerAccountStorage = new ArrayList<>();
    public static int productID = 9000;

    
    
    
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
        
        
        System.out.print("Enter your product ID: ");
        int productStatusID = scanner.nextInt();
        
        for(Product copy : productStorage)
        {
            if(productStatusID == copy.getID())
            {
                System.out.println(copy);
                return;
            }
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
        System.out.print("Enter your seller ID: ");
        int sellerID = scanner.nextInt();
        
        for(SellerSignUp copy : sellerAccountStorage)
        {
            if(copy.getID() == sellerID)
            {
                System.out.println("Your Income balance is: " + copy.getID());
            }
        }
    }
    
}


class BuyerPortal
{
    private static Scanner scanner = new Scanner(System.in);
    public static List<BuyerSignUp> buyerAccountStorage = new ArrayList<>();
    
    
    public static void buyerLogIn()
    {
        boolean isShopRunning = true;
        boolean isBuyerLogIn = true;
        boolean isBuyerProgramRunning = true;
        
        while(isBuyerLogIn)
        {
            System.out.print("Enter your ID");
            int buyerID = scanner.nextInt();
        
            System.out.print("Enter your password: ");
            String buyerPassword = scanner.nextLine();
        
            for(BuyerSignUp copy : buyerAccountStorage)
            {
                if(buyerID == copy.getId() && buyerPassword == copy.getPassword())
                {
                    System.out.println("");
                    System.out.println("Log in successfully!");
                    System.out.println("");
                    
                    do
                    {
                        System.out.println("Welcome buyer!");
                        System.out.println("[1] Shop");
                        System.out.println("[2] Show cart");
                        System.out.println("[3] Remove cart");
                        System.out.println("[4] Log out");
                        
                        System.out.print("Enter your choice: ");
                        int choice = scanner.nextInt();
                        scanner.nextLine();
                        
                        switch(choice)
                        {
                            case 1:
                                while(isShopRunning)
                                {
                                    System.out.println("[1] Show products");
                                    System.out.println("[2] Add to cart");
                                    System.out.println("[3] Buy product");
                                    System.out.println("[4] Exit");
                                    
                                    System.out.print("Enter your choice: ");
                                    int shopChoice = scanner.nextInt();
                                    scanner.nextLine();
                                    
                                    switch(shopChoice)
                                    {
                                        case 1:
                                            BuyerClass.ShopProduct.showSellerProducts();
                                            break;
                                            
                                        case 2:
                                            BuyerClass.ShopProduct.addToCart();
                                            break;
                                            
                                        case 3:
                                            BuyerClass.ShopProduct.buyProduct();
                                            break;
                                            
                                        case 4:
                                            isShopRunning = false;
                                            break;
                                            
                                        default:
                                            System.out.println("Invalid Choice, try again!");
                                            break;                                                                                                                                                            
                                    }
                                }
                                
                            case 2:
                                //show cart
                                break;
                                
                            case 3:
                                //remove cart 
                                break;
                                
                            case 4:
                                //exit
                                isBuyerProgramRunning = false;
                                break;
                                
                            default:
                                System.out.println("Invalid choice, try again");
                                break;
                        }                              
                    }while(isBuyerProgramRunning);
                    
                    
                    return;
                }                      
            }
        
            System.out.println("Invalid credentials, try again");
        }                    
    }
    
}



class SellerPortal
{
    private static Scanner scanner = new Scanner(System.in);
    public static List<SellerSignUp> sellerAccountStorage = new ArrayList<>();
    
    
    public static void sellerLogIn()
    {
        boolean isSellerProgramRunning = true;
        boolean isSellerLogInRunning = true;
        
        
        while(isSellerLogInRunning)
        {
            System.out.print("Enter your ID: ");
            int sellerID = scanner.nextInt();
            
            System.out.print("Enter your password: ");
            String sellerPassword = scanner.nextLine();
            
            for(SellerSignUp copy : sellerAccountStorage)
            {
                if(sellerID == copy.getID() && sellerPassword == copy.getPassword())
                {
                    System.out.println("");
                    System.out.println("Log in successfully!");
                    System.out.println("");
                    
                    do
                    {
                        System.out.println("Welcome seller!");
                        System.out.println("[1] View product status");
                        System.out.println("[2] Add product");
                        System.out.println("[3] Remove product");
                        System.out.println("[4] View net income");
                        
                        System.out.print("Enter your choice: ");
                        int sellerChoice = scanner.nextInt();
                        scanner.nextLine();
                        
                        switch(sellerChoice)
                        {
                            case 1:
                                SellerClass.viewProduct();
                                break;
                                
                            case 2:
                                SellerClass.addProduct();
                                break;
                                
                            case 3:
                                SellerClass.removeProduct();
                                break;
                                
                            case 4:
                                SellerClass.incomeProduct();
                                break;
                                
                            case 5:
                                isSellerProgramRunning = false;
                                break;
                                
                            default:
                                System.out.println("Invalid choice, please try again");
                                break;
                                                                                                                                                                                           
                        }                                            
                    }while(isSellerProgramRunning);
                    
                    return;
                }
            }
            
            System.out.println("Invalid credentials, try again");
        }
    }    
}



class CreateAccount
{
    private static Scanner scanner = new Scanner(System.in);
    
    public static void choiceAccount()
    {
        boolean isAccountRunning = true;
        
        while(isAccountRunning)
        {
            System.out.println("Select mode of account");
            System.out.println("[1] Buyer");
            System.out.println("[2] Seller");
            System.out.println("[3] Exit");
            
            System.out.print("Select choice: ");
            int accountChoice = scanner.nextInt();
            scanner.nextLine();
            
            switch(accountChoice)
            {
                case 1:
                    BuyerAccount.createBuyerAccount();
                    break;
                    
                case 2:
                    SellerAccount.createSellerAccount();
                    break;
                    
                case 3:
                    isAccountRunning = false;
                    break;
                    
                default:
                    System.out.println("Invalid choice, try again");
                    break;
            }
        }
            
    }
}




        
        
        
        
        

//MAIN CLASS HERE


public class OnlineShoppingSystem 
{

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        boolean isMainProgramRunning = true;
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
                                BuyerPortal.buyerLogIn();
                                break;
                                                                                                                         
                            case 2:
                                SellerPortal.sellerLogIn();
                                break;

                            case 3:
                                isLogInRunning = false;
                                break;

                            default:
                                System.out.println("Invalid choice, try again.");
                                break;
                        }
                    }

                    break;


                case 2:
                    //create account
                    CreateAccount.choiceAccount();            
                    break;

                case 3:
                    //exit the program
                    isMainProgramRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
                    break;
            }                                                                         

        }
    }
}












































