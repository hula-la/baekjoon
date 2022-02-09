import sys
import itertools

lines = sys.stdin.readlines()

total = 0
total2=0
arr = []

for line in lines:
    A, B = map(int, line.split())
    print(A + B)
    total += A
    total2 += B

total += sum(sorted(arr,reverse=1)[0:15])
print(sorted(arr,reverse=1))
print(total,total2,len(arr))