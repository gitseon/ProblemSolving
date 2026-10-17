package SWEA.D4;

import java.io.*;
import java.util.*;

public class 하나로프림 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());

            // 좌표의 최댓값 100만 -> L^2이 int 범위를 초과하므로 long 선택
            long[] x = new long[N];
            long[] y = new long[N];

            // 인접 리스트 구현
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                x[i] = Long.parseLong(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                y[i] = Long.parseLong(st.nextToken());
            }

            double E = Double.parseDouble(br.readLine().trim());

            boolean[] visited = new boolean[N];
            // MST에 연결하는 최소 거리 제곱
            long[] minDist = new long[N];

            Arrays.fill(minDist, Long.MAX_VALUE);

            // 시작 섬은 연결 비용이 0
            minDist[0] = 0L;

            // 모든 터널의 거리 제곱 합
            long totalDist = 0L;

            // N개의 섬을 하나씩 MST에 추가
            for (int i = 0; i < N; i++) {

                int current = -1;
                long min = Long.MAX_VALUE;

                // 미방문 섬 중 연결 비용이 최소인 섬 선택
                for (int j = 0; j < N; j++) {
                    if (visited[j])
                        continue;
                    if (minDist[j] < min) {
                        min = minDist[j];
                        current = j;
                    }
                }

                // 선택한 섬을 MST에 포함
                visited[current] = true;
                totalDist += min;

                // 새로 추가한 섬을 기준으로 최소 거리 갱신
                for (int next = 0; next < N; next++) {
                    if (visited[next])
                        continue;

                    long dx = x[current] - x[next];
                    long dy = y[current] - y[next];

                    long dist = dx * dx + dy * dy;

                    // 기존 연결 비용보다 짧으면 갱신
                    if (dist < minDist[next]) {
                        minDist[next] = dist;
                    }
                }
            }

            // 거리 제곱 합에 환경 부담 세율 적용 후 반올림
            long answer = Math.round(totalDist * E);

            sb.append('#').append(tc).append(' ').append(answer).append('\n');
        } // tc end

        System.out.print(sb);
    } // main end
} // class end
