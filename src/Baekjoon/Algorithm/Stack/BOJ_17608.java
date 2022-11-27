/**
 * 문제 : 막대기
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_17608 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            stack.push(Integer.parseInt(br.readLine()));
        }

        int temp = 0;
        int count = 0;

        for(int i=0; i<n; i++){
            int height = stack.pop();
            if(temp < height){
                temp = height;
                count++;
            }
        }

        System.out.println(count);
    }
}