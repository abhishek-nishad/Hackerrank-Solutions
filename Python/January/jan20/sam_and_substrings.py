#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'substrings' function below.
#
# The function is expected to return an INTEGER.
# The function accepts STRING n as parameter.
#1165445685774

#445677619

def substrings(n):
    
    n = list(n)
    sum_n = [0]*len(n)
    result = 0
    
    sum_n[0] = int(n[0])
    
    for i in range(1, len(n)):
        sum_n[i] = ((i+1)*int(n[i]) + 10*sum_n[i-1]) % (10**9+7)

    for value in sum_n:
        result += value
        result = result % (10**9+7)

    return result
    
    
    
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = input()

    result = substrings(n)

    fptr.write(str(result) + '\n')

    fptr.close()
