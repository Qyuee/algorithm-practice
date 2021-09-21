package algorithm.youtube_dongbinna.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Queue: 선입선출
 */
public class Queue001 {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("test");
        queue.offer("hello");
        queue.offer("world");

        System.out.println(queue.peek());
        queue.poll();

        System.out.println(queue.peek());
        queue.poll();

        System.out.println(queue.peek());
        queue.poll();
    }
}
