/**
 * 문제 : 상호의 배틀필드
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_1873 {

    static StringBuilder sb = new StringBuilder();
    static int H, W;
    static char[][] field;

    static class Coordinate {
        int x;
        int y;
    }

    static Coordinate coordinate = new Coordinate();

    private static void runCommand(char command) {
        int x = coordinate.x;
        int y = coordinate.y;

        if (command == 'U') {
            field[x][y] = '^';
            if (x - 1 >= 0 && field[x - 1][y] == '.') {
                field[x][y] = '.';
                coordinate.x = x - 1;
                field[x - 1][y] = '^';
            }
        } else if (command == 'D') {
            field[x][y] = 'v';
            if (x + 1 < H && field[x + 1][y] == '.') {
                field[x][y] = '.';
                coordinate.x = x + 1;
                field[x + 1][y] = 'v';
            }
        } else if (command == 'L') {
            field[x][y] = '<';
            if (y - 1 >= 0 && field[x][y - 1] == '.') {
                field[x][y] = '.';
                coordinate.y = y - 1;
                field[x][y - 1] = '<';
            }
        } else if (command == 'R') {
            field[x][y] = '>';
            if (y + 1 < W && field[x][y + 1] == '.') {
                field[x][y] = '.';
                coordinate.y = y + 1;
                field[x][y + 1] = '>';
            }
        } else { // (command == 'S')
            char direction = field[x][y];
            // 해당 방향으로 포탄 발사
            boolean isCollision = false;
            if (direction == '^') {
                while (!isCollision) {
                    if (x == 0)
                        break;
                    // 벽돌 벽은 파괴
                    if (field[x - 1][y] == '*') {
                        field[x - 1][y] = '.';
                        isCollision = true;
                    }
                    // 강철 벽은 이상x
                    else if (field[x - 1][y] == '#') {
                        isCollision = true;
                    } else {
                        x--;
                    }
                }
            } else if (direction == 'v') {
                while (!isCollision) {
                    if (x == H - 1)
                        break;
                    // 벽돌 벽은 파괴
                    if (field[x + 1][y] == '*') {
                        field[x + 1][y] = '.';
                        isCollision = true;
                    }
                    // 강철 벽은 이상x
                    else if (field[x + 1][y] == '#') {
                        isCollision = true;
                    } else {
                        x++;
                    }
                }
            } else if (direction == '<') {
                while (!isCollision) {
                    if (y == 0)
                        break;
                    // 벽돌 벽은 파괴
                    if (field[x][y - 1] == '*') {
                        field[x][y - 1] = '.';
                        isCollision = true;
                    }
                    // 강철 벽은 이상x
                    else if (field[x][y - 1] == '#') {
                        isCollision = true;
                    } else {
                        y--;
                    }
                }
            } else {
                while (!isCollision) {
                    if (y == W - 1)
                        break;
                    // 벽돌 벽은 파괴
                    if (field[x][y + 1] == '*') {
                        field[x][y + 1] = '.';
                        isCollision = true;
                    }
                    // 강철 벽은 이상x
                    else if (field[x][y + 1] == '#') {
                        isCollision = true;
                    } else {
                        y++;
                    }
                }
            }
        }
    }

    private static void printField() {
        for (char[] chAry : field) {
            for (char ch : chAry) {
                sb.append(ch);
            }
            sb.append("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            // H x W 영역에 field 정보 입력
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            field = new char[H][W];
            for (int i = 0; i < H; i++) {
                String str = br.readLine();
                for (int j = 0; j < W; j++) {
                    field[i][j] = str.charAt(j);
                    // 전차 좌표 저장
                    if (field[i][j] == '^' || field[i][j] == 'v' || field[i][j] == '<' || field[i][j] == '>') {
                        coordinate.x = i;
                        coordinate.y = j;
                    }
                }
            }
            // 사용자 입력 커맨드 N
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            for (int i = 0; i < N; i++) {
                runCommand(str.charAt(i));
            }
            // 맵 결과 출력
            sb.append("#").append(tc).append(" ");
            printField();
        }

        System.out.println(sb);
        br.close();
    }
}
