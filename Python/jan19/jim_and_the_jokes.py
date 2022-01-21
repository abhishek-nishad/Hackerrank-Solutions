#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'solve' function below.
#
# The function is expected to return an INTEGER.
# The function accepts 2D_INTEGER_ARRAY dates as parameter.
#

def solve(dates):
    # Write your code here
    freq = [0]*100005
    ans = 0 
    
    for b, a in dates:
        curr_base = 1
        result = 0
        flag = True
        
        while(a>0):
            rem = a%10
            
            if(rem>=b):
                flag = False
                break
            
            result += (rem * curr_base)
            curr_base *= b
            a = a//10
        
        if(flag):
            freq[result]+=1
            
    for f in freq:
        if f>1:
            ans += (f*(f-1))//2
    return ans

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    dates = []

    for _ in range(n):
        dates.append(list(map(int, input().rstrip().split())))

    result = solve(dates)

    fptr.write(str(result) + '\n')

    fptr.close()
