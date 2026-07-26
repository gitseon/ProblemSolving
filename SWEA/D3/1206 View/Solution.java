
/*
SWEA D3 1206. [S/W 문제해결 기본] 1 일차 - View
 - 시간 : 93ms
 - 메모리 : 27,648 KB
 - 시간복잡도 : O(N)
 - 푸는 데 걸린 시간 : 53분
 - 전략
   - 조망권 확보 조건: 거리 2 이내의 건물의 높이보다 높게 위치한 세대
   - 따라서 세대 수는 건물의 높이 차이가 된다.
   - 거리 -2, -1, 1, 2에 위치한 건물들과 높이 차를 계산한다.
     - 높이 차의 최솟값이 조망권이 확보된 세대 수이다.
     - 세대 수를 총합 변수에 더한다.
   - 다음 빌딩도 위의 과정을 반복한다.
   (개선) 
   - 건물의 높이 최댓값(가장 높은 건물의 높이만 빼면 높이 차도 최소가 됨)
   - 거리 2 내에서 가장 높은 건물을 찾는다.
   - 현재 위치의 건물과 가장 높은 건물의 차이가 양수면 그 차이가 조망권이 확보된 세대 수이다.
   - 세대 수를 총합 변수에 더한다.
   - 다음 빌딩도 위 과정을 반복한다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N; // 건물의 개수

        int[] heights; // 건물의 높이들
        int answer; // 조망권 확보된 세대 수
        int degree; // 높이차
        // int maxHeight; // (개선) 거리 2 이내 건물 높이 최댓값

        for (int tc = 1; tc <= 10; tc++) {
            answer = 0;
            degree = 0;
            sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            heights = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 2; i < N - 2; i++) {
                if (heights[i - 2] >= heights[i]) {
                    continue;
                } else {
                    degree = heights[i] - heights[i - 2];
                    if (heights[i - 1] >= heights[i]) {
                        continue;
                    } else {
                        degree = Math.min(degree, heights[i] - heights[i - 1]);
                        if (heights[i + 2] >= heights[i]) {
                            continue;
                        } else {
                            degree = Math.min(degree, heights[i] - heights[i + 2]);
                            if (heights[i + 1] >= heights[i]) {
                                continue;
                            } else {
                                degree = Math.min(degree, heights[i] - heights[i + 1]);
                                answer += degree;
                            }
                        }
                    }
                }
                // maxHeight = Math.max(Math.max(heights[i - 2], heights[i - 1]),
                // Math.max(heights[i + 1], heights[i + 2]));
                // if (heights[i] > maxHeight) {
                // answer += heights[i] - maxHeight;
                // }
            }
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
            System.out.print(sb);
        }
    }
}
