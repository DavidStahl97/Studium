package de.thm.david.stahl.instancemethod;

public class Main 
{
	/***
	 * Demonstrates the percentage check
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Grade test1 = new Grade(50);
		Grade test2 = new Grade(-10);
		
		printGrade("Test 1", test1);
		printGrade("Test 2", test2);
	}

	/***
	 * Prints the Grade
	 * @param title
	 * @param grade
	 */
	private static void printGrade(String title, Grade grade) 
	{
		System.out.println(title + ": " + grade.getPercentage() + "% - passed: " + grade.hasPassed());
	}
}
