'''
import itertools

n, m = map(int,input().split())

for i in itertools.permutations(range(1,n+1), m):
    print(*i)
'''

N,M = map(int,input().split())
answer = []


def MyItertools(idx, save, visited):
    if (idx == M):
        answer.append(save[:])
        return

    for i in range(1,N+1):
        if not visited[i]:
            visited[i] = 1
            save.append(i)
            MyItertools(idx+1,save,visited)
            save.pop()
            visited[i] = 0

MyItertools(0, [], [0]*(N+1))

for i in answer:
    print(*i)