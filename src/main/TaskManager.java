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
			System.out.println("Wrong number - out of bounds: "+e);
			return false;
		}
		return true;
	}
	
	public void listAllTasks() {
		int index=0;
		if (taskList.isEmpty()) {
			System.out.println("Task list is empty");
		} else {
		System.out.println("title description creation deadline");	
		
		for (SingleTask t : taskList) {
			System.out.print(t.getTitle()+" "+t.getDescription()+" "+t.getCreationDate()+
					t.getDeadline());
			if (t.isCompleted()) 
				System.out.print("completed: "+t.getCompletionDate());
			System.out.println("");
		}
		}//else
	}

}
