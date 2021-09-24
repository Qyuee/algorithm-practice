package algorithm.youtube_dongbinna.sorting;

/**
 * 삽입 정렬
 * - 처리되지 않은 데이터를 어느 위치에 위치시킬지 판단하는 로직이 필요한다.
 * - 오르차순으로 가정한다.
 *
 * 핵심은 -> 비교대상 데이터(처리X)를 왼쪽에 위치한 데이터와 일일히 비교하는 것.
 *
 * 시간복잡도
 * - 최대: O(N^2) -> 모두 정렬되어 있지 않을 때.
 * - 최소: O(N) -> 모두 정렬되어 있을 때.
 */
public class InsertSoring {
    public static void main(String[] args) {
        int[] unsorted = {10, 4, 5, 2, 1, 0, 7, 8, 9, 3};
        //int[] sorted = new int[unsorted.length];

        // 가장 첫번째 데이터는 바로 위치시킨다.
        // 첫번째 데이터보다 작으면 index-1, 크면 index+1 한다.
        for (int i = 1; i < unsorted.length; i++) {
            for (int j = i; j > 0; j--) {
                // 10, 4를 비교 -> 4가더 작으므로 10 앞에 위치해야함.
                // 4->temp, 10 -> index + 1, temp -> index
                // 4 10 5
                // 5, 10을 비교 -> 5가 더 적으므로 10 앞에 위치.
                // 5 -> temp, 10 -> index + 1, temp -> index
                // 4 5 10 2
                if (unsorted[j] < unsorted[j-1]) {
                    int temp = unsorted[j-1];
                    unsorted[j-1] = unsorted[j];
                    unsorted[j] = temp;
                }
                // 왼쪽에 있는 원소가 자신보다 작으면 break.
                else break;
            }
        }

        for (int i = 0; i<unsorted.length; i++) {
            System.out.print(unsorted[i]+" ");
        }
    }
}
