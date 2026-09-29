public class PrimeIteratorTest
{
    public static void main(String[] args)
    {
        // Limit for the prime numbers
        final int LIMIT = 100000;
        
        System.out.println("Prime numbers up to " + LIMIT);

        // Create iterator up to specified limit
        PrimeIterator primeIterator = new PrimeIterator(LIMIT);

        int count = 0;

        // Iterate and display the prime numbers
        while (primeIterator.hasNext())
        {
            int prime = primeIterator.next();
            System.out.printf("%6d ", prime);
            count++;

            // Print 10 primes per line
            if (count % 10 == 0)
            {
                System.out.println();
            }
        }

        // Print final line if last line wasn't complete
        if (count % 10 != 0)
        {
            System.out.println();
        }
    }
}