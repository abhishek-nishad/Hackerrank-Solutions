# Enter your code here. Read input from STDIN. Print output to STDOUT

n = int(input())
stack = []
s = ''

for i in range(n):
    test = input().split()
    
    if int(test[0]) == 1:
        stack.append(s)
        s += test[1]
        
    elif int(test[0]) == 2:
        stack.append(s)
        s = s[:len(s)-int(test[1])]
        
    elif int(test[0]) == 3:
        print(s[int(test[1])-1])
        
    elif int(test[0]) == 4:
        s = stack.pop()
        
