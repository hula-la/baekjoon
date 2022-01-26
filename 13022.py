word = input()
len_word = len(word)
last_char = 'f'
n = 0

while n < len(word):
    number = 0
    if word[n] != 'w':
        print(0)
        break
    while word[n] == 'w':
        number += 1
        n += 1
        if n >= len_word:
            print(0)
            break
    if n >= len_word:
        break
    if word[n-number:n+3*number] != 'w'*number+'o'*number+'l'*number+'f'*number:
        print(0)
        break

    n += 3*number
else:
    print(1)
def add(a,b):
    return a+b


# 오답원인: 1. wwww 2. wolfooo 와 같은 반례를 고려하지 못했음.