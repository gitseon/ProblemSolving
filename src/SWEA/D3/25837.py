''' 실패 코드 (복소수, ** 0.5 자릿수 미고려)
T = int(input())
for _ in range(1, T + 1):
    S, P = map(int, input().split())
    plusMN = (S + (S ** 2 - 4 * P) ** 0.5) // 2
    minusMN = (S - (S ** 2 - 4 * P) ** 0.5) // 2

    if plusMN > 0 and minusMN > 0 and plusMN % 2 == 0 and minusMN % 2 == 0:
        if plusMN + plusMN == S and plusMN * plusMN == P:
            print("Yes")
        elif plusMN + minusMN == S and plusMN * minusMN == P:
            print("Yes")
        elif minusMN + minusMN == S and minusMN * minusMN == P:
            print("Yes")
    else:
        print("No")
'''
''' 근의 공식 활용
import math

T = int(input())
for _ in range(T):
    S, P = map(int, input().split())

    D = S * S - 4 * P  # 근호 안의 식, 음수 판별(복소수 판별) 후 진행해야 하므로 분리
    if D < 0:  # 조건 1: 판별식 음수
        print("No")
        continue  # 위 조건을 만족하면 출력 후 아래는 실행하지 않고 다 건너뛰어야 함, 반복문 내 이므로 다음 테스트케이스로 넘어감(Early Return)

    sqrt_D = math.isqrt(D)  # 정수 제곱근 (소수점 버림, 오차 없음), ** 0.5는 float 유효숫자 자릿수(15~17자리)에 따른 소숫점 문제로 인해 지양함.
    if sqrt_D * sqrt_D != D:  # 조건 2: 완전제곱수 아님
        print("No")
        continue

    if (S - sqrt_D) % 2 != 0:  # 조건 3: 홀/짝 체크 (2로 나눠 떨어지는지)
        print("No")
        continue

    N = (S + sqrt_D) // 2
    M = (S - sqrt_D) // 2

    print("Yes" if N >= 1 and M >= 1 else "No")  # 조건 4: 자연수 체크
'''

'''이진 탐색'''
'''오름차순으로 정렬된 데이터에 한해 사용가능'''
T = int(input())
for _ in range(T):
    S, P = map(int, input().split())

    lo = 1
    hi = S // 2  # N ≤ M 이므로 N은 S//2 까지만
    found = False

    while lo <= hi:
        mid = (lo + hi) // 2
        val = mid * (S - mid)  # f(N) = N * (S-N)

        if val == P:
            found = True
            break
        elif val < P:
            lo = mid + 1  # f(N) 더 키워야 함 → N 증가
        else:
            hi = mid - 1  # f(N) 줄여야 함 → N 감소

    print("Yes" if found else "No")

'''근의 공식 활용'''
import math

T = int(input())
for _ in range(1, T + 1):
    s, p = map(int, input().split())
    n, m = 0, 0
    n = int((s + math.sqrt(abs(s*s -4*p)))/2)
    m = int((s - math.sqrt(abs(s*s -4*p)))/2)
    if n*m == p and n+m == s:
        print("Yes")
    else:
        print("No")