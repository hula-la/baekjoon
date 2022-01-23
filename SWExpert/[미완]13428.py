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
            if (int(num[j]) > int(max_char)) and find_max:
                max_char = num[j]
                max_idx = j

            if (int(num[-j+i]) < int(min_char)) and find_min:
                if i == 0 and num[-j+i] == '0': continue
                min_char = num[-j+i]
                min_idx = -j+i
        
        if max_idx != i and find_max: changed_max_idx = i; final_max_idx = max_idx; find_max = False
        
        if min_idx != i and find_min: changed_min_idx = i; final_min_idx = min_idx;find_min = False

        if not max_idx and not min_idx: break

    if not find_max:
        max_num[changed_max_idx], max_num[final_max_idx] = max_num[final_max_idx],max_num[changed_max_idx]
    if not find_min:
        min_num[changed_min_idx], min_num[final_min_idx] = min_num[final_min_idx],min_num[changed_min_idx]

    print(f'#{z} {int("".join(min_num))} {int("".join(max_num))}')