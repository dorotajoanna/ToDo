package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import model.SingleTask;

public class FileHandler {
	
    private File file;
	DateFormat dateFormat;
	
	
	public FileHandler() {
		super();
		
	}

	
	
	public ArrayList<SingleTask> readFromFile() {
	  String line;
	  ArrayList<SingleTask> taskList = new ArrayList<SingleTask>();
	  file = new File("baza.txt");
	  if (!file.exists()) {
		  try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("B³¹d przy tworzeniu pliku: " + e.getMessage());
			return null;
		}
	  }
	  //file exists now lets read
	  try {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		line = reader.readLine();
		//create DateFormat for date parsing
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		//create new task list
	    
		while (line!=null) {
			//create new task
			SingleTask task = new SingleTask();
			//split the line
			Scanner scanner = new Scanner(line);
			scanner.useDelimiter(";");
			//fill new task's fields
			//title
			task.setTitle(scanner.next());
		    //description
			task.setDescription(scanner.next());
			//creation date
			task.setCreationDate(dateFormat.parse(scanner.next()));
			//deadline
			task.setDeadline(dateFormat.parse(scanner.next()));
			//completed
			if (scanner.hasNext()) task.setCompleted(scanner.next()=="true");
			//completion date
			if (scanner.hasNext()) task.setCompletionDate(dateFormat.parse(scanner.next()));
			//add new task to the task list
		    taskList.add(task);	
		    //close the scanner
		    scanner.close();
		    //read next line
		    line=reader.readLine();
		}
		//closing reader, returning task list
		reader.close();
		return  taskList;
	  } catch (FileNotFoundException e) {
		// should not happen at all
		  System.out.println("File not found - can't happen at all");
		e.printStackTrace();
		return null;
	  } catch (IOException e) {
		// problem with reading from file
		System.out.println("Exception while reading from file");  
		e.printStackTrace();
		return null;
	} catch (ParseException e) {
		// problem with parsing dates
		System.out.println("Date parsing doesn't work properly");
		e.printStackTrace();
		return null;
	}
	 
	   
	}
	
	public boolean writeToFile(ArrayList<SingleTask> taskList) {
		if (taskList.isEmpty()) {
			// TODO czyszczenie pliku 
		} else {
			// TODO ³adny zapis do pliku
		}
		
		return true;
	}
	
	
	
}
