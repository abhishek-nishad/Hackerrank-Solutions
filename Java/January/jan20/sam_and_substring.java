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
     * Complete the 'substrings' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING n as parameter.
     */

    public static int substrings(String s) 
    {
        char []n = s.toCharArray();
        long []sum = new long[n.length];
        int result = 0;
        
        sum[0] = n[0] - '0';
        
        for(int i=1; i<n.length; i++)
            sum[i] = ((i+1)*(n[i]-'0') + 10*sum[i-1]) % (1000000007);

        for(Long value : sum)
        {
            result += value;
            result = result % (1000000007);
        }
        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String n = bufferedReader.readLine();

        int result = Result.substrings(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
