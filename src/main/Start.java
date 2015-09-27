package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

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
	    System.out.println("Co chcesz zrobic?");
	    System.out.println("1 - add new task, 2 - remove task");
	    System.out.println("3 - list all tasks, 4 - close");
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    try {
			int command = reader.read();
			if ((command<=0)||(command>4)) {
				System.out.println("wrong command");
			} else {
				//TODO reakcja na komendy
			}
		    	
		} catch (IOException e) {
			//TODO costam wiecej
			System.out.println("wrong command ");
		}
	    
	   

	}

}
