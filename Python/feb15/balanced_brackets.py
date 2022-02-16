#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'isBalanced' function below.
#
# The function is expected to return a STRING.
# The function accepts STRING s as parameter.
#
def isBalanced(s):
    # Write your code here
    stack = list()
    for i in range(len(s)):
        if s[i]=='{' or s[i]=='(' or s[i]=='[':
            stack.append(s[i])
        else:
            if(len(stack)>0):
                t = stack.pop()
            else:
                break
            if (t=='(' and s[i]==')') or (t=='{' and s[i]=='}') or (t=='[' and s[i]==']'):
                i+=1
            else:
                break
           
    if i==len(s):
        return "YES"
    else: 
        return "NO"
        
  

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input().strip())

    for t_itr in range(t):
        s = input()

        result = isBalanced(s)

        fptr.write(result + '\n')

    fptr.close()
 