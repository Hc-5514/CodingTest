/**
 * 문제 : 트리 순회
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    char data;
    Node leftNode;
    Node rightNode;

    public Node(char data, Node leftNode, Node rightNode) {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
}

public class BOJ_1991 {

    static Node head = new Node('A', null, null);
    static StringBuilder sb = new StringBuilder();

    private static void createNode(Node tmp, char root, char left, char right) {
        if (tmp.data == root) {
            tmp.leftNode = (left == '.' ? null : new Node(left, null, null));
            tmp.rightNode = (right == '.' ? null : new Node(right, null, null));
        } else {
            if (tmp.leftNode != null) createNode(tmp.leftNode, root, left, right);
            if (tmp.rightNode != null) createNode(tmp.rightNode, root, left, right);
        }
    }

    // 전위 순회: VLR
    private static void preOrder(Node node) {
        if (node != null) {
            sb.append(node.data);
            if (node.leftNode != null) preOrder(node.leftNode);
            if (node.rightNode != null) preOrder(node.rightNode);
        }
    }

    // 중위 순회: LVR
    private static void inOrder(Node node) {
        if (node != null) {
            if (node.leftNode != null) inOrder(node.leftNode);
            sb.append(node.data);
            if (node.rightNode != null) inOrder(node.rightNode);
        }
    }

    // 후위 순회: LRV
    private static void postOrder(Node node) {
        if (node.leftNode != null) postOrder(node.leftNode);
        if (node.rightNode != null) postOrder(node.rightNode);
        sb.append(node.data);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            createNode(head, root, left, right);
        }

        // 순회
        preOrder(head);
        sb.append("\n");
        inOrder(head);
        sb.append("\n");
        postOrder(head);
        sb.append("\n");

        System.out.println(sb);
        br.close();
    }

}
