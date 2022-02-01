#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'gridlandMetro' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER n
#  2. INTEGER m
#  3. INTEGER k
#  4. 2D_INTEGER_ARRAY track
#

def gridlandMetro(n, m, k, track):
    
    d = {}             
    total = n*m
    
    for r, c1, c2 in track:
        if r not in d:
            d[r] = [c1, c2]
            
        elif c1>d[r][1]:
            total -= c2-c1+1
        
        elif c2>d[r][1]:
            d[r][1] = c2
    
    track = 0
    for r in d.keys():
        track += d[r][1]-d[r][0]+1
    
    return total-track

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    first_multiple_input = input().rstrip().split()

    n = int(first_multiple_input[0])

    m = int(first_multiple_input[1])

    k = int(first_multiple_input[2])

    track = []

    for _ in range(k):
        track.append(list(map(int, input().rstrip().split())))

    result = gridlandMetro(n, m, k, track)

    fptr.write(str(result) + '\n')

    fptr.close()
