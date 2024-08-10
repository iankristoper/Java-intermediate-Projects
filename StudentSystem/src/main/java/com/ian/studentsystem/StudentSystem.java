package com.ian.studentsystem;



//import libraries
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;




//encapsulate the data 
class Student
{
    //instance variables
    private String name;
    private int age;
    private String sex;
    private String course;
    private int year;
    private String semester;
    
    
    //contructor for direct initialization
    public Student(String name, int age, String sex, String course, int year, String semester)
    {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.course = course;
        this.year = year;
        this.semester = semester;
    }
    
    
    //getters 
    public String getName()
    {
        return name;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public String getSex()
    {
        return sex;
    }
    
    public String getCourse()
    {
        return course;
    }
    
    public int getYear()
    {
        return year;
    }
    
    public String getSemester()
    {
        return semester;
    }
    
    
    //modify the toString() in order to have a dynamic output insted of the reference address when calling an object
    //@Override       
    
}




//this class is for the functionality
class StudentFunction
{
    private static List<Student> studentStorage = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    
    //this function is for adding the student information
    public static void addInfo()
    {
        System.out.println();  //newline
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        
        System.out.print("Enter student age: ");
        int studentAge = scanner.nextInt();
        scanner.nextLine();  //consume newline
        
        System.out.print("Enter student sex: ");
        String studentSex = scanner.nextLine();
        
        System.out.print("Enter student course: ");
        String studentCourse = scanner.nextLine();
        
        System.out.print("Enter student year level: ");
        int studentYear = scanner.nextInt();
        scanner.nextLine();  //consume newline
        
        System.out.print("Enter semester: ");
        String studentSemester = scanner.nextLine();
        
        
        
        //creating instance of student class and initializa value
        Student studentInstance = new Student(studentName, studentAge, studentSex, studentCourse, studentYear, studentSemester);
        
        
        //add the newly created instance to the arraylist
        studentStorage.add(studentInstance);
        
        
        System.out.println("Student Information added successfully");
                         
    }
    
    
    
    
    //this method is for removing student information
    public static void removeInfo()
    {
        //check if empty
        if(studentStorage.isEmpty())
        {
            System.out.println("No records available!");
            return;
        }
        
        
        System.out.print("Enter student name: ");
        String removeName = scanner.nextLine();
        
        
        for(Student copyStudent : studentStorage)
        {
            if(copyStudent.getName().equalsIgnoreCase(removeName))
            {
                studentStorage.remove(copyStudent);
                break;
            }
        }
        
        
        System.out.println("Records deleted successfully");
    }
    
    
    
    
    //this method is for searching student info
    public static void searchInfo()
    {
        //check if empty
        if(studentStorage.isEmpty())
        {
            System.out.println("No records available!");
            return;
        }
        
        
        System.out.print("Enter name to search: ");
        String searchName = scanner.nextLine();
        
        
        for(Student copyStudent : studentStorage)
        {
            if(copyStudent.getName().equalsIgnoreCase(searchName))
            {
                System.out.println(copyStudent);
                break;
            }
        }    
        
    }
    
    
    
    
    //this method is for showing all the data in the memory
    public static void showAll()
    {
        //check if empty
        if(studentStorage.isEmpty())
        {
            System.out.println("No records available!");
            return;
        }
        
        
        int counter = 0;  //for counting number of info
        
                
        //methods to show all data available
        for(Student copyStudent : studentStorage)
        {
            System.out.println(copyStudent);
            counter++;
        }
        
        
        System.out.println();  //newline
        System.out.println("There are " + counter + " data");
               
    }
    
    
    
    
    //method for displaying info in each department
    //under construction...
    
    
    
    
    
    
   
    
    
}







public class StudentSystem 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        boolean isProgramRunning = true;
        
        System.out.println("Welcome to the Student Portal");
        
        
        while(isProgramRunning)
        {
            System.out.println();
            System.out.println("[1] Add Student Information");
            System.out.println("[2] Remove Student Information");
            System.out.println("[3] Search Student");
            System.out.println("[4] Show All Records");
            System.out.println("[5] Show Department Records");
            
            System.out.print("Please enter your choices: ");
            int choices = scanner.nextInt();
            scanner.nextLine();
            
            
            
            
            switch(choices)
            {
                case 1:
                    StudentFunction.addInfo();
                    break;
                    
                case 2:
                    StudentFunction.removeInfo();
                    break;
                    
                case 3:
                    StudentFunction.searchInfo();
                    break;
                    
                case 4:
                    StudentFunction.showAll();
                    break;
                    
                default:
                    System.out.println("Invalid input!");
                    
            }
        }
       
        
        scanner.close();
        
    }
}
