import sys
import itertools

# lines = sys.stdin.readlines()

total = 0
total2=0
arr = []

while True:
    try:
        a, b = map(int, input().split())
        total += a
        arr.append(b-a)
    except:
        break


total += sum(sorted(arr,reverse=1)[0:15])
print(sorted(arr,reverse=1))
print(total,total2,len(arr))