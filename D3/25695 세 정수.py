T = int(input())
for _ in range(1, T+1):
    x, y, z = map(int, input().split())
    if x == y and 1 <= z <= x: # b의 값이 정해짐
        print(z, y, z)
        continue
    if y == z and 1 <= x <= y: # c의 값이 정해짐
        print(x, x, z)
        continue
    if z == x and 1 <= y <= z: # a의 값이 정해짐
        print(x, y, y)
        continue
    else:
        print(-1, -1, -1)

''' 예시를 통한 문제 이해
x = max(a, b) = 3
y = max(b, c) = 4
z = max(c, a) = 4
a<= x, b <= x, c = 4

x = max(a, b) = 4
y = max(b, c) = 3
z = max(c, a) = 4
a = 4, b <= y, c <= y

x = max(a, b) = 4
y = max(b, c) = 4
z = max(c, a) = 3
a <= z, b = 4 c <= z


1. 존재 판단
x, y, z 중 적어도 2개의 값이 같으면서 나머지 하나의 값은 그 같은 값 이하여야 존재함
2. 존재하는 순서쌍 하나 출력

'''
''' 공간을 더 쓰지만 실행시간이 짧은 코드
t=int(input())
tc=[]
for i in range(t):
    tc.append(list(map(int,input().split())))
 
for xyz in tc:
    case = xyz.copy()
    case.sort()
    if case[0]<=case[1] and case[1]==case[2]:
        case = xyz.copy()
        if case[0]==min(case):
            print(min(case),min(case),max(case))
        elif case[1]==min(case):
            print(max(case),min(case),min(case))
        elif case[2]==min(case):
            print(min(case),max(case),min(case))
    else:
        print(-1,-1,-1)
'''