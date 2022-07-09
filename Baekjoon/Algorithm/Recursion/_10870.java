/**
 * 문제 : 피보나치 수 5
 * @author Hc-5514
 */

package BAEKJOON.Algorithm.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10870 {

    // Case 1: if문 (메모리: 14108 KB)
//    static int Fibonacci(int n) {
//        if (n==0)
//            return 0;
//        else if (n==1)
//            return 1;
//        else {
//            return Fibonacci(n-2) + Fibonacci(n-1);
//        }
//    }

    // Case 2: 삼항 연산자 (메모리: 14224 KB)
    static int Fibonacci(int n) {
        return n<2 ? n : Fibonacci(n-2) + Fibonacci(n-1);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Fibonacci(Integer.parseInt(br.readLine())));
    }
}
