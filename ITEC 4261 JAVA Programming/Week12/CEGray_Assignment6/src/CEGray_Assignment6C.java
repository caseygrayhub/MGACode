/* Casey Gray
 * ITEC 4261 Section 02
 * April 20, 2025
 */


 /*Write a Java program that reads in the babynames.csv files and stores the names in two data structures, one for female names
 * and one for male names.  Ask the user to enter a first name and search both structures for the name.  If the name is found,
 * print out the rank of the name along with a statement telling them how many babies were given that name from 1924 to 2023. 
 * Have the program repeat until user enters “Done” as the name to search for in the data.

 * Babynames.csv was created using the top 100 baby names for male and female babies from 1924 to 2023 according to the 
 * US Social Security Agency.  The data is formatted as follows: rank out of 100, male_name at that rank, number of babies 
 * with that name, female_name at that rank, number of babies with that name 
 */
 
 // Import necessary classes
 import java.io.BufferedReader;
 import java.io.FileReader;
 import java.io.IOException;
 import java.util.HashMap;
 import java.util.Map;
 import java.util.Scanner;
import java.util.regex.Pattern;

public class CEGray_Assignment6C {
    
    public static void main(String[] args) {
        
        // Use hashmaps to store the name data for more efficient searches
        Map<String, NameData> maleNames = new HashMap<>();
        Map<String, NameData> femaleNames = new HashMap<>();

        // File path (assuming CSV is in same folder as java file)
        String filePath = "babynames.csv";

        // Read the CSV line by line
        try (BufferedReader bReader = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            // Keep track of line number
            int lineNum = 0;
            // Define a regex pattern to split csv lines
            Pattern pattern = Pattern.compile(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            while ((line = bReader.readLine()) != null) {
                // Each line is split into an array of strings using a comma as the delimiter
                String[] data = pattern.split(line);

                // Check to see if each line of data has 5 elements
                if (data.length == 5)
                {
                    try
                    {
                        // Trim the data to remove any whitespace from the beginning or end
                        String rankStr = data[0].trim().replaceAll("[^0-9]", "");
                        //System.err.println("Rank string before parsing: '" + rankStr + "' on line " + lineNum);
                        int rank = Integer.parseInt(rankStr);
                        // Convert names to lower case to ensure no errors in case sensitivity
                        String maleName = data[1].trim().toLowerCase();
                        // Remove commas before parsing
                        String maleCountToString = data[2].trim().replace(",", "").replace("\"", "");
                        int maleCount = Integer.parseInt(maleCountToString);
                        String femaleName = data[3].trim().toLowerCase();
                        // Remove commas before parsing
                        String femaleCountToString = data[4].trim().replace(",", "").replace("\"", "");
                        int femaleCount = Integer.parseInt(femaleCountToString);

                        // Store the data in the hashmaps, using .putIfAbsent to avoid any overwrites
                        maleNames.putIfAbsent(maleName, new NameData(rank, maleCount));
                        femaleNames.putIfAbsent(femaleName, new NameData(rank, femaleCount));
                    }
                    // Catches errors for number format exception or incorrect data formatting
                    catch (NumberFormatException e)
                    {
                        System.err.println("Error parsing data on line " + lineNum + ": " + line + " - Skipping line.  Error: " + e.getMessage());
                        // Print the values of the variables before the exception
                        System.err.println("Data values: rank=" + data[0] + ", maleName=" + data[1] + ", maleCountStr=" + data[2] + ", femaleName=" + data[3] + ", femaleCountStr=" + data[4]);
                    }
                }
                
                else 
                {
                    System.err.println("Incorrect data format: " + line + "-- Skipping line.");
                }

                lineNum++;
            }
        }

        // Catch any IOexceptions and exit if there is an error reading the file
        catch (IOException e)
        {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        // Create scanner for user input
        Scanner in = new Scanner(System.in);
        String search;

        // Main loop to search for names
        do
        {
            System.out.print("Enter a name to search for (or enter 'Done' to quit): ");
            // Get user input
            search = in.nextLine().trim().toLowerCase();

            // Clean up capitalization for results output
            String displayName = search.substring(0, 1).toUpperCase() + search.substring(1);

            // If user inputs 'done', exit the loop
            if (search.equalsIgnoreCase("done")) 
            {
                break;
            }

            // Search in male names
            if (maleNames.containsKey(search))
            {
                NameData maleData = maleNames.get(search);

                // Clean up number format for output
                String formattedCount = String.format("%,d", maleData.count);
                System.out.println(displayName + " is a male name. \nRank: " + maleData.rank + "\nCount: " + formattedCount + " babies named "
                + displayName + " between 1924 and 2023.");
            }

            // Search in female names
            else if (femaleNames.containsKey(search))
            {
                NameData femaleData = femaleNames.get(search);

                // Clean up number format for output
                String formattedCount = String.format("%,d", femaleData.count);
                System.out.println(displayName + " is a female name. \nRank: " + femaleData.rank + "\nCount: " + formattedCount + 
                " babies named " + displayName+
                " between 1924 and 2023.");
            }

            // If name is not in database
            else
            {
                System.out.println(displayName + " is not found in the database.");
            }
        }

        // Continue until 'Done' is entered
        while (true);
        System.out.println("Exiting program.");

        // Close input scanner
        in.close();
    }

    // Inner class stores name data
    private static class NameData
    {
        int rank;
        int count;

        public NameData(int rank, int count)
        {
            this.rank = rank;
            this.count = count;
        }
    }
}
