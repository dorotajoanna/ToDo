package model;

import java.util.Date;

public class SingleTask {

	private String title;
	private String description;
	private Date creationDate;
	private Date deadline;
	private boolean completed;
	private Date completionDate;
	

	public SingleTask() {
		super();
	}

	public SingleTask(String title, String description, Date creationDate,
			Date deadline) {
		super();
		this.title = title;
		this.description = description;
		this.creationDate = creationDate;
		this.deadline = deadline;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public Date getDeadline() {
		return deadline;
	}
	
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	
	public boolean isCompleted() {
		return completed;
	}
	
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	public Date getCompletionDate() {
		return completionDate;
	}
	
	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	
	
}
