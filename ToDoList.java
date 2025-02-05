
import java.util.ArrayList; //importing arraylist to store tasks
import java.util.Scanner; //importing scanner to take user input

public class ToDoList {
    //creating arraylist to store tasks
    private static ArrayList<String> tasks= new ArrayList<>();
    //scanner object to read user input
    private static Scanner scanner = new Scanner (System.in);

    public static void main(String[] args) {
        //infinite loop to keep displaying menu until the user exits
        while(true){
            //displaying the main menu options
            System.out.println("/n to do list menu:");
            System.out.println("1: add task");
            System.out.println("2: remove task");
            System.out.println("3: view task");
            System.out.println("4: exit");
            System.out.println("choose an option...");

            //check if the input is an integer
            if(!scanner.hasNextInt()){
                System.out.println("invalid input, please eneter a valid input");
                scanner.next();  //clearing the invalid input
                continue; //jumping to the next iteration
            }

            //taking user input for the menu options
            int choice = scanner.nextInt();
            scanner.nextLine(); //consme the new line to prevent input issues

            //handling user choice using a switch statement
            switch (choice) {
                case 1:
                    addTask(); //call method to add a task
                    break;
                case 2:
                    removeTask(); //call method to remove a task
                    break;
                case 3:
                    viewTask(); //call method to view a task
                    break;
                case 4:
                    //exiting the application
                    System.out.println("exiting the application, goodbyee!");
                    return; //exiting the application and loop
                default:
                    //handling invalid inputs
                    System.out.println("invalid choice, try again...");
                    break;
            }
        }
    }

    //method to add a task

    public static void addTask(){
        System.out.println("enter a task you want to add");
        String task =  scanner.nextLine(); //reading user input
        tasks.add(task); //add task to the arraylist
        System.out.println("task added successfully");
    }

    //method to remove a task

    public static void removeTask(){
        viewTask(); //displaying the current task
        if(tasks.isEmpty()){
            System.out.println("no tasks to remove");
            return;
        }
        
        System.out.println("enter task number to remove");
        int index = scanner.nextInt() - 1; //coverting input to 0 based index
        scanner.nextLine(); //reading user input

        //checking if the entered index is within the valid range
        if(index >= 0 && index < tasks.size()) {
            tasks.remove(index); //removing the task at the given index
            System.out.println("task reomved successfully");
        } else {
            System.out.println("invalid task number");
        }
    }

    //method to display tasks

    public static void viewTask(){
        if(tasks.isEmpty()){ //checking if the task list is empty
            System.out.println("task list is empty");
        } else {
            System.out.println("\n your to do list:");

            //looping through the tasks and displaying them with numbering

            for(int i=0; i <= tasks.size(); i++) {
                System.out.println((i+1) + ". " + tasks.get(i));
            }
        }
    }
}
