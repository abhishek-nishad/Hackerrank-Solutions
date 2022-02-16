#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'queensAttack' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER n
#  2. INTEGER k
#  3. INTEGER r_q
#  4. INTEGER c_q
#  5. 2D_INTEGER_ARRAY obstacles
#

def queensAttack(n, k, rq, cq, obstacles):
    # Write your code here
    r = n - cq
    l = cq - 1
    u = n - rq
    d = rq - 1
    lu = min(l, u)
    ru = min(r, u)
    ld = min(l, d)
    rd = min(r, d)
    
    for ro, co in obstacles:
        
        if(rq==ro and cq>co):
            l = min(l, cq-co-1)
            
        elif(rq==ro and co>cq):
            r = min(r, co-cq-1)
            
        elif(cq==co and ro>rq):
            u = min(u, ro-rq-1)
            
        elif(cq==co and rq>ro):
            d = min(d, rq-ro-1)
            
        elif(ro>rq and co>cq and (co-cq == ro-rq)):
            ru = min(ru, co-cq-1)
        
        elif(rq>ro and co>cq and (co-cq == rq-ro)):
            rd = min(rd, rq-ro-1)
            
        elif(rq>ro and cq>co and (cq-co == rq-ro)):
            ld = min(ld, cq-co-1)
        
        elif(ro>rq and cq>co and (cq-co == ro-rq)):
            lu = min(lu, ro-rq-1)
            
            
    return l+r+u+d+lu+ld+ru+rd

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    first_multiple_input = input().rstrip().split()

    n = int(first_multiple_input[0])

    k = int(first_multiple_input[1])

    second_multiple_input = input().rstrip().split()

    r_q = int(second_multiple_input[0])

    c_q = int(second_multiple_input[1])

    obstacles = []

    for _ in range(k):
        obstacles.append(list(map(int, input().rstrip().split())))

    result = queensAttack(n, k, r_q, c_q, obstacles)

    fptr.write(str(result) + '\n')

    fptr.close()
