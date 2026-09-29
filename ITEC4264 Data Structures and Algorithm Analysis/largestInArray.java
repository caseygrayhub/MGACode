// Casey Gray
// ITEC 4264
// August 29, 2025

import java.util.ArrayList;

public class largestInArray {

	// Finds and returns the largest element in an array
	// list = the array to search through
	// <E> the type of elements in the list
	// returns the largest element in the list
	// Throws an exception if the list is null/empty
	public static <E extends Comparable <E>> E max(ArrayList<E> list)
	{
		// Check for invalid input
		if (list == null || list.isEmpty())
		{
			throw new IllegalArgumentException("The list cannot be null or empty.");
		}
		
		// Initialize max within the first element
		E max = list.get(0);
		
		// Iterate through the rest of the list to find the largest element
		for (int i = 1; i < list.size(); i++)
		{
			// Compare the current element with the current max. If the current element is greater,
			// update max.
			if (list.get(i).compareTo(max) > 0)
			{
				max = list.get(i);
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) 
	{
		// Test with an array of integers
		ArrayList<Integer> intList = new ArrayList<>();
		intList.add(572);
		intList.add(298);
		intList.add(1462);
		intList.add(930);
		intList.add(34);
		
		System.out.println("Integer list: " + intList);
		System.out.println("Largest int: " + max(intList));
		System.out.println("---------------");
		
		// Test with an array of strings
		ArrayList<String> strList = new ArrayList<>();
		strList.add("apple");
		strList.add("grape");
		strList.add("pineapple");
		strList.add("pear");
		
		System.out.println("String list: " + strList);
		System.out.println("Largest string: " + max(strList));
		System.out.println("---------------");
		
		// Test with an empty list
		ArrayList<Double> emptyList = new ArrayList<>();
		try
		{
			max(emptyList);
		}
		catch (IllegalArgumentException e)
		{
			System.out.println("Empty list test: " + e.getMessage());
		}
	}

}
