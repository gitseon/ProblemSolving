import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] rot90 = new int[N][N];
            int[][] rot180 = new int[N][N];
            int[][] rot270 = new int[N][N];

            // 90도
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    rot90[i][j] = arr[N - 1 - j][i];
                }
            }

            // 180도
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    rot180[i][j] = arr[N - 1 - i][N - 1 - j];
                }
            }

            // 270도
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    rot270[i][j] = arr[j][N - 1 - i];
                }
            }

            System.out.print("#" + test_case + "\n");

            for (int i = 0; i < N; i++) {
                StringBuilder sb90 = new StringBuilder();
                StringBuilder sb180 = new StringBuilder();
                StringBuilder sb270 = new StringBuilder();

                for (int j = 0; j < N; j++) {
                    sb90.append(rot90[i][j]);
                    sb180.append(rot180[i][j]);
                    sb270.append(rot270[i][j]);
                }

                System.out.println(sb90 + " " + sb180 + " " + sb270);
            }
        }
    }
}