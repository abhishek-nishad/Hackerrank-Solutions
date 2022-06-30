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
     * Complete the 'solve' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY dates as parameter.
     */

    public static long solve(List<List<Integer>> dates)   //Test case 6 fails for int.
    {
        int freq[] = new int[100005];
        long ans = 0;    //Test case 6 fails for int.
        
        for(int i=0; i<dates.size(); i++)
        {
            int a = dates.get(i).get(1);
            int b = dates.get(i).get(0);
            
            int curr_base = 1;
            int result = 0; 
            boolean flag = true;
            
            while(a>0)
            {
                int rem = a%10;
                if(rem>=b)
                {
                    flag = false;
                    break;
                }
                result += (rem * curr_base);
                curr_base *= b;
                a/=10;
            }
            if(flag)
                freq[result]++;
            
        }
            
        for(int i=0; i<freq.length; i++)
        {
            long f = freq[i];           //Test case 6 fails for int.
            if(f>1)
                ans += (f * (f-1))/2;
        }
            
        return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> dates = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                dates.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = Result.solve(dates);          //Test case 6 fails for int.

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
