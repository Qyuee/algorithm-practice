package algorithm.stream_practice;

import java.util.Arrays;
import java.util.stream.IntStream;

public class P001 {
    public static void main(String[] args) {
        int[] a1 = {1,20,3,4,5,0,6};

        // 정렬하기1 - (오름차순)
        int[] sorted_a1 = IntStream.of(a1).sorted().toArray();
        for (int i : sorted_a1) {
            System.out.print(i+" ");
        }

        System.out.println();
        // 정렬하기2 - (오름차순)
        int[] sorted_a11 = Arrays.stream(a1).sorted().toArray();
        for (int i : sorted_a11) {
            System.out.print(i+" ");
        }

        System.out.println();
        // 필터링
        int[] filtered_a1 = IntStream.of(a1).filter(value -> value > 5).toArray();
        for (int i : filtered_a1) {
            System.out.print(i+" ");
        }

        System.out.println();

        // 정렬+필터링
        int[] filtered_a11 = IntStream.of(a1).sorted().filter(value -> value > 5).toArray();
        for (int i : filtered_a11) {
            System.out.print(i+" ");
        }

        System.out.println();

        // Arrays 스트림 - 필터링
        int[] filtered_a21 = Arrays.stream(a1).filter(value -> value > 5).toArray();
        for (int i : filtered_a21) {
            System.out.print(i+" ");
        }

    }
}
