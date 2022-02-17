#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'minimumBribes' function below.
#
# The function accepts INTEGER_ARRAY q as parameter.
#

def minimumBribes(A):
    # Write your code here
    count = 0
    
    for i in range(len(A)-1, -1, -1):
        if(A[i]!=i+1):
            
            if(A[i-1]==i+1):
                count+=1
                A[i], A[i-1] = A[i-1], A[i]
                
            elif(A[i-2]==i+1):
                count+=2
                A[i-2], A[i-1] = A[i-1], A[i-2]
                A[i], A[i-1] = A[i-1], A[i]
                
            else:
                print("Too chaotic")
                return
            
    print(count)
    return
                

if __name__ == '__main__':
    t = int(input().strip())

    for t_itr in range(t):
        n = int(input().strip())

        q = list(map(int, input().rstrip().split()))

        minimumBribes(q)
