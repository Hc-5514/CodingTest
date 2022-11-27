/**
 * 문제 : 피보나치 수 5
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10870 {
    static int Fibonacci(int n) {
        return n<2 ? n : Fibonacci(n-2) + Fibonacci(n-1);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Fibonacci(Integer.parseInt(br.readLine())));
    }
}
