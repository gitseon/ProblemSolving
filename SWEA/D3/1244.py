T = int(input()) # 테스트 케이스 수 입력
for c in range(1, T+1):  # 테스트 케이스 수만큼 반복
    line = input().split()  # 숫자와 교환 횟수를 입력받고 띄어쓰기 기준으로 쪼개어 문자열 리스트로 반환
    num = tuple(line[0])  # 숫자를 저장
    k = int(line[1])  # 교환 횟수 저장
    n = len(num)  # 숫자의 길이
    memo = {}  # {(digits, k) : 최댓값} / 딕셔너리 형태로 (숫자, 교환 횟수) : 최댓값 으로 저장

    def solve(digits, k):
        if (digits, k) in memo:  # 이미 저장해놓았으면 해당하는 최댓값을 반환
            return memo[(digits, k)]
        if k == 0:  # 교환 횟수가 0이면 그대로 반환
            return int(''.join(digits))

        best = 0  # 구하려고 하는 최댓값 변수
        d = list(digits)  # 숫자를 리스트형식으로 변환
        for i in range(n):
            for j in range(i+1, n):
                d[i], d[j] = d[j], d[i]
                best = max(best, solve(tuple(d), k-1))
                d[i], d[j] = d[j], d[i]

        memo[(digits, k)] = best
        return best

    print(f"#{c} {solve(num, k)}")