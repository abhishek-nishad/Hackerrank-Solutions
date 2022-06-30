import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'insertionSort' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    
    static long count = 0;
    private void merge(int[] arr, int start, int mid, int end)
    {
        
        int n1 = mid - start + 1;
        int n2 = end - mid; 
        int L[] = new int[n1+1]; 
        int R[] = new int[n2+1];

        for(int i = 0; i < n1; i++)
            L[i] = arr[start + i];

        for (int i = 0; i < n2; i++)
            R[i] = arr[mid + i + 1];

        L[n1] = R[n2] = Integer.MAX_VALUE;

        int i=0, j=0;
        for(int k = start; k <= end; k++)
        {
            if(L[i] <= R[j])
            {
                arr[k] = L[i]; 
                i++;
            }
            else
            {
                count += (n1 - i);
                arr[k] = R[j]; 
                j++;
            }
        }
    }
    private void mergeSort(int[] arr, int start, int end)
    {
        if(start < end)
        {
            int mid = start + (end - start)/2; 
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }   
/**
2402763267
1436472789
951402406
1840175551
240453481
*/
    public long insertionSort(List<Integer> arr) 
    {
    // Write your code here
        count = 0;      
        int a[] = new int[arr.size()];
        
        for(int i=0; i<arr.size(); i++)
            a[i] = arr.get(i);

        mergeSort(a, 0, arr.size()-1);
        return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrTemp[i]);
                arr.add(arrItem);
            }

            long result = new Result().insertionSort(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
