#include <stdio.h>

int main()
{
	int N;
	scanf("%d", &N); //N 입력
	int x[51]; //몸무게 배열
	int y[51]; //키 배열
	int rank = 1; //덩치 등수
	for (int i = 0; i < N; i++) {
		scanf("%d %d", &x[i], &y[i]);
	}
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (x[j] > x[i] && y[j] > y[i]) { //덩치가 작으면
				rank++;
			}
		}
		printf("%d ", rank);
		rank = 1;
	}
	return 0;
}