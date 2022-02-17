#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'roadsAndLibraries' function below.
#
# The function is expected to return a LONG_INTEGER.
# The function accepts following parameters:
#  1. INTEGER n
#  2. INTEGER c_lib
#  3. INTEGER c_road
#  4. 2D_INTEGER_ARRAY cities
#

def roadsAndLibraries(n, c_lib, c_road, cities):
    # Write your code here
    graph = dict()
    ans = 0
    
    for i in range(1, n+1):
        graph[i] = []

    for a, b in cities:
        graph[a].append(b)
        graph[b].append(a)
        
    V = [False]*(n+1)
    
    for i in range(1, n+1):
        if(not V[i]):
            count = list()
            
            dfs(i, graph, V, count)
            
            if(c_lib <= c_road):
                ans += c_lib * len(count)
            else:
                ans += c_lib + c_road * (len(count)-1)
    return ans

def dfs(node, graph, V, count):
    V[node] = True
    count.append(node)
    nodes = graph[node]
    
    if(nodes!=None):
        for t in nodes:
            if(not V[t]):
                dfs(t, graph, V, count)
    
        

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    q = int(input().strip())

    for q_itr in range(q):
        first_multiple_input = input().rstrip().split()

        n = int(first_multiple_input[0])

        m = int(first_multiple_input[1])

        c_lib = int(first_multiple_input[2])

        c_road = int(first_multiple_input[3])

        cities = []

        for _ in range(m):
            cities.append(list(map(int, input().rstrip().split())))

        result = roadsAndLibraries(n, c_lib, c_road, cities)

        fptr.write(str(result) + '\n')

    fptr.close()
