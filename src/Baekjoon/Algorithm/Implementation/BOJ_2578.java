/**
 * 문제: 빙고
 * 난이도: 실버 4
 * 메모리: 11692KB, 시간: 64ms
 * 풀이: 구현
 */

package Baekjoon.Algorithm.Implementation;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_2578 {

    private static int[][] boards;

    private static boolean isBingo() {
        int bingoCnt = 0;

        bingoCnt += getRowBingoCnt();
        bingoCnt += getColBingoCnt();
        bingoCnt += getDiagBingoCnt();

        return (bingoCnt >= 3);
    }

    private static int getRowBingoCnt() {
        int bingoCnt = 0;
        for (int i = 0; i < 5; i++) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                if (boards[i][j] != 0) {
                    break;
                }
                cnt++;
            }
            if (cnt == 5) {
                bingoCnt++;
            }
        }
        return bingoCnt;
    }

    private static int getColBingoCnt() {
        int bingoCnt = 0;
        for (int i = 0; i < 5; i++) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                if (boards[j][i] != 0) {
                    break;
                }
                cnt++;
            }
            if (cnt == 5) {
                bingoCnt++;
            }
        }
        return bingoCnt;
    }

    private static int getDiagBingoCnt() {
        int bingoCnt = 0;
        int cnt = 0;

        for (int i = 0; i < 5; i++) {
            if (boards[i][i] != 0) {
                break;
            }
            cnt++;
        }

        if (cnt == 5) {
            bingoCnt++;
        }

        cnt = 0;
        for (int i = 4; i >= 0; i--) {
            if (boards[4 - i][i] != 0) {
                break;
            }
            cnt++;
        }

        if (cnt == 5) {
            bingoCnt++;
        }

        return bingoCnt;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        boards = new int[5][5];
        Map<Integer, int[]> coords = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                coords.put(num, new int[]{i, j});
                boards[i][j] = num;
            }
        }

        int cnt = 0;
        f1:
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                cnt++;
                int[] coord = coords.get(Integer.parseInt(st.nextToken()));
                boards[coord[0]][coord[1]] = 0;
                if (isBingo()) {
                    break f1;
                }
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
