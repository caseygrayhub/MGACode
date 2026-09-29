import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class MatchGroupingSymbols {
    public static void main(String[] args) 
    {
        if (args.length != 1)
        {
            System.out.println("Please enter a file name as a command line argument");
            return;
        }

        String fileName = args[0];
        File file = new File(fileName);

        try (Scanner in = new Scanner(file))
        {
            Stack<Character> stack = new Stack<>();

            while (in.hasNextLine())
            {
                String line = in.nextLine();
                for (char c : line.toCharArray())
                {
                    if (c == '{' || c == '(' || c == '[')
                    {
                        stack.push(c);
                    }
                    else if (c == '}' || c == ')' || c == ']')
                    {
                        if (stack.isEmpty())
                        {
                            System.out.println("Unmatched symbol: " + c);
                            return;
                        }
                        char openingSymbol = stack.pop();

                        if (!matches(openingSymbol, c))
                        {
                            System.out.println("Mismatched symbols: " + openingSymbol + " and " + c);
                            return;
                        }
                    }
                }
            }

            if (!stack.isEmpty())
            {
                System.out.println("Unmatched opening symbol: " + stack.pop());
                return;
            }

            System.out.println("No errors found.");
        }

        catch (FileNotFoundException e)
        {
            System.out.println("File not found: " + fileName);
        }
    }

    private static boolean matches(char openingSymbol, char closingSymbol)
    {
        return (openingSymbol == '{' && closingSymbol == '}' ||
                openingSymbol == '(' && closingSymbol == ')' ||
                openingSymbol == '[' && closingSymbol == ']');
    }
}
