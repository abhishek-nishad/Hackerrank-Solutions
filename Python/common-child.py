import numpy
class Solution:
    def recursive(self, s1, s2, m, n):
        if(m==0 or n==0):
            return 0
        if s1[m-1]==s2[n-1]:
            return 1 + self.recursive(s1, s2, m-1, n-1)
        else:
            return max(self.recursive(s1, s2, m-1, n), self.recursive(s1, s2, m, n-1))
    
    def memoization(self, s1, s2, m, n, qb):
    
        if(m==0 or n==0):
            return 0
            
        if (qb[m-1][n-1] != 0):
            return qb[m-1][n-1]
            
        else:
            if(s1[m-1]==s2[n-1]):
                return 1+self.memoization(s1, s2, m-1, n-1, qb)
            else:
                qb[m-1][n-1] = max(self.memoization(s1, s2, m-1, n, qb), self.memoization(s1, s2, m, n-1, qb))
                return qb[m-1][n-1]
            
    def tabular(self, s1, s2, m, n):
        dp = numpy.zeros((m+1,n+1), int)

        for i in range(m+1):
            for j in range(n+1):
                if(i==0 or j==0):
                    dp[i][j] = 0
                else:
                    if(s1[i-1]==s2[j-1]):
                        dp[i][j] = 1 + dp[i-1][j-1]
                    else:
                        dp[i][j] = max(dp[i-1][j], dp[i][j-1])
        
        return dp[m][n]
            
    def longestCommonSubsequence(self, a: str, b: str) -> int:
        m = len(a)
        n = len(b)
        qb = numpy.zeros((m,n), int)
        return self.tabular(a, b, m, n)
        return self.memoization(a, b, m, n, qb)
        return self.recursive(a, b, m, n)