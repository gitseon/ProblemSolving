T = int(input())
position = {'N' : 'S', 
            'S' : 'N', 
            'W' : 'E',
            'E' : 'W'}

for t in range(1, T+1):
    A = input()
    s = list(A)
    for i in range(len(s)):
        if not position[s[i]] in s: 
            print("No")
            break
    else: # 끝까지 조건 불만족하는 경우의 분기를 의도할경우 for - else 활용하기
        print("Yes")
        ''' 
        아래 코드는 결과적으로 만족하나, 
        명시적인 부분이나 가독성 측면 그리고 흐름을 따라가기에 좋진 않음
        elif i == len(s)-1 and position[s[i]] in s:
            print("Yes")
        '''

''' 논리 조건을 수식화한 코드'''
T = int(input())
for _ in range(T):
    A = input()
    ns_ok = ('N' in A) == ('S' in A) # N이 있을때 S가 있으면 true 혹은 둘 다 없으면 true (동치)
    ew_ok = ('E' in A) == ('W' in A) # E가 있을때 W가 있으면 true 혹은 둘 다 없으면 true (동치)
    print("Yes" if ns_ok and ew_ok else "No")
