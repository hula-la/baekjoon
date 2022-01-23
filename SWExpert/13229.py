week = ['SUN','MON','TUE','WED','THU','FRI','SAT']
left_day = {k:i for k,i in zip(week,range(7,0,-1))}

n = int(input())
for i in range(1,n+1):
    print(f'#{i} {left_day[input()]}')

# 오답 원인1: 출력 문자열 형식을 제대로 못 봄 (#1 ~~)
# 오답 원인2: week에서 THU를 THI로 오타났음.