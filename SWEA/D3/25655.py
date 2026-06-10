closeNums = { 0 : '1', 1 : ['0', '4'], 2 : '8' }

T = int(input())
for _ in range(1, T + 1):
    X = int(input())
    if X <= 2: # 한 자릿수의 경우 바로 대응하여 즉시 출력 가능
        print(closeNums[X][0])
        continue
    else: # 두 자릿수 이상
        q, r = divmod(X, 2)
        N = [2] * q
        if r != 0:
            N.append(r)
        N.sort()

        for i in range(len(N)):
            if i == 0 and N[i] == 1:
                print(closeNums[N[i]][1], end='')
                continue
            print(closeNums[N[i]][0], end='')
        print()

'''
핵심 아이디어
- 닫힌구간의 개수(X)에서 숫자가 최소가 되려면 자릿수가 최소가 되야함
자릿수가 최소가 되기 위해선 최대한 많은 자리를 8(2)로 표현해야 한다.
-> X가 짝수면 2로 나눈 몫이 자리의 수가 되고, 홀수일경우 몫 + 1(나머지에 해당하는 수)가 된다.
- 오름차순으로 정렬(sort)하여 높은 자릿수에 작은 수가 오도록 한다.
  단, 첫번째 자리는 0이 될 수 없으므로 예외처리한다.
'''

'''분기로 각 자릿수를 결정하기'''
def sol():
    cur = int(input())
    if cur == 1:
        return 0
    elif cur % 2 == 0:
        return '8' * (cur // 2)

    return '4' + '8' * ((cur - 1) // 2)


[print(sol()) for _ in range(int(input()))]

'''숫자, 파이썬 특성을 이용하여 문자열 연산하여 출력한 모습'''
T = int(input())
result = []
for test_case in range(1, T + 1):
    n = int(input(''))
    numberofeight = n // 2
    if n == 1:
        result.append('0')
    elif n % 2 == 0:  # 짝수
        temp = '8' * numberofeight
        result.append(temp)
    else:
        temp = '4'
        temp += ('8' * numberofeight)
        result.append(temp)

for e in result:
    print(e)