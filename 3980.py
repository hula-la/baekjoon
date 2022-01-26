N,M = map(int,input().split())
numbers = sorted(map(int,input().split()))

result = []
visited = [False] * N

def findArr(n, arr):
    if M == n:
        if arr not in result:
            result.append(arr[:])
            return
    for i in range(N):
        if not visited[i]:
            visited[i] = True
            findArr(n+1, arr+[numbers[i]])
            visited[i] = False     

findArr(0,[])
for i in result:
    print(*i)