/* Casey Gray
 * ITEC 4261 Section 02
 * February 23, 2025
 */
/*
 * A local high school has 100 lockers and 100 students. All lockers are closed on the first day of school. As the students enter,
 * the first student, denoted S1, opens every locker. Then the second student, S2, begins with the second locker, denoted L2,
 * and closes every other locker. Student S3 begins with the third locker and changes every third locker (closes it if it was open,
 * and opens it if it was closed). Student S4 begins with locker L4 and changes every fourth locker. Student S5 starts with L5 and
 * changes every fifth locker, and so on, until student S100 changes L100. 

After all the students have passed through the building and changed the lockers, which lockers are open?
Write a Java program to find your answer. Use a method to open/close lockers based on which student is currently
passing through the hallway. The program should display the answer like this (this example output may not be accurate):

Locker 1 is open

Locker 2 is open

…

Locker 100 is open

(Hint: Use an array of 100 Boolean elements, each of which indicates whether a locker is open (true) or closed (false).
Initially, all lockers are closed.)
 */
public class CEGray_Assignment3B {

	public static void main(String[] args) {
		// Declare a boolean array of 100 lockers that begin closed (false)
		boolean[] lockers = new boolean[100];
		
		// For loop that simulates the students passing through
		for (int student = 1; student <= 100; student++)
		{
			toggleLockers(lockers, student);
		}
		
		// For loop that displays which lockers are open
		for (int i = 0; i < lockers.length; i++)
		{
			if (lockers[i])
			{
				System.out.println("Locker " + (i + 1) + " is open");
			}
		}
	}
	
	// Method to toggle locker status based on the current student
	public static void toggleLockers(boolean[] lockers, int student)
	{
		// For loop that ensures that a student only interacts with lockers that are multiples of their student number
		// (Example, student 3 interacts with lockers 3, 6, 9, etc)
		for (int i = student - 1; i < lockers.length; i += student)
		{
			// Toggle the state of the locker. If it was open, then it closes, and vice-versa
			lockers[i] = !lockers[i];
		}
	}

}
