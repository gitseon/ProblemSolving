package SWEA.D5.최적경로;

import java.util.*;
import java.io.*;

public class 최적경로 {

    static int[] company;
    static int[] house;
    static int[][] customers;
    static boolean[] visited;

    static int N;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());

            StringTokenizer st = new StringTokenizer(br.readLine());
            company = new int[2];
            house = new int[2];
            company[0] = Integer.parseInt(st.nextToken());
            company[1] = Integer.parseInt(st.nextToken());
            house[0] = Integer.parseInt(st.nextToken());
            house[1] = Integer.parseInt(st.nextToken());

            customers = new int[N][2];
            for (int i = 0; i < N; i++) {
                customers[i][0] = Integer.parseInt(st.nextToken());
                customers[i][1] = Integer.parseInt(st.nextToken());
            }

            visited = new boolean[N + 1];
            answer = 10000000;
            // 회사에서 출발
            dfs(0, 0, company[0], company[1]);

            sb.append('#').append(tc).append(' ').append(answer).append('\n');
        } // tc end
        System.out.print(sb);
    } // main end

    static void dfs(int dist, int depth, int x, int y) {
        // 고객 전부다 탐방했다면 마지막에는 집까지의 맨해튼 거리를 누적
        if (depth == N) {
            dist += Math.abs(x - house[0]) + Math.abs(y - house[1]);
            if (dist < answer)
                answer = dist;
        }

        // 누적 거리가 이미 최솟값을 넘어서면 가지치기
        if (dist > answer) {
            return;
        }

        // 현재 좌표 - 다음 방문할 좌표 맨해튼 거리 구해서 dist 누적 합
        for (int i = 0; i < N; i++) {
            // 방문한 고객이면 방문 x
            if (visited[i])
                continue;

            visited[i] = true;
            dfs(dist + Math.abs(x - customers[i][0]) + Math.abs(y - customers[i][1]),
                    depth + 1, customers[i][0], customers[i][1]);
            visited[i] = false;
        }

    } // dfs end

} // class end