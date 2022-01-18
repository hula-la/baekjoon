import sys

n, k = map(int,input().split())
chess_pan = [[] for _ in range(n)]
chess_info_p = [[[] for j in range(n)] for i in range(n)]
piece = [[] for _ in range(k)]
turn = 1
reverse_dir = {1:2,2:1,3:4,4:3}

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

def after_chess(i0,j0,dir):
    return i0+dx[dir-1], j0+dy[dir-1]

# 체스말 이동 함수 (체스판 정보와 체스 정보 수정)
def move_chess(i0, j0, color):
    if chess_pan[i1][j1] == 1:
        chess_info_p[i1][j1].extend(reversed(chess_info_p[i0][j0]))
    else:
        chess_info_p[i1][j1].extend(chess_info_p[i0][j0])

    chess_info_p[i0][j0] = []

    for i in chess_info_p[i1][j1]:
        piece[i][0] = i1
        piece[i][1] = j1


def blue_pan(i0, j0):
    # for i in chess_info_p[i0][j0]:
    #     piece[i][2] = reverse_dir[piece[i][2]]
    piece[i][2] = reverse_dir[piece[i][2]]

# 체스 판 정보 (색깔, 1:빨간, 2: 파란)
for i in range(n):
    chess_pan[i] = list(map(int,input().split()))

# 체스 말 정보 (행, 열, 방향)
for i in range(k):
    piece[i] = list(map(int,input().split()))
    piece[i][0] -= 1
    piece[i][1] -= 1

    chess_info_p[piece[i][0]][piece[i][1]].append(i)

while turn < 1000:
    for i in range(k):
        # 맨 밑에 있을 때만 이동
        if chess_info_p[piece[i][0]][piece[i][1]][0] == i:
            i0 = piece[i][0]
            j0 = piece[i][1]
            dir = piece[i][2]
            i1,j1 = after_chess(i0, j0, dir)

            if not(0<=i1<n and 0<=j1<n) or chess_pan[i1][j1] == 2:
                blue_pan(i0, j0)
                i1, j1 = after_chess(i0, j0, piece[i][2])
            if (0<=i1<n and 0<=j1<n) and chess_pan[i1][j1] != 2:
                move_chess(i0, j0, chess_pan[i1][j1])

                if len(chess_info_p[i1][j1]) >= 4:
                    print(turn)
                    sys.exit()
    turn += 1
print(-1)
