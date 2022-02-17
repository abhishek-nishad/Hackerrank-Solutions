#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'largestRectangle' function below.
#
# The function is expected to return a LONG_INTEGER.
# The function accepts INTEGER_ARRAY h as parameter.
#

def largestRectangle(heights):
    # Write your code here     
    n = len(heights)
    nsr = nextSmallestRight(heights, n)
    nsl = nextSmallestLeft(heights, n)
    maxValue = -float('inf')
        
    for i in range(0, n):
            maxValue = max(maxValue, (nsr[i]-nsl[i]-1)*heights[i])
            
    return maxValue

def nextSmallestLeft(arr, n):

    stack = list()
    result = [0]*n
                
    for i in range(0, n): 
            
        while(len(stack)!=0 and stack[-1][0] > arr[i]):
            stack.pop()
            
        if(len(stack)==0):
            result[i] = -1
            
        else :
            result[i] = stack[-1][1]
            
        tempList = list()
        tempList.append(arr[i])
        tempList.append(i)
        stack.append(tempList)
            
    return result
    
def nextSmallestRight(arr, n):
    
    stack = list()
    result = [0]*n
    
    for i in range(n-1, -1, -1): 
            
        while(len(stack)!=0 and stack[-1][0] >= arr[i]):
            stack.pop()
            
        if(len(stack)==0):
            result[i] = n
            
        else :
            result[i] = stack[-1][1]
            
        tempList = list()
        tempList.append(arr[i])
        tempList.append(i)
        stack.append(tempList)
            
    return result
    

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    h = list(map(int, input().rstrip().split()))

    result = largestRectangle(h)

    fptr.write(str(result) + '\n')

    fptr.close()
