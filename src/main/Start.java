package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import model.SingleTask;
import io.FileHandler;

public class Start {

	public static void main(String[] args) {
		// wczytywanie pliku do listy  zadañ
		FileHandler fileHandler=new FileHandler();
		ArrayList<SingleTask> taskList = fileHandler.readFromFile();
	    if (taskList == null){
	    	System.out.println("B³¹d przy wczytywaniu listy z pliku;");
	    	//TODO na razie nie wiem co z tym zrobic wiec tworze nowa pusta liste :D
	    	taskList = new ArrayList<SingleTask>();
	    }
		//lista idzie do managera
	    TaskManager taskManager = new TaskManager(taskList);
	    //wyœwietlamy liste
	    taskManager.listAllTasks();
	    //poniewaz nie ma guja zrobmy konwersacje
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    int command = 0;
	    String title;
	    String description;
	    int year;
	    int month;
	    int day;
	    int hour;
	    int minute;
	    Date deadline;
	    while (command != 5) {
	    	switch (command) {
	    	case 0: 
	    		//little menu
	    		System.out.println("1 - add new task, 2 - remove task");
		        System.out.println("3 - list all tasks, 4 - close");
		      
		        try {
		    		command = Integer.parseInt(reader.readLine());
		    		
			    	if ((command<=0)||(command>4)) {
			     	    System.out.println("Wrong command. Please try again.");
			    		command=0;
			        } 
		   		} catch (NumberFormatException e) {
		    			System.out.println("Wrong command. Please try again");
		        } catch (IOException e) {
		        	//exception while reading from input stream
		        	System.out.println("There has been a problem while reading form input stream. Please try again.");
		        }	
		        break;
	    	case 1: 
	    		//adding task
	    		System.out.println("Title of the task:");
	    		try {
	    			//TODO dodac kontrole bledow, mozliwosc powtorzenia
					title = reader.readLine();
					System.out.println("Description:");
					description = reader.readLine();
					System.out.println("Year:");
					year = Integer.parseInt(reader.readLine());
					System.out.println("Month:");
					month = Integer.parseInt(reader.readLine());
					System.out.println("Day:");
					day = Integer.parseInt(reader.readLine());
					System.out.println("Hour:");
					hour = Integer.parseInt(reader.readLine());
					System.out.println("Minutes:");
					minute = Integer.parseInt(reader.readLine());
					Calendar calendar = Calendar.getInstance();
					calendar.set(year, month, day, hour, minute);
					deadline = calendar.getTime();
					taskManager.addTask(new SingleTask(title, description, new Date(), deadline));
	    		} catch (NumberFormatException e) {
	    			System.out.println("Wrong number. Please try again");
				} catch (IOException e1) {
					//exception while reading from input stream
		        	System.out.println("There has been a problem while reading form input stream. Please try again.");
		           
				}
	    		 command=0;
	    		 break;
	    		
	    	case 2:
	    		//removing task form list
	    		if (taskManager.numberOfTasks()==0) {
	    			System.out.println("There are no tasks to remove");
	    			command=0;
	    			
	    		} else {
	    			System.out.println("Specify the number of task to remove:");
	    			try {
		    			command = Integer.parseInt(reader.readLine());
			    	    if (!taskManager.removeTask(command)) {
			    		    System.out.println("Task of specified index don't exist.");
				        } else {
				        	System.out.println("Taks removed.");
				        }
			    	    command=0;
		    		} catch (NumberFormatException e) {
		    			System.out.println("Wrong command. Please try again");
		    		} catch (IOException e) {
						System.out.println("Problem while reading from stream. Please try again.");
					}
	    		} 
	    		break;
	    	case 3:
	    		//task list
	    		taskManager.listAllTasks();
	    		command=0;
	    		break;
	    	case 4:
	            //close the program
	    		System.out.println("Good bye!");
	    		command=5;
	    		break;
	    	}
	    }
	   
	   
		    	
		
	    
	   

	}

}
