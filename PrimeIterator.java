import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrimeIterator implements Iterator<Integer>
{
    // Max prime number to be checked
    private final int limit;

    // Current number being checked
    private int currentNumber;

    // Cache for the next prime in hasNext()
    private Integer nextCached = null;

    // Constructs a PrimeIterator that iterates over primes <= 'limit'
    public PrimeIterator(int limit)
    {
        if (limit < 2)
        {
            this.limit = 1;
        }

        else
        {
            this.limit = limit;
        }

        // Start before the first prime
        this.currentNumber = 1;
    }

    // Checks if given number is prime
    private static boolean isPrime(int n)
    {
        if (n <= 1)
        {
            return false;
        }

        // Check divisibility up to the sqrt of n
        for (int i = 2; i * i <= n; i++)
        {
            if (n % i == 0)
            {
                return false;
            }
        }
        return true;
    }

    // Finds the next prime number > 'currentNumber' or <= 'limit'; Returns the next prime or -1 if no more primes found
    private Integer nextPrime()
    {
        int num = currentNumber + 1;
        while (num <= limit)
        {
            if (isPrime(num))
            {
                return num;
            }
            num++;
        }
        return null;
    }

    // Returns true if there is another prime. Checks if a prime exists > 'currentNumber' or <= 'limit'
    @Override
    public boolean hasNext()
    {
        if (nextCached != null)
        {
            return true;
        }
        nextCached = nextPrime();
        return nextCached != null;
    }

    // Returns next prime, throws exception if there are no more
    @Override
    public Integer next()
    {
        if (!hasNext())
        {
            throw new NoSuchElementException("No more prime numbers up to the specified limit.");
        }

        // Update currentNumber to the prime just found
        currentNumber = nextCached;
        nextCached = null;
        return currentNumber;
    }
}
