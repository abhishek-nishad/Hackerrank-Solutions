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
     * Complete the 'abbreviation' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */

    public String abbreviation(String a, String b) {
    // Write your code here
        if(tabular(a, b, a.length(), b.length()))
            return "YES";
        return "NO";

    }
    public boolean tabular(String s1, String s2, int m, int n)
    {
        boolean dp[][] = new boolean[n+1][m+1];
        int i=0, j=0;
        
        for(i=0; i<=n; i++)
            Arrays.fill(dp[i], false);
            
        dp[0][0] = true;
        
        
        for(i=1; i<=m; i++)
            if(Character.isLowerCase(s1.charAt(i-1)) && dp[0][i-1])
                dp[0][i] = true;
    
                
                    
        for(i=1; i<=n; i++)
        {
            for(j=1; j<=m; j++)
            {
                if(Character.isUpperCase(s1.charAt(j-1)))
                {
                    if(s1.charAt(j-1) == s2.charAt(i-1) && dp[i-1][j-1])
                        dp[i][j] = true;
                }
                else
                {
                    if(Character.toUpperCase(s1.charAt(j-1)) == s2.charAt(i-1) && dp[i-1][j-1])
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[n][m];
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String a = bufferedReader.readLine();

                String b = bufferedReader.readLine();

                String result = new Result().abbreviation(a, b);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
