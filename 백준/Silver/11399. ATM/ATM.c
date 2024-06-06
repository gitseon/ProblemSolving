#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main()
{
	int N;
	int P[1001];
	int save;
	int sum = 0;
	scanf("%d", &N);
	for (int i = 0; i < N; i++)
	{
		scanf("%d", &P[i]);
	}
	//입력 부분-----------------
	for (int j = N - 1; j > 0; j--)
	{
		for (int i = 0; i < j; i++)
		{
			if (P[i] > P[i + 1])
			{
				save = P[i];
				P[i] = P[i + 1];
				P[i + 1] = save;
			}
		}
	}
	
	for (int i = 0; i < N; i++)
	{
		sum += P[i] * (N - i);
	}
	printf("%d\n", sum);
	return 0;
}