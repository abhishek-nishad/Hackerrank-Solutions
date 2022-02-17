#!/bin/python3

import math
import os
import random
import re
import sys
from collections import *
#
# Complete the 'missingNumbers' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts following parameters:
#  1. INTEGER_ARRAY arr
#  2. INTEGER_ARRAY brr
#

def missingNumbers(arr, brr):
    # Write your code here
    d1 = Counter(arr)
    d2 = Counter(brr)
    
    result = list()
    
    for k in d2.keys():
        if k in d2.keys():
            if(d2[k] - d1[k] != 0):
                result.append(k)
        else:
            result.append(k)
            
    return sorted(result)

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    arr = list(map(int, input().rstrip().split()))

    m = int(input().strip())

    brr = list(map(int, input().rstrip().split()))

    result = missingNumbers(arr, brr)

    fptr.write(' '.join(map(str, result)))
    fptr.write('\n')

    fptr.close()
