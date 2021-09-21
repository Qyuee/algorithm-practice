package algorithm.youtube_dongbinna.DFS_BFS;

import java.util.Stack;

/**
 * Stack: 선입후출
 */
public class Stack001 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("hello");
        stack.push("world");
        stack.push("dslee");

        System.out.println(stack.peek()); // 최상단 원소를 출력
        stack.pop();

        System.out.println(stack.peek());
        stack.pop();

        System.out.println(stack.peek());

        for (int i = 0; i<stack.size(); i++) {
            System.out.println(stack.get(i));
        }
    }
}
