package Java.jan13;
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
     * LONGEST COMMON SUBSEQUENCE
     *
     * Complete the 'commonChild' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */
    public int recursive(String s1, String s2, int m, int n)
    {
        if(m==0 || n==0)
            return 0;
        if(s1.charAt(m-1)==s2.charAt(n-1))
            return 1+recursive(s1, s2, m-1, n-1);
        else
            return Math.max(recursive(s1, s2, m-1, n), recursive(s1, s2, m, n-1));
    }
    
    public int memoization(String s1, String s2, int m, int n, int qb[][])
    {
        if(m==0 || n==0)
            return 0;
            
        if(qb[m-1][n-1] != 0)
            return qb[m-1][n-1];
        else
        {
            if(s1.charAt(m-1)==s2.charAt(n-1))
                return 1+memoization(s1, s2, m-1, n-1, qb);
            else
            {
                qb[m-1][n-1] = Math.max(memoization(s1, s2, m-1, n, qb), memoization(s1, s2, m, n-1, qb)); 
                return qb[m-1][n-1];
            }
        
        }
        
    }
    public int tabular(String s1, String s2, int m, int n)
    {
        int dp[][] = new int[m+1][n+1];

        int i=0, j=0;
        for(i=0; i<=m; i++)
        {
            for(j=0; j<=n; j++)
            {
                if(i==0 || j==0)
                    dp[i][j] = 0;
                else
                {
                    if(s1.charAt(i-1)==s2.charAt(j-1))
                        dp[i][j] = 1+dp[i-1][j-1];
                    else
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
    public static int commonChild(String a, String b){
        Result ob = new Result();
        int m = a.length();
        int n = b.length();
        
        // int qb[][] = new int[m][n];
        return ob.tabular(a, b, m, n);
        // return ob.memoization(a, b, m, n, qb);
        // return ob.recursive(a, b, m, n);
    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        int result = Result.commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
