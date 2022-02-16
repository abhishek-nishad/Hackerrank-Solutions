#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'waiter' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts following parameters:
#  1. INTEGER_ARRAY number
#  2. INTEGER q
#
def waiter(stack, q):
    # Write your code here
    p = []

    def isprime(n):
        for j in range(2, n):
            if n % j == 0:
                return('no')
        return('yes')
    for i in range(2, 10000):
        if (isprime(i)=='yes'):
            p.append(i)
    b = []
    a = []
    ans = []
    for i in range(q):
        while(stack):
            poped = stack.pop()
            if poped % p[i] == 0:
                b.append(poped)
            else:
                a.append(poped)
        while(b):
            ele = b.pop()
            ans.append(ele)
        stack = a
        a = []
    while(stack):
        ans.append(stack.pop())
    return(ans) 

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    first_multiple_input = input().rstrip().split()

    n = int(first_multiple_input[0])

    q = int(first_multiple_input[1])

    number = list(map(int, input().rstrip().split()))

    result = waiter(number, q)

    fptr.write('\n'.join(map(str, result)))
    fptr.write('\n')

    fptr.close()
