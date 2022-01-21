import sys

input = sys.stdin.readline

n = int(input())
people = {}

for _ in range(n):
    name = input()
    if name in people:
        people[name] += 1
    else:
        people[name] = 1

for _ in range(n-1):
    name = input()
    people[name] -= 1
    if people[name] == 0:
        people.pop(name)


print(list(people)[0].rstrip('\n'))
