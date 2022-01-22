#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'highestValuePalindrome' function below.
#
# The function is expected to return a STRING.
# The function accepts following parameters:
#  1. STRING s
#  2. INTEGER n
#  3. INTEGER k
#

def highestValuePalindrome(s, n, k):
    # Write your code here
    l, r = 0, n-1
    ans = ['']*n
    mark = [0]*100005
    
    # create palindrome

    while(l<=r):
        
        if(l==r):
            ans[l] = s[l]
            break
        
        if(s[l]==s[r]):
            ans[l] = s[l]
            ans[r] = s[r]
            
        elif(s[l]>s[r]):
            ans[l] = ans[r] = s[l]
            k-=1
            mark[r] = 1
            
        else:
            ans[l] = ans[r] = s[r]
            k-=1
            mark[l] = 1
            
        l+=1; r-=1
    
    if(k<0):
        return '-1'
    
    #maximize palindrome value
    
    l, r = 0, n-1
    while(l<=r):
        if(l==r):
            if(ans[l]<'9' and k>=1):
                ans[l] = '9'
                break
        
        if(ans[l]<'9'):
            if(mark[l]==0 and mark[r]==0 and k>=2):
                ans[l] = ans[r] = '9'
                k-=2
                
            elif((mark[l]==1 or mark[r]==1) and k>=1):
                ans[l] = ans[r] = '9'
                k-=1
        l+=1; r-=1
        
    if(k<0):
        return '-1'
    return ''.join(ans)
            


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    first_multiple_input = input().rstrip().split()

    n = int(first_multiple_input[0])

    k = int(first_multiple_input[1])

    s = input()

    result = highestValuePalindrome(s, n, k)

    fptr.write(result + '\n')

    fptr.close()
