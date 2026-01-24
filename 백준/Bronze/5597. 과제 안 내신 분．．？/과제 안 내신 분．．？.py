a = [0]*30
x = 2
for i in range(28):
    x = int(input())
    a[x-1] = x

for i in range(30):
    if a[i] == 0:
        print(i+1)
    else: continue