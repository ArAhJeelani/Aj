import java.util.ArrayList;
import java.util.Scanner;

public class Main {

   
    public static void main(String[] args) {
      Scanner input = new Scanner (System.in);
      String name = "";
      ArrayList<String> tasks = new ArrayList<>();
      int value;
      System.out.print("\nWhat is your name: ");
      name = input.next();

      System.out.print("\nWelcome to the To-Do List " + name);
      
      do { 
        System.out.print("\n\nPlease Select the Number to do your necessary action\n1.Add a Task\n2.Remove a task\n3.Show a Task\n4.Make Task Urgent\n5.Quit\n\nWhat will you do: ");  
        value = input.nextInt();
        if (value ==1){
          addTask(tasks);   
        }
        else if (value ==2){
          removeTask(tasks);  
        }
        else if (value ==3){
          showTasks(tasks); 
        }
        else if (value ==4){
          urgency(tasks);  
        }
      } while (value!=5);

    }
    public static void addTask(ArrayList<String> tasks){
      Scanner input = new Scanner (System.in);
      int length = 0;
      System.out.print("\n\nAdd a Task, if you want to escape this menu, Enter Finish\n");

      while(true){ 
      System.out.print("\nAdd Task: ");
      String task = input.nextLine().trim();
      length+=1;

      if (task.equalsIgnoreCase("Finish")){
         System.out.print("\nYou have chosen to finish adding tasks.");
         break;
      }
      tasks.add(task);
      }
        
    }
    public static void removeTask(ArrayList<String> tasks){
      Scanner input = new Scanner (System.in);  
      int value;  
      String selectedtask;
      if (tasks.isEmpty()) {
        System.out.println("\nNo tasks to remove.");
        return;
      }
      for (int x=0; x<tasks.size(); x++){
        System.out.print("\n" + (x+1) + ". " + tasks.get(x));
      }
      System.out.print("\nThese are your tasks which one will you want to remove? ");
      value = input.nextInt();
      tasks.remove(value-1);   
      System.out.print("Do the Show tasks command to see your tasks");
    }
    public static void urgency(ArrayList<String> tasks){
      Scanner input = new Scanner (System.in);
      int value;
      if (tasks.isEmpty()) {
        System.out.println("\nNo tasks to mark as urgent.");
        return;
      }
      for (int x = 0; x < tasks.size(); x++) {
        System.out.println((x + 1) + ". " + tasks.get(x));
    }

      System.out.print("What task would you like to make urgent: ");
      value = input.nextInt();

      String selectedTask = tasks.get(value-1);

        // Mark the new task as urgent and move it to the top
        tasks.remove(value - 1);  // Remove the task from its original position\
        tasks.add(0, selectedTask);  // Add it to the top of the list
        
        System.out.println("Task marked as urgent.");


    }
    public static void showTasks(ArrayList<String> tasks){
      Scanner input = new Scanner (System.in);
      System.out.print("\n");
      for (int x=0; x<tasks.size(); x++){
        System.out.print("\n" + (x+1) + ". " + tasks.get(x));
      }
    }

  }    
  