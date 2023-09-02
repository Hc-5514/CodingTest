/**
 * 문제 : 병원 거리 최소화하기
 *
 * @author Hc-5514
 */

package CodeTree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 병원_거리_최소화하기 {

    static int n, m;
    static int minDistance = Integer.MAX_VALUE;
    static int[] selectedNum;
    static int[][] board;
    static List<int[]> persons, hospitals;

    public static void combination(int depth, int start) {
        // m 개 뽑기가 끝나면, 거리 계산
        if (depth == m) {
            getMinDistance();
            return;
        }

        for (int i = start; i < hospitals.size(); i++) {
            selectedNum[depth] = i;
            combination(depth + 1, i + 1);
        }
    }

    public static void getMinDistance() {
        // 모든 사람 -> 뽑힌 병원까지의 거리 최소값의 합: 100 x m
        int total = 0;
        for (int i = 0; i < persons.size(); i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                int distance = 0;
                distance += Math.abs(persons.get(i)[0] - hospitals.get(selectedNum[j])[0]);
                distance += Math.abs(persons.get(i)[1] - hospitals.get(selectedNum[j])[1]);
                min = Math.min(min, distance);
                if (min == 1) {
                    break; // 거리가 1이라면, 최소값이므로 가지치기
                }
            }
            total += min;
            if (total >= minDistance) return; // 가지치기: 역대 최단 거리 조합보다 같거나 크다면
        }
        minDistance = total;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 도시 크기 <= 50
        m = Integer.parseInt(st.nextToken()); // 병원의 수 <= 13

        selectedNum = new int[m];
        board = new int[n][n]; // N x N 도시
        persons = new ArrayList<>();
        hospitals = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) persons.add(new int[]{i, j}); // 사람 좌표 추가
                if (board[i][j] == 2) hospitals.add(new int[]{i, j}); // 병원 좌표 추가
            }
        }

        combination(0, 0);

        bw.write(minDistance + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
