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
     * Complete the 'highestValuePalindrome' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER n
     *  3. INTEGER k
     */

    public static String highestValuePalindrome(String c, int n, int k) 
    {
        int l=0, r=n-1;
        char s[] = c.toCharArray();
        char ans[] = new char[n];
        int mark[] = new int[100005];

        while(l<=r)
        {
            if(l==r)
            {
                ans[l] = s[l];
                break;
            }
            if(s[l]==s[r])
            {
                ans[l] = s[l];
                ans[r] = s[r];
            }    
            else if(s[l]>s[r])
            {
                ans[l] = ans[r] = s[l];
                k-=1;
                mark[r] = 1;
            }           
            else
            {
                ans[l] = ans[r] = s[r];
                k-=1;
                mark[l] = 1;
            }

           l+=1; r-=1;
        }
        
        if(k<0)
            return "-1";
        
        l=0; r = n-1;
        while(l<=r)
        {
            if(l==r)
            {
                if(ans[l]<'9' && k>=1)
                {
                    ans[l] = '9';
                    break;
                }
            }
            if(ans[l]<'9')
            {
                if(mark[l]==0 && mark[r]==0 && k>=2)
                {
                    ans[l] = ans[r] = '9';
                    k-=2;
                }   
                else if((mark[l]==1 || mark[r]==1) && k>=1)
                {
                    ans[l] = ans[r] = '9';
                    k-=1;
                }
            }
            l+=1; r-=1;
        } 
        if(k<0)
            return "-1";
        return (new String(ans));
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String s = bufferedReader.readLine();

        String result = Result.highestValuePalindrome(s, n, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
