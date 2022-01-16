import sys
input = sys.stdin.readline


n = int(input())
condition = list(map(int,input().split()))
array = []
V = 0
answer = []


for i in range(n):
    array.append(list(map(int,input().split())))

def check(arr,goal):
    for i in range(4):
        if arr[i]<goal[i]:
            return False
    return True

def find(idx,arr,cost,list):
    if check(arr,condition):
        answer.append([cost,list[:]])
        return

    elif idx == n:
        return

    find(idx + 1, [arr[j] + array[idx][j] for j in range(4)], cost + array[idx][4], list + [idx +1])
    find(idx + 1, arr, cost, list)

find(0,[0]*4,0,[])

answer.sort()

if len(answer) == 0:
    print(-1)
else:
    print(answer[0][0])
    print(*answer[0][1])

# 오답원인: 1. 사전순인 것을 간과 2. 조건에 맞는 경우가 없을 경우 -1을 출력하는 것을 간과