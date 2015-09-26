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
	private ArrayList<SingleTask> taskList;
	DateFormat dateFormat;
	
	public void checkFile() {
	  String line;	
	  file = new File("baza.txt");
	  if (!file.exists()) {
		  try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("B³¹d przy tworzeniu pliku: " + e.getMessage());
		}
	  }
	  //file exists now lets read
	  try {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		line = reader.readLine();
		//create DateFormat for date parsing
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
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
			}
			
		
	  } catch (FileNotFoundException e) {
		// should not happen at all
		e.printStackTrace();
	  } catch (IOException e) {
		// problem with reading from file
		e.printStackTrace();
	} catch (ParseException e) {
		// problem with parsing dates
		e.printStackTrace();
	}
	   
	}
	
	
	
	
}
