package de.thm.david.stahl.study;

public class Grade 
{
	private int percentage;
	
	public Grade(int percentage)
	{
		setPercentage(percentage);
	}
	
	/***
	 * 
	 * @param percentage
	 * check, if the percentage parameter is between 0 and 100
	 */
	private void setPercentage(int percentage)
	{
		this.percentage = (percentage >= 0 && percentage <= 100) ? percentage : 0;
	}
	
	/***
	 * 
	 * @return Returns the percentage attribute
	 */
	public int getPercentage()
	{
		return percentage;
	}
	
	/***
	 * Checks, if it has passed
	 * @return Returns a boolean value
	 */
	public boolean hasPassed()
	{
		return percentage > 50;
	}
}
