N = int(input())
for i in range(N):
    for j in range(0, N-1+i + 1):
        if (N-1 - i < j or N-1 - i == j) and (j < N-1 + i or j == N-1 + i):
            print("*", end="")
        else: print(" ", end="")
        if j == N-1+i: print("")
    
for i in range(N-2, -1, -1):
    for j in range(0, N-1+i + 1):
        if (N-1 - i < j or N-1 - i == j) and (j < N-1 + i or j == N-1 + i):
            print("*", end="")
        else: print(" ", end="")
        if j == N-1+i: print("")