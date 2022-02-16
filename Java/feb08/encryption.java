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
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
    // Write your code here
        String s1 = "";
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)==' ')
                continue;
            else
                s1+=s.charAt(i); 
        }
        s = s1;
        int n = s.length();
        int r = (int)Math.floor(Math.sqrt(n));
        int c = (int)Math.ceil(Math.sqrt(n));
        String result = "";
        if(r*c<n)
            r++;
        
        for(int i=0; i<c; i++)
        {
            for(int j=0; j<r; j++)
            {
                if(j*c+i<n)
                 result += s.charAt(j*c+i);
            }
            result+=" ";
        }
    return result;
    }
        
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
