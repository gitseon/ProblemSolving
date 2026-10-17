import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int N, M;
        int flies[][];
        int sumPlus = 0;
        int sumX = 0;
        int maxNum = 0;
        int answer = 0;

        for (int test_case = 1; test_case <= T; test_case++) {
            maxNum = 0;
            answer = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            flies = new int[N][N];

            // 배열 입력 및 저장
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    flies[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 1; k <= M - 1; k++) {
                        if (j - k >= 0) {
                            sumPlus += flies[i][j - k];
                            if (i - k >= 0) {
                                sumX += flies[i - k][j - k];
                            }
                            if (i + k <= N - 1) {
                                sumX += flies[i + k][j - k];
                            }
                        }
                        if (j + k <= N - 1) {
                            sumPlus += flies[i][j + k];
                            if (i - k >= 0) {
                                sumX += flies[i - k][j + k];
                            }
                            if (i + k <= N - 1) {
                                sumX += flies[i + k][j + k];
                            }
                        }
                        if (i - k >= 0) {
                            sumPlus += flies[i - k][j];
                        }
                        if (i + k <= N - 1) {
                            sumPlus += flies[i + k][j];
                        }

                    } // k loop end
                    sumPlus += flies[i][j];
                    sumX += flies[i][j];
                    maxNum = Math.max(sumPlus, sumX);
                    answer = Math.max(maxNum, answer);
                    sumPlus = 0;
                    sumX = 0;
                } // j loop end
            } // i loop end

            System.out.print("#" + test_case + " " + answer + "\n");
        }
    }
}