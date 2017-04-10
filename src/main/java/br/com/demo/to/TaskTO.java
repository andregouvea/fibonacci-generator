package br.com.demo.to;

import java.io.Serializable;

public class TaskTO implements Serializable{
	private static final long serialVersionUID = 7226041466067202530L;
	private int task;
	
	public TaskTO(){
	}

	public int getTask() {
		return task;
	}

	public void setTask(int task) {
		this.task = task;
	}
	
	
}