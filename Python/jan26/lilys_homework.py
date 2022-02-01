#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'lilysHomework' function below.
#
# The function is expected to return an INTEGER.
# The function accepts INTEGER_ARRAY arr as parameter.
#

def get_swaps(map_arr, sort_arr, arr):
    
    swaps = 0
    
    for i in range(len(sort_arr)):
        
        j = map_arr[sort_arr[i]]
        
        if(j!=i):
            arr[i], arr[j] = arr[j], arr[i]
            swaps+=1
            map_arr[arr[j]] = j
     
    return(swaps)

def lilysHomework(arr):
    
    sort_arr = sorted(arr)
    
    map_arr = {a:i for i, a in enumerate(arr)}
    return min(get_swaps(map_arr.copy(), sort_arr[:], arr[:]), get_swaps(map_arr.copy(), sort_arr[::-1], arr[:]))

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    arr = list(map(int, input().rstrip().split()))

    result = lilysHomework(arr)

    fptr.write(str(result) + '\n')

    fptr.close()
