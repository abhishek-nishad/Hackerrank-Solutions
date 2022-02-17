#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'abbreviation' function below.
#
# The function is expected to return a STRING.
# The function accepts following parameters:
#  1. STRING a
#  2. STRING b
# from numpy import zeroes
# matrix = zeros((n,m), 0)




def abbreviation(a, b):
    
    m = len(a)
    n = len(b)

    dp = [[0]*(m+1) for _ in range(n+1)]
    dp[0][0] = 1
    
    for i in range(1, m+1):
        if(a[i-1].islower() and dp[0][i-1]==1):
            dp[0][i] = 1
        
    for i in range(1, n+1):
        for j in range(1, m+1):
            
            if a[j-1].isupper():
                if a[j-1] == b[i-1] and dp[i-1][j-1]==1:
                    dp[i][j] = 1
            else:
                if a[j-1].upper() == b[i-1] and dp[i-1][j-1] == 1:
                    dp[i][j] = 1
                else:
                    dp[i][j] = dp[i][j-1]
                    
    if dp[n][m] == 1:
        return "YES"
    else:
        return "NO"

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    q = int(input().strip())

    for q_itr in range(q):
        a = input()

        b = input()

        result = abbreviation(a, b)

        fptr.write(result + '\n')

    fptr.close()
