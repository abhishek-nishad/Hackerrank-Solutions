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
     * Complete the 'roadsAndLibraries' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER c_lib
     *  3. INTEGER c_road
     *  4. 2D_INTEGER_ARRAY cities
     */

    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) 
    {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        long ans = 0;
        
        for(int i=1; i<=n; i++)
            graph.put(i, new ArrayList<Integer>());
            
        for(int i=0; i < cities.size(); i++) 
        {
            int a = cities.get(i).get(0);
            int b = cities.get(i).get(1);
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }    
        
        int V[] = new int[n+1];
            
        for(int j=1; j<=n; j++)
        {
            if(V[j]!=1)
            {
                ArrayList<Integer> count = new ArrayList<>();
                Result.dfs(j, graph, V, count);
                if(c_lib <= c_road)
                    ans += (c_lib * count.size());
                else
                    ans += c_lib + c_road * (count.size()-1);
            }
        }
        return ans;
    }
    public static void dfs(int node, HashMap<Integer, ArrayList<Integer>> graph, int V[], ArrayList<Integer> count)
    {
        V[node] = 1;
        count.add(node);
        List<Integer> nodes = graph.get(node);
        if(nodes!=null)
        {
            for(Integer t : nodes)
            {
                if(V[t]==0)
                    dfs(t, graph, V, count);
            }
        }
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

                int c_lib = Integer.parseInt(firstMultipleInput[2]);

                int c_road = Integer.parseInt(firstMultipleInput[3]);

                List<List<Integer>> cities = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        cities.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                long result = Result.roadsAndLibraries(n, c_lib, c_road, cities);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
