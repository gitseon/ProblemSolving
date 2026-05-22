T = int(input())
for case in range(1, T + 1): # 테스트 케이스 수만큼 반복
    N = int(input()) # 좌표의 수
    points = [] # 좌표 저장 리스트
    eqxY = {} # x 좌표가 동일한 y좌표 딕셔너리
    eqyX = {} # y 좌표가 동일한 X좌표 딕셔너리
    for _ in range(N): # 좌표 입력 및 리스트에 튜플 형태로 저장
        x, y = map(int, input().split())
        points.append((x, y))
    for x, y in points:
        if x not in eqxY: # key가 되는 x좌표가 없다면 추가, value는 빈 리스트
            eqxY[x] = []
        eqxY[x].append(y) # x좌표마다 y값을 리스트에 저장

        if y not in eqyX: # key가 되는 y좌표가 없다면 추가, value는 빈 리스트
            eqyX[y] = []
        eqyX[y].append(x) # y좌표마다 x값을 리스트에 저장
    
    for x in eqxY: # 정렬 시 각 정점의 min, max로 구하지 않고 0, -1로 인덱싱해서 구할 수 있어 더 간단해짐
        eqxY[x].sort() 
    for y in eqyX:
        eqyX[y].sort()
    #print("eqyX, eqxY => ",eqyX, eqxY)

    answer = 0
    lenX = 0
    lenY = 0
    pointsX = []
    pointsY = []

    for x, y in points: # 각 점에서 그을 수 있는 x변과 y변의 최댓값을 구하면 됨(제일 멀리 떨어진 점)
        pointsX = eqyX[y]
        pointsY = eqxY[x]
        lenX = max(abs(x - pointsX[0]), abs(x - pointsX[-1]))
        lenY = max(abs(y - pointsY[0]), abs(y - pointsY[-1]))
        #print(f"lenX:{lenX}, lenY:{lenY}")
        answer = max(lenX * lenY, answer)

    print(answer)


''' <문제>
2차원 평면 위에 N개의 서로 다른 점이 있다. 각 점의 x, y 좌표는 정수이다.
당신은 이 중 서로 다른 3개의 점을 골라서 삼각형을 만들려고 한다.
이 때 삼각형의 한 변은 x축에 평행해야 하고, 다른 한 변은 y축에 평행해야 한다.

당신이 만들 수 있는 삼각형의 최대 넓이는 얼마인가?
넓이에 2를 곱하면 정수가 되니, 최대 넓이에 2를 곱해 출력하라.
만들 수 있는 삼각형이 최소 하나 존재한다. 


[입력]
첫 번째 줄에 테스트 케이스의 수 TC가 주어진다.
이후 TC개의 테스트 케이스가 새 줄로 구분되어 주어진다.
각 테스트 케이스는 다음과 같이 구성되었다. 
 - 첫 번째 줄에 점의 수 N이 주어진다. (3 ≤ N ≤ 100)
 - 이후 N개의 줄에 점의 좌표 xi, yi 가 주어진다. 모든 좌표는 서로 다르고, 좌표는 절댓값이 10000 이하인 정수이다. 

[출력]
각 테스트 케이스 마다 한 줄씩, 문제의 정답을 출력하라.
'''

'''
# 아이디어는 구상했으나 코드로 구현하는 과정 미숙
# 일일이 비교하여 같은 걸 찾는 방법도 있지만 
 - 핵심 아이디어: 
    각 축에 평행하면 직각삼각형이 만들어짐
    x축 평행 -> y값 동일, y축 평행 -> x값 동일
    직각삼각형 넓이 = 1/2 * x변 * y변 이므로 각 점에서 그을 수 있는 x변, y변의 최댓값을 구하면 됨
    x변 => y좌표값이 동일한 점들을 이어서 만듦
    y변 => x좌표값이 동일한 점들을 이어서 만듦
    
    x변의 최댓값은 y좌표값이 동일한 점들의 |x좌표 차|의 최댓값
    y변의 최댓값은 x좌표값이 동일한 점들의 |y좌표 차|의 최댓값

    출력: x좌표 차이 최댓값 * y좌표 차이 최댓값
 - 

<정리> 

'''
