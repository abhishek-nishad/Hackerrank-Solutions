#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'appendAndDelete' function below.
#
# The function is expected to return a STRING.
# The function accepts following parameters:
#  1. STRING s
#  2. STRING t
#  3. INTEGER k
#

def appendAndDelete(s, t, k):
    # Write your code here
    diff = 0
    if len(s)+len(t)<=k:
        return 'Yes'
    else:
        for i in range(min(len(s),len(t))):
            if s[i]!=t[i]:
                break
        diff = (len(s)+len(t)-2*i)
        if(diff==k):
            return 'Yes'
        else:
            if k>diff and (k-diff)%2==0:
                return 'Yes'
    return 'No'

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    t = input()

    k = int(input().strip())

    result = appendAndDelete(s, t, k)

    fptr.write(result + '\n')

    fptr.close()
