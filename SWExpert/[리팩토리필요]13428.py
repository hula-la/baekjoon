n = int(input())

for z in range(1,n+1):
    num = input()
    min_num = list(num)[:]
    max_num= list(num)[:]
    find_max = find_min = True

    for i in range(len(num)):
        max_char = min_char = num[i]
        max_idx = min_idx = i
        

        for j in range(i+1, len(num)):
            if (int(num[-j+i]) > int(max_char)) and find_max:
                max_char = num[-j+i]
                max_idx = -j+i

            if (int(num[-j+i]) < int(min_char)) and find_min:
                if i == 0 and num[-j+i] == '0': continue
                min_char = num[-j+i]
                min_idx = -j+i
        
        if max_idx != i and find_max: changed_max_idx = i; final_max_idx = max_idx; find_max = False
        
        if min_idx != i and find_min: changed_min_idx = i; final_min_idx = min_idx;find_min = False

        if not find_max and not find_min: break

    if not find_max:
        max_num[changed_max_idx], max_num[final_max_idx] = max_num[final_max_idx],max_num[changed_max_idx]
    if not find_min:
        min_num[changed_min_idx], min_num[final_min_idx] = min_num[final_min_idx],min_num[changed_min_idx]

    print(f'#{z} {int("".join(min_num))} {int("".join(max_num))}')

'''
 오답 원인 1: 최솟값과 최댓값 둘다 끝에서 부터 순회해야 함
 ex) 342525 ->제일 오른쪽 5와 교환해야 542523으로 최댓값이 되고
              제일 오른쪽 2와 교환해야 242535으로 최솟값이 됨.
하지만, 최솟값은 그렇게 생각했지만 최댓값은 앞에서부턴지 알고 착각했음.

오답 원인 2: min_num = max_num = input() 이렇게 작성하면 두 배열의 메모리 주소가
같아서 max_num을 수정하면 같이 수정될 수 있음.

오답 원인 3: find_max 불리언을 for 문 안에 써서 계속 True로 초기화되게 작성했었음.

이 외에도 고려를 못한 부분이 너무 많았음ㅜ 시간이 너무 많이 걸렸음..
지금 작성한 건 너무 지저분하고 min과 max값이 동일한 메커니즘이니까 짧게 작성할 수 있을 것임.
하지만 지금은 귀찮으니 담으로 미뤄야겠움..
'''