/**
 * 문제 : 스택 수열
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int push = 0;

        for (int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());

            if(num < push){
                if(stack.peek() == num){
                    stack.pop();
                    sb.append('-').append('\n');
                }
                else {
                    sb.setLength(0);
                    sb.append("NO");
                    break;
                }
            }
            else {
                for (int j=push+1; j<=num; j++){
                    stack.push(j);
                    sb.append('+').append('\n');
                }
                stack.pop();
                sb.append('-').append('\n');
                push = num;
            }
        }

        System.out.println(sb);

        br.close();
    }
}
