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
     * Complete the 'bfs' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. 2D_INTEGER_ARRAY edges
     *  4. INTEGER s
     */

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
    // Write your code here
        HashMap<Integer, ArrayList<Integer>> tree = new HashMap<>();
        
        for(int i=1; i<=n; i++)
            tree.put(i, new ArrayList<Integer>());
            
        for(int i=0; i < edges.size(); i++) 
        {
            int a = edges.get(i).get(0);
            int b = edges.get(i).get(1);

            tree.get(a).add(b);
            tree.get(b).add(a);
        }    
        
        int visited[] = new int[n+1];
        int distance[] = new int[n+1];
        Arrays.fill(distance, -1);
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(s);
        distance[s] = 0;
        visited[s] = 1;
        
        while(!q.isEmpty())
        {
            int x = q.remove();
            for(int p : tree.get(x))
            {
                if(visited[p] != 1)
                {
                    visited[p] = 1;
                    distance[p] = distance[x]+6;
                    q.add(p);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        
        for(int i=1; i<=n; i++)
        {
            if(i!=s)
                result.add(distance[i]);
        }
        return result; 
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                List<List<Integer>> edges = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        edges.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int s = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = Result.bfs(n, m, edges, s);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
