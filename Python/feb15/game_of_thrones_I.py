#!/bin/python3

import math
import os
import random
import re
import sys
from collections import *
#
# Complete the 'gameOfThrones' function below.
#
# The function is expected to return a STRING.
# The function accepts STRING s as parameter.
#

def gameOfThrones(s):
    # Write your code here
    d1 = Counter(s)
    count = 0
    for value in d1.values():
        count += value%2
            
    return (count <= 1)

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = gameOfThrones(s)
    if result:
        fptr.write('YES' + '\n')
    else:
        fptr.write('NO' + '\n')

    fptr.close()
