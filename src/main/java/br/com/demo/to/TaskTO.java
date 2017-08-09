package br.com.demo.to;

import java.io.Serializable;

public class TaskTO implements Serializable{
	private static final long serialVersionUID = 7226041466067202530L;
	private String task;
	
	public TaskTO(){
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}
}