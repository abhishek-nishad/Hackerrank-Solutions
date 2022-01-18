#!/bin/python3

import math
import os
import random
import re
import sys
from heapq import *
#
# Complete the 'runningMedian' function below.
#
# The function is expected to return a DOUBLE_ARRAY.
# The function accepts INTEGER_ARRAY a as parameter.
#

def runningMedian(a):
    minHeap = []
    maxHeap = []
    result = []
    
    median = float(a[0])
    result.append(median)
    heappush(maxHeap, -a[0])
    
    for i in range(1, len(a)):
        t = a[i]
        
        if(len(maxHeap)>len(minHeap)):
            if(t<median):
                heappush(minHeap, -heappop(maxHeap))
                heappush(maxHeap, -t)
            
            else:
                heappush(minHeap, t)
            
            median = (-maxHeap[0]+minHeap[0])/2

        elif(len(maxHeap)==len(minHeap)):
        
            if(t<median):
                heappush(maxHeap, -t)
                median = -maxHeap[0]
    
            else:
                heappush(minHeap, t)
                median = minHeap[0]
                
        else:
            
            if(t<median):
                heappush(maxHeap,-t)
            else:
                heappush(maxHeap, -heappop(minHeap))
                heappush(minHeap, t)
                    
            median = (-maxHeap[0]+minHeap[0])/2   
            
        result.append(median)
        
    return result
    
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    a_count = int(input().strip())

    a = []

    for _ in range(a_count):
        a_item = int(input().strip())
        a.append(a_item)

    result = runningMedian(a)

    fptr.write('\n'.join(map(str, result)))
    fptr.write('\n')

    fptr.close()
