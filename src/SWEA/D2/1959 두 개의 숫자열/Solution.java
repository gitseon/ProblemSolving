import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            int[] B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            int max = Integer.MIN_VALUE;

            if (N <= M) {
                for (int start = 0; start <= M - N; start++) {
                    int sum = 0;
                    for (int i = 0; i < N; i++) {
                        sum += A[i] * B[start + i];
                    }
                    max = Math.max(max, sum);
                }

            } else {
                for (int start = 0; start <= N - M; start++) {
                    int sum = 0;
                    for (int i = 0; i < M; i++) {
                        sum += A[start + i] * B[i];
                    }
                    max = Math.max(max, sum);
                }
            }

            System.out.println("#" + test_case + " " + max);
        }
    }
}