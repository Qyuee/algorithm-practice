package algorithm.youtube_dongbinna.sorting;

/**
 * 선택 정렬 - O(N^2)
 * ex) N이 10이면 100번의 연산이 발생한다.
 */
public class SelectSorting {
    public static void main(String[] args) {
        int[] unSorted = {8, 10, 0, 2, 3, 1, 5, 7, 4, 9};

        // 가장 작은 데이터를 맨 앞에 위치시킨다.
        for (int i = 0; i < unSorted.length; i++) {
            // 가장 첫번째 인자 뒤에 있는 모든 인자와 비교한다.
            for (int j = i+1; j < unSorted.length; j++) {
                // 더 작은 인자와 위치를 변경한다.
                if (unSorted[i] > unSorted[j]) {
                    int temp = unSorted[i];
                    unSorted[i] = unSorted[j];
                    unSorted[j] = temp;
                }
            }
        }

        for (int i = 0; i < unSorted.length; i++) {
            System.out.print(unSorted[i]+" ");
        }
    }
}
