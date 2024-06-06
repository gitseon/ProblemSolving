#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main()
{
	int K = 0;
	scanf("%d", &K); //K입력
	int temp;
	while ((temp = getchar())!=EOF && temp != '\n') {}
	int sum = 0; //출력할 합계
	int j = 0;
	int n = 0;
	int *list = malloc(sizeof(int) * K + 1); //숫자를 넣을 배열
	for (int i = 0; i < K; i++) { //입력을 K번만큼 받음
		scanf("%d", &n);
		while ((temp = getchar()) != EOF && temp != '\n') {}
		if (n != 0) { //0이 아니면 스택에 쌓기
			list[j] = n;
			j++;
		}
		else { //입력받은게 0이면 최근 수에 다음 수를 덮어쓰게함
			j--;
		}
	}
	for (int i = 0; i < j; i++) {
		sum += list[i];
	}
	printf("%d", sum);
	free(list);
	return 0;
}
