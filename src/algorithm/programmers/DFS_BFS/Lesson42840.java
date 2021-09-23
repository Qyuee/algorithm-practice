package algorithm.programmers.DFS_BFS;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42840?language=java
 * 모의고사
 */
public class Lesson42840 {
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        int[] a = new int[5];
        a[1] = 10;
        ArrayList<Node> test = new ArrayList<>();

        test.add(new Node(1, 2));
        test.add(new Node(2, 2));
        test.add(new Node(3, 4));

        System.out.println(a[0]);
        System.out.println(a[1]);
        System.out.println(a[2]);

        test.sort((o1, o2) -> {
            if (o1.getCount() > o2.getCount()) {
                return -1;
            } else {
                return 1;
            }
        });

        int[] ints = test.stream().sorted(Comparator.comparingInt(Node::getCount).reversed())
                .filter(node -> node.getCount() > 0)
                .map(Node::getIndex)
                .mapToInt(value -> value)
                .toArray();

        System.out.println(ints);

        ArrayList<Integer> result = new ArrayList<>();
        test.forEach(node -> {
            if (node.getCount() > 0) {
                result.add(node.getIndex());
            }
        });


        System.out.println(result);
    }

    static class Node {
        int index;
        int count;

        public Node(int index, int count) {
            this.index = index;
            this.count = count;
        }

        public int getIndex() {
            return index;
        }

        public int getCount() {
            return count;
        }
    }
}

/*

정확성 35.7프로이다...
뭐가 잘못된걸까..

import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] a = new int[]{1,2,3,4,5};           // 5
        int[] b = new int[]{2,1,2,3,2,4,2,5};     // 8
        int[] c = new int[]{3,3,1,1,2,2,4,4,5,5}; // 10

        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(calc(a, 1, answers));
        nodes.add(calc(b, 2, answers));
        nodes.add(calc(c, 3, answers));

        return nodes.stream().sorted(Comparator.comparingInt(Node::getCount).reversed())
                .filter(node -> node.getCount() > 0)
                .map(Node::getIndex)
                .mapToInt(value -> value)
                .toArray();
    }

    public Node calc(int[] personPattern, int num, int[] answers) {
        int result = 0;
        int index = 0;

        for (int i = 0; i < answers.length; i++) {
            if (personPattern[index] == answers[i]) {
                result++;
            }
            if (i > 0 && (i+1) % personPattern.length==0) {
                index = 0;
                continue;
            }
            index++;
        }
        System.out.println("num:"+num+", result:"+result);
        return new Node(num, result);
    }
}

class Node {
    int index;
    int count;

    public Node(int index, int count) {
        this.index = index;
        this.count = count;
    }

    public int getIndex() {
        return index;
    }

    public int getCount() {
        return count;
    }
}


 */
