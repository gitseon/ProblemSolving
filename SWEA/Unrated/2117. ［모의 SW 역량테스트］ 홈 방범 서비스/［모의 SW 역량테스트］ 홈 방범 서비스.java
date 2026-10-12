import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][N];

            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;

            // 1. K는 최대 2N-1까지만 확인
            for (int k = 1; k <= 2 * N - 1; k++) {

                // 서비스 영역 크기 K에 따른 운영 비용
                int cost = k * k + (k - 1) * (k - 1);

                // 2. 모든 좌표를 서비스 중심으로 가정
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < N; c++) {

                        int houseCount = 0;

                        // 3. 현재 서비스 영역에 포함되는 집 계산
                        for (int nr = 0; nr < N; nr++) {
                            for (int nc = 0; nc < N; nc++) {

                                // 집이 없는 칸은 검사할 필요 없음
                                if (map[nr][nc] == 0) continue;

                                // 마름모 내부인지 맨해튼 거리로 판단
                                int dist = Math.abs(r - nr)
                                         + Math.abs(c - nc);

                                if (dist < k) {
                                    houseCount++;
                                }
                            }
                        }

                        // 4. 손해를 보지 않는 경우만 정답 갱신
                        if (houseCount * M >= cost) {
                            answer = Math.max(answer, houseCount);
                        }
                    }
                }
            }

            sb.append('#').append(tc)
              .append(' ').append(answer).append('\n');
        }

        System.out.print(sb);
    }
}
