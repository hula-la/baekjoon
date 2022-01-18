n, k = map(int,input().split())
chess_pan = [[] for _ in range(n)]
chess_info_p = [[[] for j in range(n)] for i in range(n)]
piece = [[] for _ in range(k)]
turn = 0
reverse_dir = {1:2,2:1,3:4,4:3}

# 체스말 이동 함수 (체스판 정보와 체스 정보 수정)
def move_chess(i0, j0,dir):
    if dir == 2:
        chess_info_p[i1][j1] = chess_info_p[i0][j0].reverse()
    else:
        chess_info_p[i1][j1] = chess_info_p[i0][j0]

    chess_info_p[i0][j0] = []

    for i in chess_info_p[i0][j0]:
        if dir == 1:
            piece[i][2] = reverse_dir[piece[i][2]]
        piece[i][0] = i1
        piece[i][0] = j1


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
        print(i)
        print(chess_info_p[piece[i][0]][piece[i][1]])
        if chess_info_p[piece[i][0]][piece[i][1]][0] == i:

            after_row = piece[i][0]
            after_col = piece[i][1]
            # 오른의 경우
            if piece[i][2] == 1:
                after_col += 1
            # 왼의 경우
            if piece[i][2] == 2:
                after_col -= 1
            # 위의 경우
            if piece[i][2] == 3:
                after_row -= 1
            # 아래의 경우
            if piece[i][2] == 4:
                after_row += 1

            move_chess(piece[i][0], piece[i][1], after_row, after_col, piece[i][2])

    turn += 1
else:
    print(-1)