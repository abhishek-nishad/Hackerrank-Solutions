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
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Double> runningMedian(List<Integer> a) {
    // Write your code here
        PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        List<Double> result = new LinkedList<>();
        
        double median = a.get(0);
        result.add(median);
        maxHeap.offer(a.get(0));
        
        for(int i=1; i<a.size(); i++)
        {
            
            int test = a.get(i);
            if(maxHeap.size()>minHeap.size())
            {
                
                if(test<median)
                {
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(test);
                }
                else 
                    minHeap.offer(test);
                    
                median = (double)(maxHeap.peek()+minHeap.peek())/2.0;
            }

            else if(maxHeap.size()==minHeap.size())
            {
                if(test<median)
                {
                    maxHeap.offer(test);
                    median = (double)maxHeap.peek();
                } 
                else 
                {
                    minHeap.offer(test);
                    median = (double)minHeap.peek();
                }
            }
            else
            {
                if(test<median)
                    maxHeap.offer(test);
                else 
                {
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(test);
                }
                    
                median = (double)(maxHeap.peek()+minHeap.peek())/2.0;
            }     
            result.add(median);
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Double> result = Result.runningMedian(a);

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
