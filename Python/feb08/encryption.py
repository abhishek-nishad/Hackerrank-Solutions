#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'encryption' function below.
#
# The function is expected to return a STRING.
# The function accepts STRING s as parameter.
#

def encryption(s):
    # Write your code here
    s = s.replace(" ","");
    n = len(s);
    r = math.floor(math.sqrt(n));
    c = math.ceil(math.sqrt(n));
    result = "";
    if(r*c<n):
        r+=1

    for i in range(c):
        for j in range(r):
            if(j*c+i<n):
                result += s[j*c+i]
        result+=" "
    return result

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = encryption(s)

    fptr.write(result + '\n')

    fptr.close()
