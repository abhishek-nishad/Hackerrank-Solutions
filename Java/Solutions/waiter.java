import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'waiter' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY number
     *  2. INTEGER q
     */
     
    public List<Integer> sieveOfEratosthenes(int n)
    {   
        boolean prime[] = new boolean[n+1];
        List<Integer> result = new ArrayList<>();
        
        Arrays.fill(prime, true);
 
        for (int p=2; p*p <= n; p++)
        {
            if (prime[p] == true)
            {
                for (int i = p*p; i <= n; i+=p)
                    prime[i] = false;
            }
        }
        for(int i=2; i<=n; i++)
        {
            if(prime[i])
                result.add(i);
        }
        return result;
    }
    
        

    public List<Integer> waiter(List<Integer> n, int q) {
    // Write your code here 
        Stack<Integer> number = new Stack<>();
        number.addAll(n);
        List<Integer> primes = sieveOfEratosthenes(10005);
        List<Integer> result = new ArrayList<>();

        Stack<Integer> a = new Stack<>();
        Stack<Integer> b = new Stack<>();
        
        for(int i=0; i<q; i++)
        {
            if(number.size()==0)
                break;
                
            while(number.size()>0)
            {
                int x = number.pop();
                if(x%primes.get(i)==0)
                    b.push(x);
                else
                    a.push(x);
            }
            while(!b.isEmpty())
                result.add(b.pop());
           
            Stack<Integer> t = a;
            a = number; 
            number = t;
        }
        while(number.size()>0)
            result.add(number.pop());
            
        return(result);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> number = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = new Result().waiter(number, q);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
