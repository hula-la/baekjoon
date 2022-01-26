N,M = map(int,input().split())
numbers = sorted(map(int,input().split()))

result = []
visited = [False] * N

def findArr(n, arr):
    if M == n:
        result.append(arr[:])

    overlap = None
    for i in range(N):
        if not visited[i] and overlap != numbers[i]:
            visited[i] = True
            findArr(n+1, arr+[numbers[i]])
            visited[i] = False     
            overlap = numbers[i]

findArr(0,[])
for i in result:
    print(*i)

# 오답원인1: 시간 초과-> 원래는 result에 arr가 중복되는게 있는지
# 확인을 했었는데 여기서 사용한 if ~ i ~ 방법이 시간 초과를 일으킨 것을
# 블로그를 통해 알게됐음.
# 그리고 거기서 알게 된 방법이 이전의 문자와 동일하면 넘어가도록 하는 방법을
# 알게 돼서 통과했음.. 블로그를 안 봤으면 한참 생각하거나 몰랐을 듯.. 