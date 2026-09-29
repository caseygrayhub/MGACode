import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BinPacking 
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        final int MAX_WEIGHT = 10;

        // Prompt user for number of objects
        System.out.print("Enter the number of objects: ");
        int numOfObj = in.nextInt();
        int[] weights = new int[numOfObj];

        // Prompt user for weight of objects
        System.out.print("Enter the weights of the objects: ");
        for (int i = 0; i < numOfObj; i++)
        {
            weights[i] = in.nextInt();
        }

        in.close();

        // Sort weights in ascending order
        Arrays.sort(weights);

        // Create list to hold containers
        List<List<Integer>> containers = new ArrayList<>();
        boolean[] isPacked = new boolean[numOfObj];

        // Pack the objects
        for (int i = 0; i < numOfObj; i++)
        {
            // Skip if already packed
            if (isPacked[i])
            {
                continue;
            }

            int currentWeight = weights[i];
            boolean placed = false;

            // Try to place object in existing container
            for (List<Integer> container : containers)
            {
                int containerSum = container.stream().mapToInt(Integer::intValue).sum();
                if (containerSum + currentWeight <= MAX_WEIGHT)
                {
                    container.add(currentWeight);
                    isPacked[i] = true;
                    placed = true;
                    break;
                }
            }

            // Create new container if object cannot be placed
            if (!placed)
            {
                List<Integer> newContainer = new ArrayList<>();
                newContainer.add(currentWeight);
                containers.add(newContainer);
                isPacked[i] = true;
            }
        }

        // Display results
        System.out.println();
        for (int i = 0; i < containers.size(); i++)
        {
            System.out.print("Container " + (i + 1) + " contains objects with weight ");
            for (int j = 0; j < containers.get(i).size(); j++)
            {
                System.out.print(containers.get(i).get(j) + (j < containers.get(i).size() - 1 ? " " : ""));
            }
            System.out.println();
        }
    }
}
