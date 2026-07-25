import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
SWEA D2_1859. 백만 장자 프로젝트
- 시간: 450ms (JAVA 10개 테스트케이스 기준 시간 제한: 30초)
- 시간복잡도: O(N)
- 푸는 데 걸린 시간: 120분(정답 확인)
- 전략
	- 이익의 최댓값은 어떻게 결정되는가? -> 매매가의 최댓값일때 팔면 이익도 최대가 됨
	- 매매가의 최댓값이 있는 지점을 찾고 이익을 계산
	- 이익을 정방향으로 순회하여 계산하는 것보다 역방향으로 순회하면 계산을 줄일 수 있음(미리 알고있다는 가정이므로)
	  - 순회하는 동안 max보다 더 큰 매매가가 나오면 max 갱신한다.
	  - max보다 작으면 사는 시점이므로 이익을 누적으로 더해나간다.(이익 += 판매가 - 매수가)
	- 누적된 이익을 출력하고 다음 테스트케이스가 있으면 위를 반복한다.(다음 테스트케이스 때 같은 변수를 쓰면 초기화 필수)

- 총평:
  처음에 정방향으로 계산하려니까 생각하기 어려웠는데 미리 알고있다는 부분에서 역방향으로 계산하는 아이디어는 신박했다.
  필요에 따라 역방향 순회도 고려해보는 방법을 가져가고 최대/최소 확신을 가지는 데에 어려움이 있었다.(왜 최대/최소가 되는지 이해가 어려웠음)
  최대/최소 구하는 문제에 익숙해질 필요가 느껴진다.
  또한 N의 크기가 10^6으로 굉장히 큰 편인데 데이터의 크기에 따라 시간복잡도를 계산하고 그에 따라 맞는 알고리즘을 선택하는 것도 연습이 필요해보인다.
  잘한 점은 크기보고 O(N^2)은 안되겠구나 생각했음.
  아쉬운 점은 매매가 10,000에 N 10^6이면 저장할 변수의 타입도 고려했어야 됐다는 점 다음부터는 엣지 케이스도 분석하는 것이 필요
*/

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		StringBuilder sb;

		int N; // 매매가 나열 수
		long[] prices; // 매매가 저장 배열
		long profit; // 이익
		long max; // 최대 판매가

		for (int tc = 1; tc <= T; tc++) {
			sb = new StringBuilder();

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			prices = new long[N];
			profit = 0;
			max = 0;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				prices[i] = Long.parseLong(st.nextToken());
			}

			// 개선: i = N-1은 무조건 바뀌므로 미리 저장해서 다음 N-2부터 도는게 계산을 1회 줄일 수 있다.
			max = prices[N - 1];
			for (int i = N - 2; i >= 0; i--) {
				if (prices[i] > max) { // 팔아야하는 시점이면
					max = prices[i]; // 갱신
				} else { // 아니면 사야되는 시점이므로
					profit += max - prices[i]; // 그 시점에 샀을 때 판매 시점에서 팔았을 때 얻는 이익을 계산(누적)
				}
			}

			sb.append("#").append(tc).append(" ").append(profit).append("\n");
			System.out.print(sb);
		}
	}

}
