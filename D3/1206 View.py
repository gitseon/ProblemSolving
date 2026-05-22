''' 본인 작성 코드
for test_case in range(1, 11):
    N = int(input())
    h = list(map(int, input().split()))
    answer = 0
    for i in range(2, len(h) - 2):
        # 왼쪽, 오른쪽으로 1, 2번째 빌딩 비교
        left = i - 1
        right = i + 1
        if h[left] >= h[i] or h[right] >= h[i]: # 양 옆에 본인보다 크면 세대 아예 없음, 2번째 비교 필요 없음
            continue
        else: # 양 옆에 본인보다 작다면 2번째 비교
            left -= 1
            right += 1
            # 2번째가 본인보다 크면 없고 작다면 1, 2번째 중 큰 값으로 높이 차이 구하면 됨
            if h[left] >= h[i] or h[right] >= h[i]:
                continue
            else:
                answer += h[i] - max(h[left], h[i - 1], h[i + 1], h[right])

    print(f"#{test_case} {answer}")
'''

'''실행시간 측면 최적화 코드'''
for test_case in range(1, 11):
    view = 0
    n = int(input())
    maps = list(map(int, input().split()))
    for i in range(2, n - 2):
        cur = maps[i]
        highest = max(maps[i - 2 : i] + maps[i + 1 : i + 3]) # 위의 조건식 대신 가장 큰 빌딩을 찾으면 됨
        view += cur - highest if cur > highest else 0
    print(f"#{test_case} {view}")

''' -2 ~ +2 구간 내에 기준 빌딩보다 큰 빌딩이 없어야 조망권 세대가 존재함 '''