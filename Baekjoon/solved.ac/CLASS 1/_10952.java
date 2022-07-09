/**
 * 문제 : A+B - 5
 * @author Hc-5514
 */

package BAEKJOON.Solved_CLASS.CLASS_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10952 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = -1;
        int b = -1;
        while(true){
            StringTokenizer token = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(token.nextToken());
            b = Integer.parseInt(token.nextToken());
            if(a==0 && b==0)
                break;
            System.out.println(a + b);
        }
    }
}
