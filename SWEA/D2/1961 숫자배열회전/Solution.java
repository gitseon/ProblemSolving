import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        // StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());

            br = new BufferedReader(new InputStreamReader(System.in));
            String[][] arr = new String[N][N];
            String[][] rArr = new String[N][N];
            for (int i = 0; i < N;) {
                for (int j = 0; j < N; j++) {
                    arr[i] = br.readLine().split(" ");
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    rArr[j][Math.abs(i-(N-1))] = arr[i][j];
                }
            }

            System.out.print("#" + test_case + "\n");
            
        }
    }
}