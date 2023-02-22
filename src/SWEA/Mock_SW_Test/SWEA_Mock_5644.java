/**
 * 문제 : 무선 충전
 *
 * @author Hc-5514
 */

package SWEA.Mock_SW_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SWEA_Mock_5644 {

    static int M, A, totalCharge;
    static int[] moveA, moveB;
    static ArrayList<InfoBC>[][] map = new ArrayList[11][11];
    static InfoBC[] arrInfoBC;
    static InfoUser infoUser;

    static class InfoBC {
        int x; // x좌표
        int y; // y좌표
        int c; // 충전 범위
        int p; // 처리량

        public InfoBC(int x, int y, int c, int p) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
        }
    }

    static class InfoUser {
        // 사용자 A와 B의 좌표
        int xA;
        int yA;
        int xB;
        int yB;

        public InfoUser() {
            xA = 1;
            yA = 1;
            xB = 10;
            yB = 10;
        }
    }

    private static void setMap() {
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                map[i][j] = new ArrayList<>();
                // BC 거리 계산 후 충전 처리량 저장
                for (int k = 0; k < A; k++) {
                    int d = Math.abs(arrInfoBC[k].x - j) + Math.abs(arrInfoBC[k].y - i);
                    if (d <= arrInfoBC[k].c) {
                        map[i][j].add(arrInfoBC[k]);
                    }
                }
                // 충전 값 내림차순 정렬
                if (map[i][j].size() == 0) {
                    map[i][j].add(new InfoBC(0, 0, 0, 0));
                } else if (map[i][j].size() > 1)
                    Collections.sort(map[i][j], new Comparator<InfoBC>() {
                        @Override
                        public int compare(InfoBC o1, InfoBC o2) {
                            return o2.p - o1.p;
                        }
                    });
            }
        }
    }

    private static void getAddCharge() {
        for (int t = 0; t <= M; t++) {
            // A와 B의 충전 값 구하기
            int sizeA = map[infoUser.yA][infoUser.xA].size();
            int sizeB = map[infoUser.yB][infoUser.xB].size();
            InfoBC A = map[infoUser.yA][infoUser.xA].get(0);
            InfoBC B = map[infoUser.yB][infoUser.xB].get(0);
            // 이용 가능한 BC가 없거나 하나일 때
            if (sizeA == 1 && sizeB == 1) {
                // 같은 BC면 효율이 반토막
                if (A == B) {
                    totalCharge += A.p;
                } else {
                    totalCharge += (A.p + B.p);
                }
            }
            // 이용 가능한 BC가 여러 개일 때, 같은 BC면 두 번째 BC 이용
            else if (sizeA == 1) {
                if (A == B) {
                    B = map[infoUser.yB][infoUser.xB].get(1);
                }
                totalCharge += (A.p + B.p);
            } else if (sizeB == 1) {
                if (A == B) {
                    A = map[infoUser.yA][infoUser.xA].get(1);
                }
                totalCharge += (A.p + B.p);
            } else {
                if (A == B) {
                    InfoBC A2 = map[infoUser.yA][infoUser.xA].get(1);
                    InfoBC B2 = map[infoUser.yB][infoUser.xB].get(1);
                    if (A2.p >= B2.p) {
                        totalCharge += (A2.p + B.p);
                    } else {
                        totalCharge += (A.p + B2.p);
                    }
                } else {
                    totalCharge += (A.p + B.p);
                }
            }

            if (t != M) {
                moveUser('A', moveA[t]);
                moveUser('B', moveB[t]);
            }
        }
    }

    private static void moveUser(char user, int cmd) {
        if (cmd == 1) { // up
            if (user == 'A') {
                infoUser.yA -= 1;
            } else {
                infoUser.yB -= 1;
            }
        } else if (cmd == 2) { // right
            if (user == 'A') {
                infoUser.xA += 1;
            } else {
                infoUser.xB += 1;
            }
        } else if (cmd == 3) { // down
            if (user == 'A') {
                infoUser.yA += 1;
            } else {
                infoUser.yB += 1;
            }
        } else if (cmd == 4) { // left
            if (user == 'A') {
                infoUser.xA -= 1;
            } else {
                infoUser.xB -= 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            // M: 총 이동시간, A: BC의 개수
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            // moveA, moveB: A와 B의 이동 정보
            moveA = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                moveA[i] = Integer.parseInt(st.nextToken());
            }
            moveB = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                moveB[i] = Integer.parseInt(st.nextToken());
            }
            // InfoBC: BC 정보
            arrInfoBC = new InfoBC[A];
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                arrInfoBC[i] = new InfoBC(x, y, c, p);
            }
            // 지도 구성하기
            setMap();
            // 모든 사용자의 충전량 합 구하기
            totalCharge = 0;
            infoUser = new InfoUser();
            getAddCharge();

            sb.append("#").append(tc).append(" ").append(totalCharge).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
