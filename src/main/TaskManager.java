package main;

import java.util.ArrayList;

import model.SingleTask;

public class TaskManager {
	private ArrayList<SingleTask> taskList;

	public TaskManager(ArrayList<SingleTask> taskList) {
		super();
		this.taskList = taskList;
	}
	
	public void addTask(SingleTask task){
		taskList.add(task);
	}
	
	public boolean removeTask(int number){
		try {
			taskList.remove(number);
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("Wrong index - out of bounds: "+e);
			return false;
		}
		return true;
	}
	
	public void listAllTasks() {
		int index=0;
		if (taskList.isEmpty()) {
			System.out.println("Task list is empty");
		} else {
			// list tasks TODO na razie na chama
		    System.out.println("index title description creation deadline");	
		
		    for (SingleTask t : taskList) {
			    System.out.print(index+" "+t.getTitle()+" "+t.getDescription()+" "+t.getCreationDate()+
					t.getDeadline());
			    if (t.isCompleted()) 
			     	System.out.print("completed: "+t.getCompletionDate());
			    System.out.println("");
			    index++;
		    }
		}//else
	}
	
	public int numberOfTasks(){
		return taskList.size();
	}
	
	public void listTaskNumber(int number){
		try {
			SingleTask task = taskList.get(number);
			//list task TODO na razie na chama
			System.out.println("task number: "+number);
			System.out.println(task.getTitle()+" "+task.getDescription()+ " "+
			     task.getCreationDate()+" "+task.getDeadline());
			if (task.isCompleted()) 
		     	System.out.print("completed: "+task.getCompletionDate());
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("Wrong index - out of bounds: "+e);	
		}
	}

}
