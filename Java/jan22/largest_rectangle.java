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
     * Complete the 'largestRectangle' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY h as parameter.
     */

    public static long largestRectangle(List<Integer> h) {
    // Write your code here
        Integer heights[] = h.toArray(new Integer[h.size()]);
        
        int n = heights.length;
        int[] nsr = Result.nextSmallestRight(heights, n);
        int[] nsl = Result.nextSmallestLeft(heights, n);
        int maxValue = Integer.MIN_VALUE;
        
        for(int i=0; i<n; i++)
        {
            maxValue = Math.max(maxValue, (nsr[i]-nsl[i]-1)*heights[i]);
        }
        return maxValue;

    }
    public static int[] nextSmallestLeft(Integer[] arr, int n)
    {
        Stack<int[]> stack = new Stack<>();
        int[] result = new int[n];
        
        for(int i=0; i<n; i++) 
        {
            while(!stack.empty() && stack.peek()[0] > arr[i]) 
                stack.pop();
            
            if(stack.empty()) 
                result[i] = -1;
            
            else  
                result[i] = stack.peek()[1];
            
            int[] tempList = new int[2];
            
            tempList[0] = arr[i];
            tempList[1] = i;
                stack.push(tempList);
        }
        return result;
    }
    
    public static int[] nextSmallestRight(Integer[] arr, int n)
    {
        Stack<int[]> stack = new Stack<>();
        int[] result = new int[n];
        
        for(int i=n-1; i>=0; i--) 
        {
            while(!stack.empty() && stack.peek()[0] >= arr[i]) 
                stack.pop();
            
            if(stack.empty()) 
                result[i] = n;
            
            else  
                result[i] = stack.peek()[1];
            
            int[] tempList = new int[2];
            
            tempList[0] = arr[i];
            tempList[1] = i;
            stack.push(tempList);
        }
        // Collections.reverse(result);
        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        long result = Result.largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
