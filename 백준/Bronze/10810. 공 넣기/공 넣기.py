N, M = input().split()
N = int(N)
M = int(M)
baskets = [0] * N
i = j = k = 0
for i in range(M):
    i, j, k = map(int, input().split())
    for l in range(i, j+1):
        baskets[l-1] = k
print(*baskets)