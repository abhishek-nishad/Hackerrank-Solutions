#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'counterGame' function below.
#
# The function is expected to return a STRING.
# The function accepts LONG_INTEGER n as parameter.
#


def counterGame(n):
    count=0
    while n>1:
        x=math.log2(n)
        if x==int(x):
            count+=x
            break
        else:
            n-=2**(int(x))
            count+=1    

    if count%2 == 0:
        return 'Richard'
    else:
        return 'Louise'

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input().strip())

    for t_itr in range(t):
        n = int(input().strip())

        result = counterGame(n)

        fptr.write(result + '\n')

    fptr.close()
