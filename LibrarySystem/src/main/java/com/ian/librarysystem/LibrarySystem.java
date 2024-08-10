package com.ian.librarysystem;



import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;












//encapsulate the data types 
class Book
{
    //instance variables 
    private String title;
    private String author;
    private String published;
    private float ratings;
    
    
    //constructor for instant initialization
    public Book(String title, String author, String published, float ratings)
    {
        this.author = author;
        this.title = title;
        this.published = published;
        this.ratings = ratings;
    }
    
    
    //getters for the private instance variables
    public String getTitle()
    {
        return title;
    }
    
    public String getAuthor()
    {
        return author;
    }
    
    public String getPublished()
    {
        return published;
    }
    
    public float getRatings()
    {
        return ratings;
    }
    
      
    //modify the toString() method to display this instead of reference address
    @Override
    public String toString()
    {
        return "Book Title: " + getTitle() +         
               "\nBook Author: " + getAuthor();
        
        
    }
}




public class LibrarySystem 
{
    private static Scanner scanner = new Scanner(System.in);
    private static List<Book> bookStorage = new ArrayList<>();
    
    
    
    //methods for adding book to the bookStorage
    private static void addBook()
    {
        System.out.println();
        System.out.print("Enter book title: ");
        String bookTitle = scanner.nextLine();
        
        System.out.print("Enter book author: ");
        String bookAuthor = scanner.nextLine();
        
        System.out.print("Enter year published (mm/dd/yyyy): ");
        String bookPublished = scanner.nextLine();
        
        System.out.print("Enter book ratings: ");
        float bookRatings = scanner.nextFloat();
        
        
        //use the inputs to create an instance 
        Book instanceBook = new Book(bookTitle, bookAuthor, bookPublished, bookRatings);
        
        
        //store the created instance to the heap memory or arraylist 
        bookStorage.add(instanceBook);
        
        System.out.println("Book added successfully!");
    }
    
    
    
    //methods for removing the stored data to the heap memory
    private static void removeBook()
    {
        //check if the book storage is empty
        if(bookStorage.isEmpty())
        {
            System.out.println("There is no available book to remove!");
            return;  //exit to this method if this condition is met
        }
        
        
        System.out.print("Enter title of book to remove: ");
        String removeTitle = scanner.nextLine();
        
        
        //check every memory storage if there is same as the title of the book
        for(Book copyBook : bookStorage)
        {
            if(copyBook.getTitle().equalsIgnoreCase(removeTitle))
            {
                bookStorage.remove(copyBook);
                break;  //stop the loop
            }
        }
        
        
        System.out.println("Books has been remove successfully");
    }
    
    
    
    //method for searching books in the memory heap
    private static void searchBook()
    {
        if(bookStorage.isEmpty())
        {
            System.out.println("No book to search, bookshelves is empty");
            return;  //exit the method instantly
        }
        
        
        System.out.print("Enter title of the book: ");
        String searchTitle = scanner.nextLine();
        
        
        for(Book copyBook : bookStorage)
        {
            if(copyBook.getTitle().equalsIgnoreCase(searchTitle))
            {
                System.out.println(copyBook);
                break;  //terminate the loop
            }
        }

    }
    
    
    
    //methods for showing the highest rated book in the bookshelves
    private static void showRatings()
    {
        if(bookStorage.isEmpty())
        {
            System.out.println("No available books in the shelves");
            return;  //terminate the method instantly
        }
        
        
        float ratings = 0;
        
        
        //loop for getting the highest rating
        for(Book copyBook : bookStorage)
        {
            if(copyBook.getRatings() > ratings)
            {
                ratings = copyBook.getRatings();
            }
        }
        
        
        //loop for getting the data of the highest rating
        for(Book copyBook : bookStorage)
        {
            if(copyBook.getRatings() == ratings)
            {
                System.out.println(copyBook);
            }
        }
       
    }
    
    
    
    //show all available books 
    private static void showAll()
    {
        if(bookStorage.isEmpty())
        {
            System.out.println("No books is available");
            return;  //terminate the program early
        }
        
        
        for(Book copyBook : bookStorage)
        {
            System.out.println(copyBook);
        }
        
        System.out.println("Thats all the available books!");
        
    }
    
   
    
    
    
    public static void main(String[] args)
    {
        boolean isProgramRunning = true;
        
        
        System.out.println("Welcome to my Library System");
        System.out.println();  //newline
        
        
        while(isProgramRunning)
        {
            System.out.println();
            System.out.println("Please select your choices");
            System.out.println("[1] Add Books");
            System.out.println("[2] Remove Books");
            System.out.println("[3] Search Books");
            System.out.println("[4] Show highest rated books");
            System.out.println("[5] Show all available books");
            System.out.println("[6] Exit");
            
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  //consume remaining token
            System.out.println();  //newline
            
            switch(choice)
            {
                case 1:
                    LibrarySystem.addBook();
                    break;
                    
                case 2:
                    LibrarySystem.removeBook();
                    break;
                    
                case 3:
                    LibrarySystem.searchBook();
                    break;
                    
                case 4:
                    LibrarySystem.showRatings();
                    break;
                    
                case 5:
                    LibrarySystem.showAll();
                    break;
                    
                case 6:
                    isProgramRunning = false;
                    break;
                    
                    
                default:
                    System.out.println("Invalid input please try again");
                    break;                                         
                    
            }
            
            
            
            
        }
        
        scanner.close();
    }
}
