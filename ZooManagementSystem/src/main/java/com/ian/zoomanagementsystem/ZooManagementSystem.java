//package name of the program
package com.ian.zoomanagementsystem;





import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;






//implements interface for 
interface AnimalFunctions
{
    void addAnimals();
    void feedAnimals();
    void checkAnimalStatus();
    void showAllAnimals();
}




//encapsulate the data to hide from the user
class AnimalData
{
    private String kind;
    private String name;
    private int age;
    private String healthCondition;
    private int id;
    
    
    //constructor for initialization
    public AnimalData(String kind, String name, int age, String healthCondition, int id)
    {
        this.kind = kind;
        this.name = name;
        this.age = age;
        this.healthCondition = healthCondition;
        this.id = id;
    }
    
    
    //getters 
    public String getKind()
    {
        return kind;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public String getHealth()
    {
        return healthCondition;
    }
    
    public int getID()
    {
        return id;
    }
    
    
    @Override
    public String toString()
    {
        return "Kind: " + getKind() + 
                "\nName: " + getName() + 
                "\nAge: " + getAge();
    }
    
}





//class for the functionalities
class Zoo implements AnimalFunctions
{
    private Scanner scanner = new Scanner(System.in);
    private List<AnimalData> animalDataStorage = new ArrayList<>();
    
    int id = 1000;  //id number
    
    
    
    //methods for adding animals 
    @Override
    public void addAnimals()
    {
        System.out.print("What kind of animal you want to add: ");
        String animalKind = scanner.nextLine();
        
        System.out.print("Enter name of your animal: ");
        String animalName = scanner.nextLine();
        
        System.out.print("Enter age of your animal: ");
        int animalAge = scanner.nextInt();
        scanner.nextLine(); //consume newline
        
        System.out.print("Enter health condition of your animal: ");
        String animalHealth = scanner.nextLine();
        
        
        id++;  //increment the id number
        
        
        AnimalData animals = new AnimalData(animalKind, animalName, animalAge, animalHealth, id);
        animalDataStorage.add(animals);
        
        
        System.out.println("");
        System.out.println("Animal added successfully!");
        System.out.println("Your pet ID number is " + id);
        
    }
    
    
    
    //methods to feed animals 
    @Override
    public void feedAnimals()
    {     
        System.out.print("Enter your pet ID number: ");
        int idNumber = scanner.nextInt();
        scanner.nextLine();  //consume newline
        
        
        for(AnimalData copy : animalDataStorage)
        {
            if(copy.getID() == idNumber)
            {
                System.out.print("Do you want to continue to feed your animal?: ");
                String choice = scanner.nextLine();
                
                if(choice.equalsIgnoreCase("yes"))
                {
                    System.out.println("Your animal has been feeded successfully!");
                } 
                else 
                {
                    System.out.println("You cancelled your feeding");
                    return;  //exit the method immediately
                }
                
            }
        }
    }
    
    
    
    //methods to check animal status
    @Override
    public void checkAnimalStatus()
    {
        
    }
    
    
    
    //method for showing all available animals 
    @Override
    public void showAllAnimals()
    {
        if(animalDataStorage.isEmpty())
        {
            System.out.println("No animals in the zoo!");
            return;
        }
        
        
        //if there is animal in the zoo
        for(AnimalData copy : animalDataStorage)
        {
            System.out.println(copy);
            System.out.println("");
        }
    }
       
    
}





public class ZooManagementSystem 
{

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        boolean isProgramRunning = true;
        Zoo animalZoo = new Zoo();
        
        
        
        System.out.println("Welcome to my Zoo!");
        
        
        while(isProgramRunning)
        {
            System.out.println();
            System.out.println("[1] Add animals");
            System.out.println("[2] Feed animals");
            System.out.println("[3] Check animal status");
            System.out.println("[4] Show all animals");
            System.out.println("[5] Exit");
            
            System.out.println("");
            System.out.print("Please select your choices: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  //consume new line character
            
            
            switch(choice)
            {
                case 1:
                    animalZoo.addAnimals();
                    break;
                    
                case 2:
                    animalZoo.feedAnimals();
                    break;
                    
                case 3:
                    animalZoo.checkAnimalStatus();
                    break;
                    
                case 4:
                    animalZoo.showAllAnimals();
                    break;
                    
                case 5:
                    isProgramRunning = false;
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again!");
                    break;
                                                                                                       
            }
        }
    }
}
