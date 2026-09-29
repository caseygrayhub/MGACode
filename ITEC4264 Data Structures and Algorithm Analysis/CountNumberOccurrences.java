import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountNumberOccurrences 
{
    public static void main(String[] args) 
    {
        try (Scanner in = new Scanner(System.in)) {
            Map<Integer, Integer> map = new HashMap<>();
            
            while (true)
            {
                System.out.print("Enter an integer (0 to stop): ");
                int num = in.nextInt();
                if (num == 0)
                {
                    break;
                }
                
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            
            int maxCount = 0;
            for (int count : map.values())
            {
                if (count > maxCount)
                {
                    maxCount = count;
                }
            }
            
            System.out.println("Numbers with the most occurrences:");
            for (Map.Entry<Integer, Integer> entry : map.entrySet())
            {
                if (entry.getValue() == maxCount)
                {
                    System.out.println(entry.getKey() + " (" + entry.getValue() + " times)");
                }
            }
        }
    }
}
