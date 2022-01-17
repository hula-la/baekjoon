n, k = map(int,input().split())
chess_pan = [] * n
chess_info_p = [[] for i in range(n)] * n
piece = [] * k
turn = 0

for i in range(n):
    chess_pan[n] = list(map(int,input().split()))

for i in range(k):
    piece[i] = list(map(int,input().split()))
    chess_info_p[piece[i][0]][piece[i][1]].append(i)

while turn < 1000:
    for i in range(k):
        if chess_info_p[piece[i][0]][piece[i][1]][0] == i:
            


    turn += 1
else:
    print(-1)