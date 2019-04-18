package de.thm.david.stahl.priorityQueue.common;

public class Element
{
	/** Some string that describes the contents of the element. */
	private String id;
	
	/** small value = high priority */
	private int priority;

	
	public Element(String id, int priority)
	{
		this.id = id;
		this.priority = priority;
	}

	public String getId() {
		return id;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) { this.priority = priority; }
	
	public String toString() {
		return id + " (" + priority + ")";
	}
}
