/**
 * 문제 : ⚾
 *
 * @author Hc-5514
 */

package Baekjoon.Unclassified;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 13시 45분
public class BOJ_17281 {

    static int N, score, maxScore = 0, idx, outCnt;
    static ArrayList<Round> roundList = new ArrayList<>();
    static int[] orderArr = new int[9];
    static int[] groundInfo = new int[3];
    static boolean[] visit = new boolean[9];

    static class Round {
        int[] result;

        public Round(int[] result) {
            this.result = result;
        }
    }

    private static void makeOrder(int cnt) {
        if (cnt == 9) {
            // 게임 진행
            score = 0;
            outCnt = 0;
            idx = 0;
            int cntRound = 0;
            // 목표 이닝까지 게임 진행
            while (cntRound < N) {
                // 새로운 이닝 진행 시, 그라운드 초기화 + out 개수 초기화
                for (int i = 0; i < 3; i++) {
                    groundInfo[i] = 0;
                }
                outCnt = 0;
                // 아웃 3번 시, 이닝 종료
                while (outCnt < 3) {
                    // 0: 아웃, 1: 안타, 2: 2루타, 3: 3루타, 4: 홈런
                    int n = roundList.get(cntRound).result[orderArr[idx++ % 9]];
                    switch (n) {
                        case 0: // 아웃
                            outCnt++;
                            break;
                        case 1: // 안타
                            score += groundInfo[2];
                            groundInfo[2] = groundInfo[1];
                            groundInfo[1] = groundInfo[0];
                            groundInfo[0] = 1;
                            break;
                        case 2: // 2루타
                            for (int i = 1; i < 3; i++) {
                                score += groundInfo[i];
                            }
                            groundInfo[2] = groundInfo[0];
                            groundInfo[1] = 1;
                            groundInfo[0] = 0;
                            break;
                        case 3: // 3루타
                            for (int i = 0; i < 3; i++) {
                                score += groundInfo[i];
                            }
                            groundInfo[2] = 1;
                            groundInfo[1] = 0;
                            groundInfo[0] = 0;
                            break;
                        case 4: // 홈런
                            for (int i = 0; i < 3; i++) {
                                score += groundInfo[i];
                                groundInfo[i] = 0;
                            }
                            score++;
                            break;
                    }
                }
                cntRound++;
            }

            // 최대 득점 수 갱신
            if (score > maxScore) maxScore = score;
            return;
        }

        if (cnt == 3) {
            // 0번 선수는 3번 타자 고정
            visit[0] = true;
            orderArr[cnt] = 0;
            makeOrder(cnt + 1);
            return;
        }

        for (int i = 1; i < 9; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            orderArr[cnt] = i;
            makeOrder(cnt + 1);
            visit[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 이닝 별 각 선수의 결과 저장: 0~8번 선수
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            roundList.add(new Round(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())}));
        }

        // 최대 점수 구하기 - 순열
        makeOrder(0);

        System.out.println(maxScore);
        br.close();
    }
}
