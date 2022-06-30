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

class Result
{

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Double> runningMedian(List<Integer> a) 
    {     
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((x,y) -> x-y);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x,y) -> y-x);
    
        List<Double> result = new ArrayList<>();
        for(int num : a)
        {
            if(!maxHeap.isEmpty() && num > maxHeap.peek())
                minHeap.add(num);
            
            else
                maxHeap.add(num);
            
            if(minHeap.size() - maxHeap.size() > 1)
                maxHeap.add(minHeap.poll());
            
            if(maxHeap.size() - minHeap.size() > 1)
                minHeap.add(maxHeap.poll());
            

            if(minHeap.size() > maxHeap.size())
                result.add((double)minHeap.peek());
            
            else if(maxHeap.size() > minHeap.size())
                result.add((double)maxHeap.peek());
            
            else
                result.add((maxHeap.peek() + minHeap.peek()) / 2.0);
        }
        return result;
    }

}