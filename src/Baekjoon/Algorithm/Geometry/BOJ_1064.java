/**
 * 문제 : 평행사변형
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Geometry;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1064 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 점 3개 좌표 입력 받기
        int[][] coords = new int[3][2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                coords[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 기울기가 같다면
        if ((coords[2][1] - coords[1][1]) * (coords[1][0] - coords[0][0]) == (coords[1][1] - coords[0][1]) * (coords[2][0] - coords[1][0])) {
            bw.write(-1.0 + "\n");
        } else {
            double[] lenArr = new double[3];
            for (int i = 0; i < 3; i++) {
                lenArr[i] = Math.sqrt(Math.pow(Math.abs(coords[i % 3][0] - coords[(i + 1) % 3][0]), 2) + Math.pow(Math.abs(coords[i % 3][1] - coords[(i + 1) % 3][1]), 2));
            }

            Arrays.sort(lenArr);

            // 가장 긴 변 <= 나머지 두 변의 길이 합
            if (lenArr[2] > lenArr[0] + lenArr[1]) {
                bw.write(-1.0 + "\n");
            } else {
                bw.write((lenArr[2] - lenArr[0]) * 2 + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}