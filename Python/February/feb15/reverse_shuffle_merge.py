#!/bin/python3

import math
import os
import random
import re
import sys
from collections import *
#
# Complete the 'reverseShuffleMerge' function below.
#
# The function is expected to return a STRING.
# The function accepts STRING s as parameter.
#

def reverseShuffleMerge(s):
    # Write your code here

    available = Counter(s)
    required = dict()
    used = dict()
    ans = list()
    
    for key in available.keys():
        required[key] = available[key]//2
        used[key] = 0
        
    for ch in s[::-1]:
        
        if((required[ch] - used[ch]) > 0 and available[ch] > 0):
            while(len(ans) > 0 and ans[-1] > ch and (required[ans[-1]]-used[ans[-1]]+1) <= available[ans[-1]]):
                t = ans.pop()
                used[t] -= 1
                
            ans.append(ch)
            used[ch] += 1
        available[ch] -= 1
            
    return "".join(ans)
                

    
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = reverseShuffleMerge(s)

    fptr.write(result + '\n')

    fptr.close()
